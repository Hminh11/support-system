<%-- 
    Document   : EditNoti
    Created on : Oct 18, 2023, 4:32:57 AM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            * {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            form {
                max-width: 80%;
                margin: 0 auto;
                text-align: center;
                padding: 20px;
                background-color: #f5f5f5;
                border-radius: 5px;
            }

            label {
                display: block;
                margin-bottom: 10px;
                font-weight: bold;
            }

            input[type="text"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            button[type="submit"] {
                background-color: #ccc;
                color: #000;
                font-weight: bold;
                border: none;
                border-radius: 5px;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
            }

            button[type="submit"]:hover {
                color: #fff;
                background-color: #555;
            }

            .button {
                background-color: #ccc;
                color: #000;
                border: none;
                border-radius: 5px;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
                font-weight: bold;
                text-decoration: none;
            }

            .button:hover {
                color: #fff;
                background-color: #555;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <%--<%@include file="../header.jsp" %>--%>
        <h5 style="text-align: center; font-weight: bold">Edit Notification</h5>
        <form action="edit" method="post" style="text-align: center">
            <label for="notiID" >Notification ID</label>
            <input type="text" name="notiID" value="${noti.notiID}" style="width: 542px" readonly><br>

            <label for="sentID">Manager</label>
            <input type="text" name="sentID" value="${noti.sentID}" style="width: 500px" readonly><br>

            <label for="receiveID">User</label>
            <input type="text" name="receiveID" value="${noti.receiveID}" style="width: 476px" required><br>
            
            <label for="content" >Content</label>
            <input type="text" name="content" value="${noti.content}" style="width: 500px; height: 300px" required><br>


            <button type="submit">Submit</button>
            &nbsp; &nbsp;
            <a class="button" href="mananoti">Back</a>
        </form>
        <div class="footer" style="padding-top: 2%">
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
