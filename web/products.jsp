<%-- 
    Document   : product.jsp
    Created on : Sep 12, 2023, 3:51:34 PM
    Author     : user
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/product.css"/>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <title>Products</title>
    </head>
    <header><jsp:include page="header.jsp" /></header>
    <body>
        <div class="row">
            <div class="col-md-12">
                <h2 style="padding-top: 10%; text-align: center">Danh Sách Sản Phẩm</h2>
                <ul class="product-list" style="padding-top: 5%">
                    <li>
                        <img src="https://img.ws.mms.shopee.vn/e7ed63050c8be0e6ca7b4c070954fe5a" class="img-product" alt="Sản Phẩm 1">
                        <h3>Sản Phẩm 1</h3>
                        <p>Description 1.</p>
                        <a href="Contact.jsp" class="btn">Contact for sale</a>
                    </li>
                    <li>
                        <img src="https://dongphuchaianh.com/wp-content/uploads/2022/05/dong-phuc-the-duc-cac-truong-thpt-mau-xanh-duong.jpg" class="img-product" alt="Sản Phẩm 2">
                        <h3>Sản Phẩm 2</h3>
                        <p>Description 2.</p>
                        <a href="Contact.jsp" class="btn">Contact for sale</a>
                    </li>
                    <li>
                        <img src="https://mayphuongthao.com/wp-content/uploads/2021/03/dong-phuc-ao-khoac-dong-do-cap-3-1.jpg" class="img-product" alt="Sản Phẩm 3">
                        <h3>Sản Phẩm 3</h3>
                        <p>Description 3.</p>
                        <a href="Contact.jsp" class="btn">Contact for sale</a>
                    </li>
                </ul>
            </div>
        </div>



        <div class="footer" style="padding-top: 2%">
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
