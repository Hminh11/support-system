/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ClassesDAO;
import Model.Detail;
import Model.StudentUser;
import Model.StudentViewUser;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserView extends HttpServlet {

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
            out.println("<title>Servlet UserView</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserView at " + request.getContextPath() + "</h1>");
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
        ClassesDAO dao = new ClassesDAO();
        int type = Integer.parseInt(request.getParameter("typeS"));
        String schoolName = request.getParameter("school");
        String Cl = request.getParameter("classes");
        Teacher tea = dao.getTeacherNameTP(type, schoolName, Cl);
        request.setAttribute("sch", schoolName);
        request.setAttribute("type", type);
        request.setAttribute("cl", Cl);
        request.setAttribute("tea", tea);
        List<StudentUser> listStudent = dao.getAllStudentbyuser(type, schoolName, Cl);
        List<Detail> d = new LinkedList<>();
        List<StudentViewUser> list = new LinkedList<>();
        for (StudentUser e : listStudent) {
            list.add(new StudentViewUser(e, dao.getAllDetailUser(e.getId())));
        }
        int id = dao.getClassID(type, schoolName, Cl);
        request.setAttribute("id", id);
        request.setAttribute("listDetail", list);
        request.getRequestDispatcher("UserView.jsp").forward(request, response);
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
        ClassesDAO dao = new ClassesDAO();
        int type = Integer.parseInt(request.getParameter("typeS"));
        String schoolName = request.getParameter("school");
        String Cl = request.getParameter("classes");
        Teacher tea = dao.getTeacherNameTP(type, schoolName, Cl);
        request.setAttribute("sch", schoolName);
        request.setAttribute("type", type);
        request.setAttribute("cl", Cl);
        request.setAttribute("tea", tea);
        List<StudentUser> listStudent = dao.getAllStudentbyuser(type, schoolName, Cl);
        List<Detail> d = new LinkedList<>();
        List<StudentViewUser> list = new LinkedList<>();
        for (StudentUser e : listStudent) {
            list.add(new StudentViewUser(e, dao.getAllDetailUser(e.getId())));
        }
        int id = dao.getClassID(type, schoolName, Cl);
        request.setAttribute("id", id);
        request.setAttribute("listDetail", list);
        request.getRequestDispatcher("UserView.jsp").forward(request, response);
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
