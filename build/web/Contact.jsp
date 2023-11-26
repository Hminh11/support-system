<%-- 
    Document   : Contact
    Created on : 15-Sep-2023, 15:28:13
    Author     : ghuy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style2.css" rel="stylesheet">
        <link href="./css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
       <header><jsp:include page="header.jsp" /></header>
        <div class="contact-container row" style="text-align: center;">
            <h1 style="padding-top: 10%;text-align: center " >Thông tin liên hệ</h1>
            <div class="contact-info col-lg-6">
                <p><strong>Tên đơn vị:</strong> CÔNG TY CỔ PHẦN ABCD VIỆT NAM</p>
                <p><strong>Trụ sở:</strong> 1 đường ABCD - TP AAAAAA</p>
                <p><strong>VPGD:</strong> xxxxxxxxxxxxxxxxx – TP AAAAAAA</p>
                <p><strong>Tel:</strong> 090 xxxxxxxx</p>
                <p><strong>Fax:</strong> 0280 xxxxxxxxx</p>
                <p><strong>Email:</strong> <a href="mailto:qmaxvietnam1@gmail.com">xxxxxxxxxx@gmail.com</a></p>
            </div>
            <div class="contact-form col-lg-6">
                <h2>Gửi thông tin cá nhân</h2>
            <form id="contact-form" >
                <label for="name">Họ và tên:</label>
                <input type="text" id="name" name="name" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                <label for="phone">Số điện thoại:</label>
                <input type="tel" id="phone" name="phone" required>


                <label for="message">Nội dung:</label>
                <textarea id="message" name="message" rows="4" required></textarea>

                <button type="submit">Gửi</button>
            </form>
            </div>
            
        </div>  
    </body>
</html>
