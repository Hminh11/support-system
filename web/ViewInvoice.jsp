<%-- 
    Document   : ViewInvoice
    Created on : Oct 20, 2023, 1:10:39 PM
    Author     : ^Zin^
--%>
<%@taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/order.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    </head>
    <body>
        <style>
            .confirmed {
                color: green;
            }

            .cancelled {
                color: red;
            }
        </style>
        <header><jsp:include page="header.jsp" /></header>
        <div class="container mt-5">
            <div class="d-flex justify-content-center row" style="margin-top: 10%;margin-bottom: 5%;">
                <div class="col-md-10">
                    <div class="rounded">
                        <div class="table-responsive table-borderless">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>
                                            InVoice#
                                        </th>
                                        <th>School</th>
                                        <th>Class</th>
                                        <th>Name</th>
                                        <th>Phone</th>
                                        <th>Date Created</th>
                                        <th>Detail</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody class="table-body">
                                    <c:forEach items="${list}" var="o">

                                        <tr class="cell-1">
                                            <td>${o.id}</td>
                                            <td>${o.sch}</td>
                                            <td>${o.cl}</td>
                                            <td>${o.tea}</td>
                                            <td>${o.phone}</td>
                                            <td>${o.time}</td>
                                            <td><a href="viewdetail?id=${o.id}" style="color: blue"><i class="fas fa-eye"></i></a>

                                            </td>
                                            <td> <a href="deleteinvoice?pid=${o.id}" class="delete" data-toggle="modal" style="color: red"><i  class="fas fa-times">&#xE872;</i></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>

                </div>
            </div>
            <div style="margin-bottom: 5%">
                <a href="mananoti" class="next">&laquo;Back</a>
            </div>
        </div>

        <footer><jsp:include page="footer.jsp" /></footer>
    </body>
</html>

