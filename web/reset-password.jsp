<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String token = (String)request.getAttribute("token");
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Enter new password</title>
        <link rel="stylesheet" href="./css/bootstrap.css"/>
        <link rel="stylesheet" href="./css/bootstrap.min.css"/>
    </head>

    <body>
        <!--Retype password will be handled using JS, I won't use servlet-->
        <form action="recovery?service=resetPassword" method="POST">
            <p>Enter your password: <input type="password" name="password"></p>
            <p>Re-type your password: <input type="password" name="retype"></p>
            <input type="hidden" name="token" value="<%=token%>">
            <input type="submit" name="submit">
        </form>




    </body>

</html>