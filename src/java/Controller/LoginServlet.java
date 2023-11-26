/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * This servlet handle all login/logout and register function
 *
 * @author ghuy
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();


            //logout 
            if (request.getParameter("logout") != null) { // if user choose to logout
                session.invalidate();
                response.sendRedirect("HomePage.jsp");
                return;
            }
            //login logic
            if (session.getAttribute("username") != null) { // if user alrealy logged before
                response.sendRedirect("HomePage.jsp");
            } else {
                if (request.getParameter("submit") == null) { // user not submitted login form yet
                    request.setAttribute("loginFailed", false);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else { // user clicked on login button form --> handle login logic
                    UserService service = new UserService();

                    String username = request.getParameter("email");
                    String password = request.getParameter("password");

                    boolean status = service.userLogin(username, password);
                    if (status) { // Username and password are correct
                        if (!username.contains("@")) {
                            session.removeAttribute(username);
                            session.setAttribute("username", username);
//                        System.out.println("Current logged in user is: " + username);
                            UserDAO dao = new UserDAO();
                            int roleID = dao.getUserRole(username);
                            session.setAttribute("RoleID", roleID);
                            dao.InsertIntoUserLog(dao.getUserByNameAndPass(username, password).getId() + "", null);
                            session.setAttribute("user", dao.getUserByNameAndPass(username, password));// set phien dang nhap cho user
                            //request.changeSessionId();
                            session.setAttribute("fullname",dao.getFullNameByUsername(username));
                           
//                        request.getRequestDispatcher("trang-chu").forward(request, response);
                        } else {
                            session.removeAttribute(username);
                            session.setAttribute("username", username);
//                        System.out.println("Current logged in user is: " + username);
                            UserDAO dao = new UserDAO();
                            int roleID = dao.getUserRole(dao.getUserByEmail(username).getUsername());
                            session.setAttribute("RoleID", roleID);
                            dao.InsertIntoUserLog(dao.getUserByEmail(username).getId() + "", null);
                            session.setAttribute("user", dao.getUserByEmail(username));// set phien dang nhap cho user
                            session.setAttribute("username",dao.getUserByEmail(username));
                            session.setAttribute("fullname",dao.getFullNameByEmail(username));
                        }

                        response.sendRedirect("HomePage.jsp");
                    } else { // username or password is wrong
                        int maxLoginAttempts = 5;
                        int loginAttempts = 0;

                        if (session.getAttribute(username) != null) {
                            loginAttempts = (int) session.getAttribute(username);
                        }

                        loginAttempts++;
                        session.setAttribute(username, loginAttempts);

                        if (loginAttempts >= maxLoginAttempts) {
                            session.removeAttribute(username);
                            response.sendRedirect("recovery?service=forgotPassword");
                            return;
                        }

                        request.setAttribute("loginFailed", true);
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
