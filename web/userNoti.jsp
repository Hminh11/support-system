<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <title>Manager</title>
        <style>
            /* Reset CSS cho trang */
            body, h1, p, table, button {
                margin: 0;
                padding: 0;
            }

            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                display: flex;
                flex-direction: column;
            }

            /* Phần tiêu đề */
            h1 {
                background-color: #333;
                color: #fff;
                padding: 10px;
                text-align: center;
            }

        

            table {
                width: 80%;
                height: 150px;
                margin: 20px auto;
                border-collapse: collapse;
                background-color: #fff;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
                margin-bottom: 3%;
            }

            table th, table td {
                font-weight: bold;
                padding: 10px;
                background-color: #ddd;
                border-bottom: 1px solid #ddd;
                text-align: center;
                border: 1px solid #fff;

            }

            .filter {
                display: flex;
                justify-content: space-around;
            }

            table:last-child {
                margin-bottom: 40px;
            }

            #btn-show-data {
                position: inherit;
                bottom: 40px;
                right: 180px;
                background-color: #ddd;
                color: #000;
                border: none;
                cursor: pointer;
            }

            #btn-show-data:hover {
                color: #fff;
                background-color: #555;
            }

            .button {
                display: inline-block;
                padding: 10px 20px;
                background-color: #ddd;
                color: #000;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
                position: absolute;
                bottom: 10px;
                right: 10px;
            }

            .button:hover {
                color: #fff;
                background-color: #555;
                text-decoration: none;
            }
            


        </style>
    </head>
    <body>
        <%@include file="./header.jsp" %>
        
        <h5 style="text-align: center; font-weight: bold;margin-top: 7%">Notification</h5>

<!--        <form action="search" method="get" style="text-align: center">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate">
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate">
            <input type="submit" value="Search">
        </form>-->
        <table border="1">
            <thead>
            <th>Notification</th>
            <th>Sent By</th>
        </thead>
        <tbody>
            <c:forEach items="${notis}" var="n">
                <tr>
                    <td>${n.content}</td>
                    <td>${n.sentFullName}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<a href="UserView.jsp" style="margin-bottom: 8%">
        <button id="btn-show-data" 
                class="btn" 
                style="width: 150px; height: 50px; font-weight: bold; font-size: 18px; margin-left: 80%"
                onclick="showData()">
            Show Data
        </button>        
    </a>
    <div class="footer" style="padding-top: 2%">
        <jsp:include page="footer.jsp" />
    </div>
</body>
</html>
