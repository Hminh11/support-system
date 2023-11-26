/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ClassesDAO;
import Model.Detail;
import Model.Student;
import Model.StudentView;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.LinkedList;
import Model.Teacher;

/**
 *
 * @author Admin
 */
public class ManagerView extends HttpServlet {

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
            out.println("<title>Servlet ManagerView</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerView at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        ClassesDAO dao = new ClassesDAO();
        int type = Integer.parseInt(request.getParameter("typeS"));
        String schoolName = request.getParameter("school");
        String cl = request.getParameter("classes");
        request.setAttribute("typeSelected", type);
        request.setAttribute("schoolName", schoolName);
        request.setAttribute("cl", cl);
        Teacher tea = dao.getTeacherNameTP(type, schoolName, cl);
        request.setAttribute("tea", tea);
        List<Student> listStudent = dao.getAllStudent(type, schoolName, cl);
        List<StudentView> list = new ArrayList<>();
        for (Student e : listStudent) {
            list.add(new StudentView(e, dao.getAllDetail(e.getId())));
        }
        int id = dao.getClassID(type, schoolName, cl);
        int iid= dao.getIDinvoice(id);
        request.setAttribute("id", id);
        request.setAttribute("iid", iid);
        request.setAttribute("lock", dao.getLockdata(type, schoolName, cl));
        request.setAttribute("list", list);
        request.getRequestDispatcher("ManagerView.jsp").forward(request, response);;
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        ClassesDAO dao = new ClassesDAO();
        int type = Integer.parseInt(request.getParameter("typeS"));
        String schoolName = request.getParameter("school");
        String cl = request.getParameter("classes");
        request.setAttribute("typeSelected", type);
        request.setAttribute("schoolName", schoolName);
        request.setAttribute("cl", cl);
        Teacher tea = dao.getTeacherNameTP(type, schoolName, cl);
        request.setAttribute("tea", tea);
        List<Student> listStudent = dao.getAllStudent(type, schoolName, cl);
        List<StudentView> list = new ArrayList<>();
        for (Student e : listStudent) {
            list.add(new StudentView(e, dao.getAllDetail(e.getId())));
        }
        int id = dao.getClassID(type, schoolName, cl);
        int iid= dao.getIDinvoice(id);
        request.setAttribute("id", id);
        request.setAttribute("iid", iid);
        request.setAttribute("lock", dao.getLockdata(type, schoolName, cl));
        request.setAttribute("list", list);
        request.getRequestDispatcher("ManagerView.jsp").forward(request, response);;
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
