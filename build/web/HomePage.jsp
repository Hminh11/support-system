<%-- 
    Document   : HomePage
    Created on : 15-Sep-2023, 15:25:44
    Author     : ghuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>trang-chu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <!-- Libraries Stylesheet -->

        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <!-- Customized Bootstrap Stylesheet -->
        <link href="./css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="./css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="./css/business.css"/>
        <link rel="stylesheet" href="./css/product.css"/>

    </head>
    <body>

        <header class="jumbotron topHead" style="padding: 0;">
            <div class="container">
                <div class="row row-header">
                    <div class="col-12 col-sm-6">
                        <jsp:include page="header.jsp" />
                    </div>
                </div>
            </div>
        </header>
        <div class="Home-head" style="border-bottom: 1px solid darkseagreen; padding-bottom: 4%" >

            <div class="BdyAll" style="display: flex;
                 flex-direction: row;
                 flex-wrap: initial;
                 margin-top: 8%">
                <div class="col-md-6" style="padding-top: 10%; padding-left: 3% ">
                    <h1>Công ty Cổ phần <span class="text-primary">ABCD Việt Nam</span></h1>
                    <h6>12 năm hoạt động trong lĩnh vực may đồng phục học sinh và thiết bị trường học</h6>
                    <p>Công ty Cổ phần .... Việt Nam, tiền thân là Công ty Cổ phần Đầu tư và Thiết bị Thăng Long IT - Hà Nội, 
                        đã có truyền thống 12 năm hoạt động trong lĩnh vực may đồng phục học sinh và thiết bị trường học. 
                        Trong nhiều năm qua, công ty chúng tôi đã nhận được sự ủng hộ của Quý thầy cô và nhà trường.</p><!-- comment -->

                    <a href="Contact.jsp" class="btn btn-primary ">Contact us</a>
                </div>
                <div class="col-md-6">
                    <img src="https://xenangnhapkhau.com/wp-content/uploads/2022/01/so-do-quy-trinh-san-xuat-may-mac-2.jpg" style="width: 703px;height: 442px;"/> 
                </div>
                </div>
            </div> 
        </div> 

    

    <div class="about-us"  style="border-bottom: 1px solid darkseagreen; padding-bottom: 5%">
        <div class="BigBdy">
            <div class="BdyAll" style="display: flex;
                 flex-direction: row;
                 flex-wrap: initial;
                 margin-top: 5%">
                <div class="BdyLeft col-md-6">
                    <img src="https://hoshima-int.com/wp-content/uploads/2022/11/quy-trinh-san-xuat-nganh-may-mac-3.jpg" style="width: 703px;height: 442px;"/> 
                </div>
                <div class="BdyRight col-md-6">   

                    <h1 style="padding-left: 35%">About us</h1>     
                    <div  class="BdyRightSmall">
                        <h3>Giới thiệu về công ty:</h3>
                        <p>  Công ty Cổ phần .... Việt Nam, tiền thân là Công ty Cổ phần Đầu tư và Thiết bị Thăng Long IT - Hà Nội, đã có truyền thống 12 năm hoạt động trong lĩnh vực may đồng phục học sinh và thiết bị trường học. Trong nhiều năm qua, công ty chúng tôi đã nhận được sự ủng hộ của Quý thầy cô và nhà trường.</p>                
                        <p>  Để đáp ứng yêu cầu hiện đại hoá trường học, thích ứng với sự phát triển của nhà trường trong giai đoạn mới, công ty chúng tôi chủ trương ngày một đa dạng hoá các mặt hàng với sự hấp dẫn và tiện lợi, chuyên nghiệp như: Đồng phục công sở, đồng phục học sinh sinh viên, vở viết in hình ảnh nhà trường, các loại máy văn phòng, thiết bị trường học… Để nâng cao chất lượng phục vụ quý khách hàng tại địa bàn tỉnh Thái Nguyên, tháng 6 năm 2011 công ty .... chính thức đặt trụ sở tại số ... đường .... - TP Thái Nguyên, Văn phòng giao dịch ,,,,..... – TP Thái Nguyên, tỉnh Thái Nguyên</p>
                        <h2>Mô hình tổ chức:</h2>
                        <p>Hiện nay, chi nhánh chính ..... số .... đường.... - TP Thái Nguyên. .... đang làm việc với trên 90 trường học ( tiểu học, THCS, THPT ) và cả các công ty lớn</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="business-area" style="border-bottom: 1px solid darkseagreen; padding-bottom: 10%">
        <div class="row" style="padding-top: 4%">
            <div class="content col-lg-12" style="padding-bottom: 55px">
                <a>Business Areas</a>
            </div>
        </div>


        <!-- First row with two images and overlay text -->
        <div class="row anh1">
            <div class="img1 col-lg-3">
                <img src="./img/maymac.jpg" />
                <div class="overlay-text" id="overlayText">Exporting Apparel</div>
            </div>
            <div class="img2 col-lg-3">
                <img src="./img/vanphongpham.jpg" />
                <div class= "overlay-text" id="overlayText">Stationery</div>
            </div>
            <div class="img5 col-lg-3">
                <img src="./img/giặt.jpg" />
                <div class="overlay-text" id="overlayText">Industrial Washing</div>
            </div>
        </div>

        <!-- Second row with two images and overlay text -->
        <div class="row anh2">
            <div class="img3 col-lg-3">
                <img src="./img/Thêu công nghiệp1.jpg" />
                <div class="overlay-text" id="overlayText">Industrial Embroidery</div>
            </div>
            <div class="img4 col-lg-3">
                <img src="./img/banhoc.jpg" />
                <div class="overlay-text" id="overlayText">Student Desk</div>
            </div>
            <div class="img6 col-lg-3">
                <img src="./img/in3.jpg" />
                <div class="overlay-text" id="overlayText">Industrial Printing</div>
            </div>
        </div> 
    </div>


    <div class="row">
        <div class="col-md-12">
            <h2 style="padding-top: 3%; text-align: center">Danh Sách Sản Phẩm</h2>
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

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>
</html>
