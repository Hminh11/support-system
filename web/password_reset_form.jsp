<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String token = (String)request.getParameter("token");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Password Reset</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            .form-gap {
                padding-top: 70px;
            }
        </style>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <div class="form-gap"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="text-center">
                                <h3><i class="fa fa-lock fa-4x"></i></h3>
                                <h2 class="text-center">Forgot Password?</h2>
                                <p>You can reset your password here.</p>

                                <h6>${msg}</h6>

                                <div class="panel-body">

                                    <form id="forgot-form" role="form" autocomplete="off" class="form" method="POST" action="recovery?service=forgotPassword">

                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="row">
                                                    <div class="col-md-12" style="display: flex; padding-bottom: 5%">
                                                        <span class="input-group-addon"style="width: auto" ><i class="glyphicon glyphicon-user color-blue"></i></span>
                                                        <input id="username" name="username" placeholder="username" class="form-control"  type="text">
                                                    </div>
                                                    <div class="col-md-12" style="display: flex;padding-bottom: 5%">
                                                        <span class="input-group-addon" style="width: auto"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                                        <input id="email" name="email" placeholder="email address" class="form-control"  type="email">   
                                                    </div>
                                                    <div class="col-md-12" style="display: flex; padding-bottom: 5%">
                                                        <span class="input-group-addon"style="width: auto" ><i class="glyphicon glyphicon-earphone color-blue"></i></span>
                                                        <input id="phonenum" name="phonenum" placeholder="phonenum" class="form-control"  type="text">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        	
                                        <div class="form-group">
                                            <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                                        </div>

                                        <input type="hidden" class="hide" name="token" id="token" value="<%= token %>"> 
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">

        </script>
    </body>
</html>
