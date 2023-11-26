/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.AddnewDAO;
import Model.StudentAdd;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ^Zin^
 */
@MultipartConfig
public class AddnewServlet extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddnewServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddnewServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        Part filePart = request.getPart("file");
        try ( InputStream inp = filePart.getInputStream();  Workbook workbook = new XSSFWorkbook(inp)) {
            Sheet sheet = workbook.getSheetAt(0);
            AddnewDAO dao = new AddnewDAO();
            String sex = "";
            String status = "";
            String name = "";
            Row row = sheet.getRow(1);
            String school = row.getCell(0).getStringCellValue();
            int cap = (int) row.getCell(1).getNumericCellValue();
            String lop = row.getCell(2).getStringCellValue();
            String gvcn = row.getCell(3).getStringCellValue();
            int phone = (int) row.getCell(4).getNumericCellValue();
            List<StudentAdd> list = new ArrayList<>();
            for (int i = 5; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                if (row.getCell(0) != null) {
                    name = row.getCell(0).getStringCellValue();
                }
                if (row.getCell(1).getStringCellValue().equalsIgnoreCase("Nam") && row.getCell(1) != null) {
                    sex = "1";
                } else if (row.getCell(1) != null) {
                    sex = "0";
                }
                if (row.getCell(2) != null) {
                    status = row.getCell(2).getStringCellValue();
                }
                StudentAdd s = new StudentAdd(name, sex, status);
                list.add(s);
            }
            PrintWriter out = response.getWriter();
            String buttonClicked = request.getParameter("buttonClicked");
            response.setContentType("application/json");
            if ("add".equals(buttonClicked)) {
                if (dao.getschoolID(school, cap) == 0) {
                    dao.AddSchool(school, cap);
                    dao.AddClass(dao.getschoolID(school, cap), lop,1);
                    dao.AddTeacher(gvcn,dao.getclassID(lop, dao.getschoolID(school,cap)), phone);
                    for (StudentAdd o : list) {
                        dao.AddStudent(o.getName(), o.getSex(), o.getStatus(), dao.getclassID(lop, dao.getschoolID(school, cap)));
                    }
                    out.println("{\"result\":\"success\", \"message\":\"Data added successfully!\"}");
                } else if (dao.getclassID(lop, dao.getschoolID(school, cap)) == 0) {
                    dao.AddClass(dao.getschoolID(school, cap), lop,1);
                    dao.AddTeacher(gvcn,dao.getclassID(lop, dao.getschoolID(school,cap)), phone);
                    for (StudentAdd o : list) {
                        dao.AddStudent(o.getName(), o.getSex(), o.getStatus(), dao.getclassID(lop, dao.getschoolID(school, cap)));
                    }
                    out.println("{\"result\":\"success\", \"message\":\"Data added successfully!\"}");
                } else {
                    out.println("{\"result\":\"fail\", \"message\":\"Add data failed!! Đã có lớp trong data!!\"}");
                }
            } else {
                out.println("<div class=\"form-group\">\n"
                        + "<h4>" + school + "</h4>\n"
                        + "                            <h4>Cấp:" + cap + " </h4> \n"
                        + "                            <h4>Lớp: " + lop + "</h4> \n"
                        + "                            <h4>Gvcn: " + gvcn + "</h4> \n"
                        + "                            <h4>SÐT: " + phone + "</h4>  "
                        + "                            <table class=\"table\">\n"
                        + "                                <thead>\n"
                        + "                                    <tr>\n"
                        + "                                        <th>Name</th>\n"
                        + "                                        <th>Gender</th>\n"
                        + "                                        <th>Status</th>\n"
                        + "                                    </tr>\n"
                        + "                                </thead>\n"
                        + "                                <tbody class=\"content\">");
                for (StudentAdd o : list) {
                    out.print("<tr>\n"
                            + "  <td>" + o.getName() + "</td>\n");

                    if (o.getSex().equals("1")) {
                        out.print("<td>Nam</td>\n");
                    } else {
                        out.print("<td>Nữ</td>\n");
                    }
                    out.print("<td>" + o.getStatus() + "</td>\n"
                            + " </tr>");
                }
                out.println(" </tbody>\n"
                        + "                            </table>\n"
                        + "                        </div>\n"
                        + "                    </div>");
            }
        } catch (Exception e) {
        }
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
