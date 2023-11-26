<%-- 
    Document   : header
    Created on : 10-Sep-2023, 20:20:31
    Author     : ghuy
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/headerCss.css"/>
        <link rel="stylesheet" href="./css/bootstrap.css"/>
        <link rel="stylesheet" href="./css/bootstrap.min.css"/>
    </head>
    <body>

        <header class="header">
            <a href="HomePage.jsp" class="logo">ABCD</a>
            <nav class="navbar">
                <a href="HomePage.jsp">Home</a>
                <a href="About.jsp">About Us</a>
                <a href="Business.jsp">Business Area</a>
                <a href="products.jsp">Product</a>
                <a href="Contact.jsp">Contact</a><!-- comment -->

                <% if(request.getSession().getAttribute("fullname") != null) { %>
                <a href="#" class="dropdown-toggle"><b>${fullname}</b></a>
                <% } %>    
                <% if(request.getSession().getAttribute("username") == null) { %>      
                <a class="nav-link" href="login">Log in</a>    
                <% } else { %>
                <ul class="dropdown-menu" style="background-color: #00B98E ; color: #fff; margin-left: 77%;width: 200px;">
                    <c:if test="${sessionScope.RoleID == 1}">
                        <li style=" list-style: none;"><a class="text-decoration-none" href="signup">Add Account</a></li>
                        <li style=" list-style: none;"><a class="text-decoration-none" href="listAccount">List Account</a></li>
                        </c:if>
                        <c:if test="${sessionScope.RoleID == 2}">
                        <li style=" list-style: none;width: 300px;"><a class="text-decoration-none" href="mananoti">Manager Screen</a></li>
                        <li style=" list-style: none;width: 300px;"><a class="text-decoration-none" href="viewinvoice">List Invoice</a></li>
                        </c:if>
                        <c:if test="${sessionScope.RoleID == 3}">
                        <li style=" list-style: none;width: 300px;"><a class="text-decoration-none" href="usernoti">User Screen</a></li>
                        </c:if> 

                    <li style=" list-style: none;width: 300px; "><a class="text-decoration-none"  href="recovery?service=forgotPassword">Change Password</a></li>
                    <li style=" list-style: none;"><a class="text-decoration-none" href="login?logout=true">Logout</a></li>
                </ul>
                <% } %>        
            </nav>
            <script src="./js/headerjs.js"></script>
        </header>                  
    </body>
</html>
