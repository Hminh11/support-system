<%-- 
    Document   : About.jsp
    Created on : Sep 12, 2023, 9:10:00 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/AboutCss.css"
    </head>
    <body>
                        <jsp:include page="header.jsp" />

        <div class="BigBdy">
            <div class="BdyAll" style="display: flex;
                     flex-direction: row;
                     flex-wrap: initial;
                     margin-top: 5%">
                <div class="BdyLeft col-md-6">
                    <img src="https://hoshima-int.com/wp-content/uploads/2022/11/quy-trinh-san-xuat-nganh-may-mac-3.jpg" style="width: 759px;height: 551px;"/> 
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
        <div class="footer" style="padding-top: 2%">
            <jsp:include page="footer.jsp" />
        </div>
    </body>

</body>
</html>
