<%-- 
    Document   : listAccount
    Created on : Oct 17, 2023, 1:20:40 AM
    Author     : ghuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Account</title>
    </head>
    <style>
        .content-table{
            border-collapse: collapse;
            margin: auto;
            font-size: 0.9em;
            width: 100%;
            border-radius: 5px 5px 0 0;
            overflow: hidden;
            box-shadow: 0 0 20px rgba(0,0,0,0.15);
        }
        .content-table thead tr{
            background-color: #009879;
            color: #fff;
            text-align: left;
            font-weight: bold;
            
        }
        .content-table th,
        .content-table td{
            padding: 12px 15px;
        }
        .content-table tbody tr{
            border-bottom: 1px solid #ddd;
            
        }
        .content-table tbody tr:nth-of-type(even){
            background-color: #f3f3f3;
        }
        .content-table tbody tr:last-of-type{
            border-bottom: 2px solid  #009879;
        }
        .button{
            background: green;
            color: white;
        }
        .list-account{
            padding-top: 6%;
            display: flex;
            text-align: center;
            justify-content: center;
        }
        
    </style>
    <body>
        <header><jsp:include page="header.jsp" /></header>


        <div class="list-account row">
            <div class="table-list col-lg-auto">
                <table class="content-table">
                    <div class="table-head">
                        <thead >
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Last Login</th>
                                <th scope="col">role</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead> 
                    </div>

                    <tbody>
                        <c:forEach var="o" items="${list}">
                            <tr>
                        <form action="ChangeRole" method="get">
                            <td>${o.id}</td>
                            <td>${o.fullname}</td>
                            <td>${o.email}</td>
                            <td>${o.phone}</td>
                            <td>${o.lastLogin}</td>

                            <td><select id="id" name="role">

                                    <c:forEach var="i" items="${listRole}">
                                        <option ${o.role.roleId == i.roleId?"selected":""} value="${i.roleId}">${i.roleName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <input type="hidden" name="userid" value="${o.id}">

                            <td>
                                <button class="btn btn-button" type="submit" style="text-decoration: none;color: #fff; background: #009879">Change role </button>
                                <a class="btn btn-button" style="text-decoration: none;color: #fff; background: #ff5a5a" href="DeleteAccount?id=${o.id}">Delete</a>
                            </td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>


    </body>
</html>
