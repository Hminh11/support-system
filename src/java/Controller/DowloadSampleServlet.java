/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ^Zin^
 */
public class DowloadSampleServlet extends HttpServlet {

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
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sample-flie");
        Font customFont = workbook.createFont();
        customFont.setBold(true);
        customFont.setFontHeightInPoints((short) 14);
        CellStyle customStyle = workbook.createCellStyle();
        customStyle.setFont(customFont);
        customStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        customStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        customStyle.setAlignment(HorizontalAlignment.CENTER);
        customStyle.setBorderTop(BorderStyle.THIN);
        customStyle.setBorderBottom(BorderStyle.THIN);
        customStyle.setBorderLeft(BorderStyle.THIN);
        customStyle.setBorderRight(BorderStyle.THIN);
        Row headerRow = sheet.createRow(0);
        Font boldFont = workbook.createFont();
        boldFont.setBold(true);
        headerRow.createCell(0).setCellStyle(customStyle);
        headerRow.getCell(0).setCellValue("Trường");
        headerRow.createCell(1).setCellStyle(customStyle);
        headerRow.getCell(1).setCellValue("Cấp(1,2,3)");
        headerRow.createCell(2).setCellStyle(customStyle);
        headerRow.getCell(2).setCellValue("Lớp");
        headerRow.createCell(3).setCellStyle(customStyle);
        headerRow.getCell(3).setCellValue("GVCN");
        headerRow.createCell(4).setCellStyle(customStyle);
        headerRow.getCell(4).setCellValue("SÐT");
        Row row = sheet.createRow(4);
        row.createCell(0).setCellStyle(customStyle);
        row.getCell(0).setCellValue("Họ và tên");
        row.createCell(1).setCellStyle(customStyle);
        row.getCell(1).setCellValue("Giới tính(Nam/Nữ)");
        row.createCell(2).setCellStyle(customStyle);
        row.getCell(2).setCellValue("Note");
        sheet.setColumnWidth(0, 9750); 
        sheet.setColumnWidth(1, 5250);
        sheet.setColumnWidth(2, 5250);
        sheet.setColumnWidth(3, 7680);
        sheet.setColumnWidth(4, 5250);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=Sample-file.xlsx");
        workbook.write(response.getOutputStream());
        workbook.close();
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
