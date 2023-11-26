<%-- 
    Document   : Search
    Created on : Jul 15, 2023, 1:58:38 AM
    Author     : ^Zin^
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/invoice.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-12">   
            <div class="row">
                <div class="receipt-main col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                    <div class="row">
                        <div class="receipt-header">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="receipt-left">
                                    <input type="hidden" value="${schoolName}"  name="school">
                                    <input type="hidden" value="${type}" name="typeS">
                                    <input type="hidden" value="${cl}" name="classes">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <div class="receipt-right">
                                    <h5>ABCD</h5>
                                    <p>090 xxxxxxxx <i class="fa fa-phone"></i></p>
                                    <p>xxxxxxxxxx@gmail.com<i class="fa fa-envelope-o"></i></p>
                                    <p>VN<i class="fa fa-location-arrow"></i></p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="receipt-header receipt-header-mid">
                            <div class="col-xs-8 col-sm-8 col-md-8 text-left">
                                <div class="receipt-right">
                                    <h5>${tea.teacherName}</h5>
                                    <p><b>Mobile :</b> <span style="font-size: 16px;">${tea.tPhoneNum}</span></p>
                                    <p><b>Class :</b> <span style="font-size: 16px;">${cl}</span></p>
                                    <p><b>School :</b> <span style="font-size: 16px;">${sch}</span></p>
                                </div>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-md-4">
                                <div class="receipt-left">
                                    <h3>INVOICE #${Iid} </h3>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Type</th>
                                    <th>Gender</th>
                                    <th>XS</th>
                                    <th>S</th>
                                    <th>M</th>
                                    <th>L</th>
                                    <th>XL</th>
                                    


                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="col-md-9" style="font-size: 20px; text-align: center; align-items: center; padding-top: 20px" rowspan="2">Áo sơ mi</td>
                                    <td class="col-md-9" style="font-size: 17px; text-align: center">Nam</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p1.num1}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p1.num2}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p1.num3}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p1.num4}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p1.num5}</td>
                    

                                </tr>
                                <tr>
                                    <td class="col-md-9" style="font-size: 17px; text-align: center">Nữ</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p2.num1}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p2.num2}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p2.num3}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p2.num4}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p2.num5}</td>
                                   

                                </tr>
                                <tr>
                                    <td class="col-md-9" style="font-size: 20px; text-align: center; align-items: center; padding-top: 20px" colspan="2" >Bộ Thể Thao</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p3.num1}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p3.num2}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p3.num3}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p3.num4}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p3.num5}</td>
                                    

                                </tr>
                                <tr>
                                    <td class="col-md-9" style="font-size: 20px; text-align: center; align-items: center; padding-top: 20px" colspan="2" >Áo Khoác</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p4.num1}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p4.num2}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p4.num3}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p4.num4}</td>
                                    <td class="col-md-3"><i class="fa fa-inr"></i> ${p4.num5}</td>
                                    
                                </tr>
                                <tr>
                                    <td class="text-right" style="text-align: center" colspan="2"><h2><strong>Total: </strong></h2></td>
                                    <td class="text-left text-danger"><h2><strong><i class="fa fa-inr"></i>${p1.num1+p2.num1+p3.num1+p4.num1}</strong></h2></td>
                                    <td class="text-left text-danger"><h2><strong><i class="fa fa-inr"></i>${p1.num2+p2.num2+p3.num2+p4.num2}</strong></h2></td>
                                    <td class="text-left text-danger"><h2><strong><i class="fa fa-inr"></i>${p1.num3+p2.num3+p3.num3+p4.num3}</strong></h2></td>
                                    <td class="text-left text-danger"><h2><strong><i class="fa fa-inr"></i>${p1.num4+p2.num4+p3.num4+p4.num4}</strong></h2></td>
                                    <td class="text-left text-danger"><h2><strong><i class="fa fa-inr"></i>${p1.num5+p2.num5+p3.num5+p4.num5}</strong></h2></td>
                                    
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="row">
                        <div class="receipt-header receipt-header-mid receipt-footer">
                            <div class="col-xs-8 col-sm-8 col-md-8 text-left">
                                <div class="receipt-right">
                                    <p><b>Date :</b> ${i}</p>
                                    <h5 style="color: rgb(140, 140, 140);">Thanks!</h5>
                                </div>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-md-4">
                                <div class="receipt-left">
                                    <h1>Stamp</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="text-align: end;padding: 0;margin: 0;">  
                        <c:if test="${so==1}">
                        <button><a href="ManagerView?typeS=${type}&school=${schoolName}&classes=${cl}" class="btn" style="padding: 2px;padding-right: 6px;padding-left: 6px;color: #000;">Done</a></button>                    
                    </c:if>
                        <c:if test="${so!=1}">
                        <button><a href="viewinvoice" class="btn" style="padding: 2px;padding-right: 6px;padding-left: 6px;color: #000;">Done</a></button>                    
                    </c:if>
                    </div>  
                </div>    
            </div>
        </div>



    </body>
</html>