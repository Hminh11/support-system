/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.ClassesDAO;
import jakarta.mail.Session;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Admin
 */
public class editStudentUser extends HttpServlet {
   
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
        PrintWriter out = response.getWriter();
        String name = request.getParameter("editname");
        String id = request.getParameter("editid");
        String gender = request.getParameter("editgender");
        HttpSession session = request.getSession();
        String fullname = (String) session.getAttribute("fullname");
        int height = Integer.parseInt(request.getParameter("editheight"));
        int weight = Integer.parseInt(request.getParameter("editweight"));
        String somi = request.getParameter("editshirt");
        String thethao = request.getParameter("editsportswear");
        String aokhoac = request.getParameter("editjacket");
        String status = request.getParameter("editstatus");
        String somiSize = request.getParameter("editshirtsize");
        String thethaoSize = request.getParameter("editsportswearsize");
        String aokhoacSize = request.getParameter("editjacketsize");
        int type = Integer.parseInt(request.getParameter("edittype"));
        String schoolName = request.getParameter("editschool");
        String cl = request.getParameter("editclasses");
        ClassesDAO dao = new ClassesDAO();
        int aid = dao.GetIDAccountbyname(fullname);
        dao.UpdateStudentUser(id, name, gender, height, weight, status);
        dao.UpdateEditby(aid,id);
        if (dao.checkDetail(id, "1")) {
            dao.UpdateDetailUser(id, "1", somi,somiSize);
        } else {
            dao.insertIntoDetailUser(id, "1",somi ,somiSize);
        }
        if (dao.checkDetail(id, "2")) {
             dao.UpdateDetailUser(id, "2", thethao,thethaoSize);
        } else {
             dao.insertIntoDetailUser(id, "2", thethao,thethaoSize);
        }
        if (dao.checkDetail(id, "3")) {
             dao.UpdateDetailUser(id, "3", aokhoac,aokhoacSize);
        } else {
             dao.insertIntoDetailUser(id, "3", aokhoac,aokhoacSize);
        }
        try {
            String encodedSchoolName = URLEncoder.encode(schoolName, StandardCharsets.UTF_8.toString());
            response.sendRedirect("UserView?typeS=" + type + "&school=" + encodedSchoolName + "&classes=" + cl);
        } catch (UnsupportedEncodingException e) {
            
        }
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
