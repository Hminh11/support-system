<%-- 
    Document   : ManagerView
    Created on : Sep 17, 2023, 11:33:52 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Controller</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./css/manager.css"/>
        <link rel="stylesheet" href="./css/headerManager.css"/>
        <style>
            .table th,td{
                border: 1px solid #fff;
            }
        </style>


    </head>
    <body>
        <!-- header -->
        <header class="header">
            <a href="HomePage.jsp" class="logo">ABCD</a>
            <nav class="navbar" style="margin: 0;padding: 10px">
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
                        <li class="custom-list-item""><a class="text-decoration-none" href="mananoti" style="background-color: #00B98E;color: white;">Manager Screen</a></li>
                        <li class="custom-list-item"><a class="text-decoration-none" href="viewinvoice" style="background-color: #00B98E;color: white;">List Invoice</a></li>

                    </c:if>
                    <c:if test="${sessionScope.RoleID == 3}">
                        <li style=" list-style: none;width: 300px;"><a class="text-decoration-none" href="usernoti">User Screen</a></li>
                        </c:if> 

                    <li style=" list-style: none; "><a class="text-decoration-none"  href="recovery?service=forgotPassword" style="color: white;background-color: #00B98E">Change Password</a></li>
                    <li style=" list-style: none;"><a class="text-decoration-none" href="login?logout=true" style="background-color: #00B98E;color: white;">Logout</a></li>
                </ul>
                <% } %>        
            </nav>
            <script src="./js/headerjs.js"></script>
        </header> 
        <!-- End Header -->

        <!-- Form search -->
        <div class="Container Bdy" style="padding-top: 10%;">
            <div class="row Bdy-row" style="margin-bottom: 2%">
                <div class="col-10">
                    <div class="DetailFr">
                        <form action="ManagerView" method="post">
                            <div class="Bdy-choose" style="width: 105%">
                                <div style="font-size: 20px">                       
                                    Type: <select name="typeS" id="typeS">
                                        <option value="0" ${typeSelected == "0" ? "selected" : ""} disabled>Select here</option>
                                        <option value="1" ${typeSelected == "1" ? "selected" : ""}>Tiểu Học Cơ Sở</option>
                                        <option value="2" ${typeSelected == "2" ? "selected" : ""}>Trung Học Cơ Sở</option>
                                        <option value="3" ${typeSelected == "3" ? "selected" : ""}>Trung Học Phổ Thông</option>
                                    </select>
                                </div>
                                <div style="font-size: 20px">
                                    School: 
                                    <input type="text" name="school" id="school" value="${schoolName}"required>
                                </div>
                                <div style="font-size: 20px">
                                    Class: 
                                    <input style="width: 30%" type="text" name="classes" id="classes" value="${cl}" required>
                                    <!--                                    <a type="submit" class="btn btn-lg" style="background: #00B98E;color: #fff"><span class="glyphicon glyphicon-search"></span> Search</a>-->
                                    <input type="submit" value="Search">
                                </div>

                            </div>
                        </form>
                    </div>
                    <!-- Teacher information -->
                    <div class="DetailSc">
                        <table style="width: 100%; height: 100px; font-size: 20px ">                    
                            <tr>
                                <c:if test="${id != 0 && id!=null}">
                                    <td style="width: 35%">Teacher: ${tea.teacherName}</td>
                                    <td>Phone Number: ${tea.tPhoneNum}</td>
                                </c:if>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="col-2">
                    <button class="Button-edit" style="margin-bottom: 25px;" type="submit" data-toggle="modal" data-target="#openAdd">Add new</button> <br>
                    <c:if test="${id!=0&&id!=null}">
                        <a href="ViewProduct?typeS=${typeSelected}&school=${schoolName}&classes=${cl}" style="color: #fff"><button class="Button-edit">View Products</button></a> <!--neu nhu ma ko select du thi sex k hien ra button nay -->
                    </c:if>
                </div>
            </div>
            <!-- Table for student information -->                        
            <c:if test="${id != 0 && id!=null}">                     
                <div class="table-bdy">
                    <table  class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Stt</th>
                                <th>Name</th>
                                <th>Giới Tính</th>
                                <th>Chiều Cao</th>
                                <th>Cân Nặng</th>                               
                                <th>Áo sơ mi</th>
                                <th>Size</th>
                                <th>Bộ thể thao</th>
                                <th>Size</th>
                                <th>Áo Khoác</th>
                                <th>Size</th>
                                <th>Status</th>
                                <th>Edited By</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${list}" var="c" varStatus="loop">
                                <tr>

                            <input type="hidden" value="${c.student.id}" name="sid">
                            <td>${loop.index + 1}</td>
                            <td>${c.student.name}</td>
                            <td>
                                <c:if test="${c.student.gender == 1}">
                                    Male
                                </c:if>
                                <c:if test="${c.student.gender == 0}">
                                    Female
                                </c:if>
                            </td>
                            <td>${c.student.height}</td>
                            <td>${c.student.weight}</td>
                            <c:forEach items="${c.detail}" var="o">
                                <td> ${o.numPr}</td>
                                <td> ${o.size}</td>
                            </c:forEach>
                            <td>${c.student.status}</td>
                            <td>${c.student.editBy}</td>
                            <td><a href="#editStudentModal" data-type="${typeSelected}" data-school="${schoolName}" data-classes="${cl}" data-id="${c.student.id}" data-name="${c.student.name}" data-gender="${c.student.gender}" data-height="${c.student.height}" data-weight="${c.student.weight}"
                                   <c:forEach items="${c.detail}" var="o">
                                       data-size="${o.size}"
                                   </c:forEach> 
                                   data-status="${c.student.status}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <!--Note for manager -->
            <div class="Note-warning">                       
                <c:if test="${id == null}">
                    <h1 style="margin-bottom: 4%">Please enter Type, School and Class to review data</h1>
                </c:if>
            </div>
            <c:if test="${id == 0}">                       
                <div class="Note-warning">                                
                    <h2>There is no data by Type: 
                        <c:if test="${typeSelected == 0}"> 
                            ' ',
                        </c:if>
                        <c:if test="${typeSelected == 1}"> 
                            'Tiểu học cơ sở',
                        </c:if>
                        <c:if test="${typeSelected == 2}"> 
                            'Trung học cơ sở',
                        </c:if>
                        <c:if test="${typeSelected == 3}"> 
                            'Trung học phổ thông',
                        </c:if>

                        School: '${schoolName}', 'Class: ${cl}' </h2>        
                </div>
            </c:if>
            <div class="bdy-end" style="margin-bottom: 3%;">
                <div>
                    <button><a href="HomePage.jsp" style="color: white">Back Home</a></button>
                </div>
                <div class="bdy-endButton">
                    <div>
                        <form action="Invoice" method="post">
                            <c:if test="${id!=0&&id!=null&&iid==0}">
                                <input name="id" value="${id}" style="visibility: hidden">
                                <input type="hidden"  name="type" value="${typeSelected}">
                                <input type="hidden"  name="school" value="${schoolName}">
                                <input type="hidden"  name="classes" value="${cl}">
                                <button>Export</button>
                            </c:if>
                        </form>
                    </div>
                    <div style="padding-right: 40px;">
                        <form action="open"> 
                            <c:if test="${id!=0&&lock==0}">
                                <input name="id" value="${id}" style="visibility: hidden">
                                <input type="hidden"  name="type" value="${typeSelected}">
                                <input type="hidden"  name="school" value="${schoolName}">
                                <input type="hidden"  name="classes" value="${cl}">
                                <button>Open Data</button>
                            </c:if>
                        </form>
                        <form action="lock">
                            <c:if test="${id!=0&&lock==1}">
                                <input name="id" value="${id}" style="visibility: hidden">
                                <input type="hidden"  name="type" value="${typeSelected}">
                                <input type="hidden"  name="school" value="${schoolName}">
                                <input type="hidden"  name="classes" value="${cl}">
                                <button type="submit">Lock Data</button>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Add Data form -->                            
        <form form-type="form1" name="form1" id="form1" method="POST" enctype="multipart/form-data">
            <div id="openAdd" class="modal fade">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content mc1">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add New</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body md1">					
                            <div class="form-group fm1">
                                <div class="custom-file">
                                    <p class="note">Tải excel lên ở đây:</p>
                                    <input onchange="check(this)" type="file" class="custom-file-input" name="file" id="customFile" required>
                                </div>
                                <div class="file-description">
                                    <p class="">Chưa có tải ở đây: <a href="<%= request.getContextPath() %>/dow">Tải file về</a></p>
                                </div>
                                <p class="note">Chú ý: file Excel phải dùng bản 2007 trở lên(có đuôi .xlsx) và phải tuân theo cấu trúc cho sẵn.</p>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">                             
                            <button disabled="false" data-form-type="form1" name="add" id="submitBtn" value="preview" type="submit" class="btn btn-success" data-toggle="modal" data-target="#addEmployeeModal">
                                <i class="material-icons"></i><span>Add Student</span>
                            </button>
                        </div>

                    </div>
                </div>
            </div>

            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">						
                            <h4 class="modal-title">Preview Data</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <<h4>title</h4>>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Gender</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody class="content">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <button data-form-type="form1" value="add" name="add" type="submit" class="btn btn-success" data-toggle="modal" data-target="#addEmployeeModal">
                                <i class="material-icons"></i><span>Confirmed</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- End Add data form -->
        <!-- Edit Student form -->
        <div id="editStudentModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="editStudentManager" method="POST" onsubmit="return validateName()">                
                        <input type="hidden"  name="edittype" id="editType">
                        <input type="hidden"  name="editschool" id="editSchool">
                        <input type="hidden"  name="editclasses" id="editClasses">
                        <input type="hidden" name="editid" id="editID">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Student</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" oninput="validateName()" name="editname" id="editName" class="form-control" required>
                                <div id="nameError" style="color: red;"></div>
                            </div>
                            <div class="form-group">
                                <label>Gender</label>
                                <select name="editgender" id="editGender" class="form-control">
                                    <option value="1">Male</option>
                                    <option value="0">Female</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Status</label>
                                <input type="text" name="editstatus" id="editStatus" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Chiều cao</label>
                                <input type="number" min="0" name="editheight" id="editHeight" class="form-control" required readonly>
                            </div>
                            <div class="form-group">
                                <label>Cân nặng</label>
                                <input type="number" min="0" name="editweight" id="editWeight" class="form-control" required readonly>
                            </div>
                            <div class="form-group">
                                <label>Size</label>
                                <select name="editsize" id="editSize" class="form-control" required>
                                    <option value="" disabled>Select</option>
                                    <option value="XS">XS</option>
                                    <option value="S">S</option>
                                    <option value="M">M</option>
                                    <option value="L">L</option>
                                    <option value="XL">XL</option>                                
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- End Edit Student form -->
        <!-- Footer -->
        <footer id="footer" class="footer-entertainment" style="background-color: #00B98E;color: white;padding-top: 2%;padding-bottom: 3%"> 
            <div class="container">
                <div class="row footer-row">
                    <div class="col-sm-5">
                        <div class="widget">
                            <h5 class="widget-title">C&#244;ng ty cổ phần đầu tư v&#224; thương mại ABC</h5>
                            <p><strong>Trụ sở:</strong> 1 đường ABCD - TP AAAAAA</p>
                            <p><strong>VPGD:</strong> xxxxxxxxxxxxxxxxx – TP AAAAAAA</p>
                            <p><strong>Tel:</strong> 090 xxxxxxxx</p>

                        </div>
                    </div>

                    <div class="col-sm-3">
                        <div class="widget">
                            <h5 class="widget-title">Li&#234;n kết trang</h5>

                            <ul class="widget-ul" style="margin-left: 0px;">
                                <li><a style="color: white" href="#">Profile</a></li>
                                <li><a style="color: white" href="#">Fashion</a></li>
                                <li><a style="color: white" href="#">Ch&#237;nh s&#225;ch bảo mật</a></li>
                                <li><a style="color: white" href="/trang-ca-nhan/dang-nhap">Phản &#225;nh khiếu nại</a></li>
                            </ul>

                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="widget widget_recent_posts">
                            <h5 class="widget-title">Tin mới nhất</h5>

                            <ul class="widget-ul" style="margin-left: 0px;">
                                <li><a style="color: white" href="#">Doanh nghiệp nộp thuế </a></li>
                                <li><a style="color: white" href="#">Th&#244;ng b&#225;o mời ch&#224;o h&#224;ng cạnh tranh g&#243;i thầu: Thu&#234; m&#225;y m&#243;c thiết bị ng&#224;nh may năm 2023</a></li>
                                <li><a style="color: white" href="#">Th&#244;ng b&#225;o vv Mời thầu&quot; Dịch vụ thu gom, vận chuyển, xử l&#253; chất thải nguy hại năm 2023-2024&quot;</a></li>
                            </ul>

                        </div>
                    </div>

                </div>

            </div>
        </footer>
        <!--End footer-->
        <script>
            $(document).ready(function () {
                $("form").submit(function (e) {
                    var formType = $(this).find("button[type=submit]").data("form-type");
                    if (formType === "form1") {
                        e.preventDefault();
                        var buttonClicked = $("button[type=submit][clicked=true]").val();
                        var formData = new FormData($(this)[0]);
                        // Đưa giá trị nút bấm vào dữ liệu gửi đi
                        formData.append("buttonClicked", buttonClicked);
                        $.ajax({
                            type: "POST",
                            url: "add",
                            data: formData,
                            processData: false,
                            contentType: false,
                            success: function (response) {
                                $("#addEmployeeModal .modal-body").html(response.message);
                                if (response.result === "success") {
                                    alert(response.message);
                                } else if (response.result === "fail") {
                                    alert(response.message);
                                }
                            },
                            error: function (error) {
                                //alert("Error: " + error.responseText);
                                $("#addEmployeeModal .modal-body").html(error.responseText);
                            }
                        });
                    }
                });
                $("button[type=submit]").click(function () {
                    $("button[type=submit]").removeAttr("clicked");
                    $(this).attr("clicked", "true");
                });
            });
            //lay du lieu ve form
            $(document).ready(function () {
                // Bắt sự kiện click trên nút "Edit"
                $('.edit').click(function () {
                    var type = $(this).data('type');
                    var school = $(this).data('school');
                    var classes = $(this).data('classes');
                    var id = $(this).data('id');
                    var name = $(this).data('name');
                    var gender = $(this).data('gender');
                    var height = $(this).data('height');
                    var weight = $(this).data('weight');
                    var size = $(this).data('size');
//                    var shirt = $(this).data('shirt');
//                    var sportswear = $(this).data('sportswear');
//                    var jacket = $(this).data('jacket');
                    var status = $(this).data('status');
                    // Điền giá trị vào trường "Name" trong modal
                    $('#editType').val(type);
                    $('#editSchool').val(school);
                    $('#editClasses').val(classes);
                    $('#editID').val(id);
                    $('#editName').val(name);
                    $('#editGender').val(gender);
                    $('#editStatus').val(status);
                    $('#editHeight').val(height);
                    $('#editWeight').val(weight);
                    $('#editSize').val(size);
                });
            });
            //kiểm tra tên học sinh đúng cú pháp không
            function validateName() {
                const nameInput = document.querySelector('input[name="editname"]');
                const nameValue = nameInput.value;

                const pattern = /^[A-Za-zÀ-Ỹà-ỹ ]+$/; // Chỉ chữ cái và tiếng Việt

                if (!pattern.test(nameValue)) {
                    // Nếu chuỗi không hợp lệ, hiển thị thông báo lỗi
                    document.getElementById("nameError").innerText = "Tên chỉ được chứa chữ cái và tiếng Việt";
                    return false;
                } else {
                    // Nếu chuỗi hợp lệ, xóa thông báo lỗi
                    document.getElementById("nameError").innerText = "";
                    return true;
                }
            }
            function check(input) {

                const file = input.files[0];
                var submitButton = document.getElementById('submitBtn');
                if (file) {
                    const fileName = file.name;
                    if (!fileName.endsWith(".xlsx")) {
                        alert("File không phải là file Excel xlsx.");
                        input.value = "";
                        submitButton.disabled = true;
                    } else {
                        submitButton.disabled = false;
                    }
                } else {
                    submitButton.disabled = false;
                    alert("Vui lòng ch?n file");
                }
                return true;
            }
            ;
        </script>

    </body>
</html>
