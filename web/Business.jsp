<%-- 
    Document   : Business
    Created on : Sep 12, 2023, 9:20:13 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Meta information -->
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>

        <!-- Link to custom CSS file -->
        <link rel="stylesheet" href="./css/business.css" />

        <!-- Link to Bootstrap CSS, Font Awesome, and Bootstrap Social CSS files -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="node_modules/bootstrap-social/bootstrap-social.css" />
    </head>
    <body>
        <!-- Header section -->

        <header><jsp:include page="header.jsp" /></header>

        
        <div class="row" style="padding-top: 7%">
            <div class="content col-lg-12">
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


        <!-- Third row with two images and overlay text -->
        <div class="footer" style="padding-top: 2%">
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>