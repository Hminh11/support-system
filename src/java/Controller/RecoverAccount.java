/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Service.UserService;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Properties;
import java.time.LocalDateTime;
import Model.PasswordReset;
import Model.User;
/**
 * Handle logic for forgot-password functionality. Server will use email address
 * gianghuy753@gmail.com for sending the email
 *
 * @author ghuy
 */
@WebServlet(name = "RecoverAccount", urlPatterns = {"/recovery"})
public class RecoverAccount extends HttpServlet {

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
            String service = request.getParameter("service");

            UserService uService = new UserService();

            if (service == null) {
                service = "forgotPassword";
            }
            switch (service) {
                case "forgotPassword": // handle login when user choose forgot password
                    if (request.getParameter("recover-submit") == null) { // user navigate to forgot-password form, not yet submit
                        request.getRequestDispatcher("/password_reset_form.jsp").forward(request, response);
                        return;
                    } else { // user submit the form
                        String usename = request.getParameter("username");
                        User user1 = uService.getUserByUsername(usename);
                        if (user1 != null) {
                            String phoneNum = request.getParameter("phonenum");
                            User user2 = uService.getUserByPhone(phoneNum);
                            if (user2 != null) {
                                String email = request.getParameter("email");
                                User user = uService.getUserByEmail(email);
                                if (user != null) { // if email exist in the DB --> send reset password email
                                    // generate url token for password reset
                                    String token = generateToken();
                                    // add record (email, token) to DB
                                    LocalDateTime now = LocalDateTime.now();
                                    LocalDateTime expire = now.plusMinutes(10);
                                    PasswordReset pwdR = new PasswordReset(email, token, expire);
                                    uService.addPasswordReset(pwdR);

                                    sendEmail("gianghuy753@gmail.com", email, token);

                                    request.setAttribute("msg", "Please check your email for password reset URL");
                                    request.getRequestDispatcher("/password_reset_form.jsp").forward(request, response);
                                } else { // email does not exist in the DB
                                    request.setAttribute("msg", "Email does not exist");
                                    request.getRequestDispatcher("/password_reset_form.jsp").forward(request, response);
                                }
                                return;
                            } else {
                                request.setAttribute("msg", "Phone Number is wrong");
                                request.getRequestDispatcher("/password_reset_form.jsp").forward(request, response);
                            }
                            return;
                        } else {
                            request.setAttribute("msg", "User Name does not exist");
                            request.getRequestDispatcher("/password_reset_form.jsp").forward(request, response);
                        }
                        return;

                    }

                case "resetPassword": // logic when user click on reset password url sent to email
                    String token = request.getParameter("token");
                    if (uService.checkValidToken(token)) {
                        if (request.getParameter("submit") != null) { // user submit reset form --> change user password
                            String password = request.getParameter("password");
                            uService.changeUserPassword(password, token);
                            response.sendRedirect("/SWP-Project/login");
                        } else { // navigate user to reset password form
                            request.setAttribute("token", token);
                            request.getRequestDispatcher("/reset-password.jsp").forward(request, response);
                            return;
                        }
                    } else {
                        request.setAttribute("msg", "Invalid token, or token has been expired");
                        request.getRequestDispatcher("/SWP-Project/HomePage.jsp").forward(request, response);
                        return;
                    }

                    break;
            }
        }
    }

    private String generateToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        System.out.println("Token length: " + token.length());
        return token;
    }

    /**
     * Send reset password email to user
     *
     * @param sendFrom
     * @param sendTo
     * @param token
     */
    private void sendEmail(String sendFrom, String sendTo, String token) {
        String username = "gianghuy753@gmail.com";
        String password = "zxufxlegsnzexttr";

        Properties prop = new Properties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        jakarta.mail.Session session = jakarta.mail.Session.getInstance(prop, new jakarta.mail.Authenticator() {
            @Override
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendFrom));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(sendTo));
            message.setSubject("Password reset");

            String msg = "Hi, you are requesting to reset you password. Here is the link to reset your password: "
                    + "<a href=\"http://localhost:9999//SWP-Project/recovery?service=resetPassword&token=" + token + "\" target=\"_blank\">reset password</a>";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println("Messeage exception: " + e.getMessage());
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
