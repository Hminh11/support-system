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
                height: 300px;
                margin: 20px auto;
                border-collapse: collapse;
                background-color: #fff;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
            }

            table {
                width: 80%;
                height: 100px;
                margin: 20px auto;
                border-collapse: collapse;
                background-color: #fff;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
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
                padding: 10px 20px;
                background-color: #ddd;
                color: #000;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
                position: absolute;
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
        <h5 style="text-align: center; font-weight: bold;padding-top: 7%">Notification</h5>
        <table>
            <thead>
                <tr>
                    <th>Content</th>
                    <th>Sent Time</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${notis}" var="n">
                    <tr>
                        <td>${n.content}</td>
                        <td>
                            ${n.sentDate}
                        </td>
                        <td>${n.sentFullName}</td>
                        <td>${n.receiveFullName}</td>

                        <td>

                            <a href="edit?nid=${n.notiID}">Edit</a> 
                            &nbsp; | &nbsp; 
                            <a href="delete?nid=${n.notiID}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <table style="margin-bottom: 3%">
            <tbody>
                <tr>
                    <td>History User</td>
                <tr>
                    <td style="height: 10%">
                        <ul class="pagination justify-content-center" ">
                            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                        </ul>
                    </td> 
                </tr>
                </tr>
            </tbody>
        </table>
        <a class="button"
           style="width: 200px; height: 50px; font-weight: bold; font-size: 19px;margin-left: 66%;"
           href="send">Send Notification
        </a>
        <a href="ManagerView.jsp" >
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