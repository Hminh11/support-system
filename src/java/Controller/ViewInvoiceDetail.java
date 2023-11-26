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
public class ViewInvoiceDetail extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       ClassesDAO dao = new ClassesDAO();
        int Iid = (int) Integer.parseInt(request.getParameter("id"));
        int id = dao.getClassIDbyInvoiceID(Iid);
        Teacher tea = dao.getTeacherbyClassID(id);
        InvoiceP p1 = new InvoiceP(dao.GetNumPbyGender(id, 1, "XS", 1), dao.GetNumPbyGender(id, 1, "S", 1), dao.GetNumPbyGender(id, 1, "M", 1), dao.GetNumPbyGender(id, 1, "L", 1),
                dao.GetNumPbyGender(id, 1, "XL", 1));
        InvoiceP p2 = new InvoiceP(dao.GetNumPbyGender(id, 1, "XS", 0), dao.GetNumPbyGender(id, 1, "S", 0), dao.GetNumPbyGender(id, 1, "M", 0), dao.GetNumPbyGender(id, 1, "L", 0),
                dao.GetNumPbyGender(id, 1, "XL", 0));
        InvoiceP p3 = new InvoiceP(dao.GetNumP(id, 2, "XS"), dao.GetNumP(id, 2, "S"), dao.GetNumP(id, 2, "M"),
                dao.GetNumP(id, 2, "L"), dao.GetNumP(id, 2, "XL"));
        InvoiceP p4 = new InvoiceP(dao.GetNumP(id, 3, "XS"), dao.GetNumP(id, 3, "S"), dao.GetNumP(id, 3, "M"),
                dao.GetNumP(id, 3, "L"), dao.GetNumP(id, 3, "XL"));
        request.setAttribute("p1", p1);
        request.setAttribute("p2", p2);
        request.setAttribute("p3", p3);
        request.setAttribute("p4", p4);
        request.setAttribute("Iid", Iid);
        request.setAttribute("sch", dao.getSchoolnamebyClassID(id));
        request.setAttribute("tea", tea);
        request.setAttribute("i", dao.getDatebyInvoiceID(Iid));
        request.setAttribute("cl", dao.getClassName(id));
        request.getRequestDispatcher("Invoice.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
