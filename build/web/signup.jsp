<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Registration  </title> 
        <link rel="stylesheet" href="./css/signup-style.css">
    </head>
    <body>
        <div class="wrapper">
            <div class="title"><span>Add Account</span></div>

            <form action="signup" method="POST">
                <div class="input-box">
                    <input type="text" placeholder="Enter your name" required name="username">
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter your full name" required name="fullname">
                </div>
                <div class="input-box">
                    <input type="email" placeholder="Enter your email" required name="email">
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter your Phone Number" required name="phonenum">
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Create password" required name="password">
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Confirm password" required name="retype_password">
                </div>
                <div class="policy">
                    <h3>Role :    <select id="id" name="role">
                        <option value="2">Manager</option>
                        <option value="3">User</option>
                    </select> </h3>
                </div>
                <% if((Boolean)request.getAttribute("addFailed")) { %>
                <p style="color:red">${sessionScope.Status}</p>
                <% } %>
                <div class="input-box button">
                    <input name="submit" type="Submit" value="submit">
                </div>
            </form>
        </div>
    </body>
</html>