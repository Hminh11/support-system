<%-- 
    Document   : SendNoti
    Created on : Oct 14, 2023, 3:00:26 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Notifications</title>
        <script src="ckeditor/ckeditor.js"></script>
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
                border: none;
                border-radius: 5px;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
                font-weight: bold;
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
        <div class="Header" style="padding-top: 2%;margin-bottom: 5%;">
            <jsp:include page="header.jsp" />
        </div>
        <h5 style="text-align: center; font-weight: bold">Send Notification</h5>
        <form action="send" method="post" style="text-align: center"><br>

            <label for="receiveID" >User</label>
            <!--                        <input type="text" name="receiveID" style="width: 500px" required><br>-->
            <select id="receiveID" name="receiveID" style="width: 474px;">User
                <option selected="selected" disabled>select user</option>
                <c:forEach items="${list}" var="c">
                    <option value="${c.id}">${c.username}</option>
                </c:forEach>
            </select><br>

            <label for="content" >Content</label>
            <input type="text" name="content" style="width: 500px; height: 300px" required><br>

            <button type="submit">Send</button>
            &nbsp; &nbsp;
            <a class="button" href="mananoti">Back</a>

            <script>
                CKEDITOR.replace('content');
            </script>
        </form>
        <div class="footer" style="padding-top: 2%">
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
