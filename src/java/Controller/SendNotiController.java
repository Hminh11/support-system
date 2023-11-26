/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ClassesDAO;
import DAO.NotificationDAO;
import DAO.UserDAO;
import Model.Notification;
import Model.Role;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SendNotiController", urlPatterns = {"/send"})
public class SendNotiController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SendNotiController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendNotiController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        NotificationDAO notiDAO = new NotificationDAO();
        List<Notification> notis = notiDAO.getAllNotifications();

        request.setAttribute("notis", notis);

        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<User> list = dao.getAllStaff();
        request.setAttribute("list", list);
        request.getRequestDispatcher("SendNoti.jsp").forward(request, response);
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
        String ncontent = request.getParameter("content");
        int nreceiveID = Integer.parseInt(request.getParameter("receiveID"));
        HttpSession session = request.getSession();
        String fullname = (String) session.getAttribute("fullname");
        ClassesDAO Dao = new ClassesDAO();

        int nsentID = Dao.GetIDAccountbyname(fullname);

        NotificationDAO dao = new NotificationDAO();
        dao.insertNotification(ncontent, nreceiveID, nsentID);
        response.sendRedirect("mananoti");
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
