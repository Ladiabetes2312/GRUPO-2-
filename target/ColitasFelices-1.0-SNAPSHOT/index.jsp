<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/sb-admin-2.min.css"> 
    </head>
    <body class="bg-gradient-primary">
        <%
            HttpSession session1 = request.getSession(false);
            if (session1 != null && session1.getAttribute("usuario") != null) {
                response.sendRedirect("menu.jsp");
            }
        %>
        <div class="container">      
            <div class="row justify-content-center">
                <div class="col-xl-10 col-lg-12 col-md-9">
                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <img src="css/logo3.png">
                            <div class="container">
                                <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">Bienvenido!</h1>
                                        </div>
                                        <form action="LoginServlet" method="post">
                                            <div class="form-group">
                                                <input type="text" id="txtuser" name="txtuser" class="form-control form-control-user" placeholder="Usuario" maxlength="20" required>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control form-control-user"
                                                       id="txtpass" name="txtpass" placeholder="Password" maxlength="20" required>
                                            </div>
                                            <input type="submit" class="btn btn-primary btn-user btn-block">
                                            <hr>
                                        </form>
                                        <hr>
                                        <div class="text-center">
                                            <a class="small" href="forgotPassword.jsp">Olvidaste tu Contraseña?</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>