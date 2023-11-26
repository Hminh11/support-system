/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ClassesDAO;
import Model.InvoiceP;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class Invoice extends HttpServlet {

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
            out.println("<title>Servlet Invoice</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Invoice at " + request.getContextPath() + "</h1>");
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
        int id = (int) Integer.parseInt(request.getParameter("id"));
        int type = Integer.parseInt(request.getParameter("type"));
        String schoolName = request.getParameter("school");
        String cl = request.getParameter("classes");
        ClassesDAO dao = new ClassesDAO();
        Teacher tea = dao.getTeacherbyClassID(id);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        dao.insertIntoInvoice(date, id);
        InvoiceP p1 = new InvoiceP(dao.GetNumPbyGender(id, 1, "XS", 1), dao.GetNumPbyGender(id, 1, "S", 1), dao.GetNumPbyGender(id, 1, "M", 1), dao.GetNumPbyGender(id, 1, "L", 1),
                dao.GetNumPbyGender(id, 1, "XL", 1));
        InvoiceP p2 = new InvoiceP(dao.GetNumPbyGender(id, 1, "XS", 0), dao.GetNumPbyGender(id, 1, "S", 0), dao.GetNumPbyGender(id, 1, "M", 0), dao.GetNumPbyGender(id, 1, "L", 0),
                dao.GetNumPbyGender(id, 1, "XL", 0));
        InvoiceP p3 = new InvoiceP(dao.GetNumP(id, 2, "XS"), dao.GetNumP(id, 2, "S"), dao.GetNumP(id, 2, "M"),
                dao.GetNumP(id, 2, "L"), dao.GetNumP(id, 2, "XL"));
        InvoiceP p4 = new InvoiceP(dao.GetNumP(id, 3, "XS"), dao.GetNumP(id, 3, "S"), dao.GetNumP(id, 3, "M"),
                dao.GetNumP(id, 3, "L"), dao.GetNumP(id, 3, "XL"));
        dao.lockdata(id);
        request.setAttribute("p1", p1);
        request.setAttribute("p2", p2);
        request.setAttribute("p3", p3);
        request.setAttribute("p4", p4);
        request.setAttribute("Iid", dao.getIDinvoice(id));
        request.setAttribute("sch", dao.getSchoolnamebyClassID(id));
        request.setAttribute("tea", tea);
        request.setAttribute("i", date);
        request.setAttribute("cl", dao.getClassName(id));
        request.setAttribute("type", type);
        request.setAttribute("schoolName", schoolName);
        request.setAttribute("cl", cl);
         request.setAttribute("so",1);
        request.getRequestDispatcher("Invoice.jsp").forward(request, response);
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
