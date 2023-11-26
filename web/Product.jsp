
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:hover {
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            color: white;
        }
        img:hover{
            transform: scale(1.1);
        }
        img{
            transition: 1s;
            transform: scale(1);
        }
    </style>
    <body>
        <div class="Header">
            <jsp:include page="header.jsp" />
        </div>
        <div class="row" style="margin-top: 10%;">
            <div class="header-select" >
                <h3 style="display: flex;justify-content: center;justify-items: center">Product view</h3>
                <form id="form" action="ViewProduct" method="post">
                    <select id="id" name="select" class="form-select" style="width: 8%;margin-left: 90%">
                        <option ${pid == 1 ?"selected":""} value="1">Áo sơ mi</option>
                        <option ${pid == 2 ?"selected":""} value="2">Bộ thể thao</option>
                        <option ${pid == 3 ?"selected":""} value="3">Áo khoác</option>
                    </select>
                    <input type="hidden" value="${schoolName}" name="school">
                    <input type="hidden" value="${typeSelected}" name="typeS">
                    <input type="hidden" value="${cl}" name="classes">
                </form>
            </div>

            <div id="tableWrapper" class="container row" style="padding-top:1%">


                <div class="tableHalf col-md-6">
                    <table class="table" id="customers">
                        <thead style="background: #00B98E">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Name</th>
                                <th scope="col">Image</th>
                            </tr>
                        </thead>
                        <tbody style="background-color: #ddd;border: 1px solid #ddd;">
                            <tr >
                                <th scope="row">1</th>
                                <th scope="row">name</th>
                                <th scope="row"><img class="img_default" style="width: 550px;height: 450px;margin-left: 13%;" src="https://img.ws.mms.shopee.vn/e7ed63050c8be0e6ca7b4c070954fe5a" alt="alt"/> </th>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="tableHalf col-md-6">
                    <table class="table" id="customers">
                        <thead style="background: #00B98E">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Name</th>
                                <th scope="col">Image</th>
                            </tr>
                        </thead>
                        <tbody style="background-color: #ddd;">
                        <form action="addLogo" method="post">
                            <input type="hidden" name="pid" value="${pid}">
                            <input type="hidden" value="${schoolName}" name="school">
                            <input type="hidden" value="${typeSelected}" name="type">
                            <input type="hidden" value="${cl}" name="classes">
                            <tr>
                                <th scope="row">1</th>
                                <th scope="row">Link</th>
                                <th scope="row" style="display: flex;flex-direction: column">
                                    <input class="form-input" required="" value="${lo.image}" style="margin-bottom: 10px" type="text" name="img">

                                    <c:if test="${lo.image == null}">
                                        Add image to show...
                                        <button class="btn btn-button" style="color: white; width: 25%;margin-left: 75%;background: #00B98E " type="submit">ADD</button>
                                    </c:if>

                                    <c:if test="${lo.image != null}">
                                        <input type="hidden" value="${cl}" name="check">
                                        <img style="width: 450px;height: 358px;margin-left: 17%;" src="${lo.image}" alt="alt"/>
                                        <div style="display: flex;margin-top: 2%">
                                            <button class="btn btn-button" style="color: white; width: 25%;margin-left: 73%;background: #00B98E " type="submit">Save</button>
                                            <a href="ManagerView?typeS=${typeSelected}&school=${schoolName}&classes=${cl}" class="btn btn-button" style="padding: 6px;padding-right: 6px;padding-left: 6px;margin-left: 2%;background-color: #00B98E;color: #FFF">Cancel</a>                  
                                        </div>

                                    </c:if>
                                </th>
                            </tr>
                        </form>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="footer" style="padding-top: 2%">
            <jsp:include page="footer.jsp" />
        </div>                           





    </body>
</html>
<script>
    // Select the <select> element by its ID
    var select = document.getElementById('id');
    var img_default = document.querySelector('.img_default');

    // Add an event listener to the select element to detect changes
    select.addEventListener('change', function () {
        // Get the selected value
        var selectedValue = select.value;

        // Update the image source based on the selected value
        if (selectedValue === "1") {
            img_default.src = "https://img.ws.mms.shopee.vn/e7ed63050c8be0e6ca7b4c070954fe5a";
        } else if (selectedValue === "2") {
            img_default.src = "https://dongphuchaianh.com/wp-content/uploads/2022/05/dong-phuc-the-duc-cac-truong-thpt-mau-xanh-duong.jpg";
        } else if (selectedValue === "3") {
            img_default.src = "https://mayphuongthao.com/wp-content/uploads/2021/03/dong-phuc-ao-khoac-dong-do-cap-3-1.jpg";
        } else {
            // Handle other cases or set a default image
            img_default.src = ""; // Set a default empty image source
        }
    });

    // Initial image update when the page loads
    img_default.src = "https://img.ws.mms.shopee.vn/e7ed63050c8be0e6ca7b4c070954fe5a"; // Set the default image
</script>