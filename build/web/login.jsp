<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Login</title> 
    <link rel="stylesheet" href="./css/login-style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
  </head>
  <body>
    <div class="container">
      <div class="wrapper">
        <div class="title"><span>Login Form</span></div>
        
        <form action="login" method="POST">
          <div class="row">
            <i class="fas fa-user"></i>
            <input name="email" type="text" placeholder="Email or UserName" required>
          </div>
          <div class="row">
            <i class="fas fa-lock"></i>
            <input name="password" type="password" placeholder="Password" required>
          </div>
            ${loginAttemptCount}
            <% if((Boolean)request.getAttribute("loginFailed")) { %>
            <p style="color:red">The username or password is incorrect. Please try again</p>
            <% } %>
          <div class="pass"><a href="recovery?service=forgotPassword">Forgot password?</a></div>
          <div class="row button">
            <input type="submit" value="Login">
            <input type="hidden" name="submit" value="login">
          </div>
        </form>
          
      </div>
    </div>

  </body>
</html>