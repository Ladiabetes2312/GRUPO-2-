<%-- 
    Document   : Usuarios
    Created on : 3 jul. 2024, 18:05:33
    Author     : josel
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Login"%>
<%@page import="Dao.UsuariosDao"%>
<%@page import="Conexion.Conexion"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Sistema Veterinaria</title>
        <link href="css/stylesp.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.3/dist/sweetalert2.min.css">
    </head>
    <body class="sb-nav-fixed">
        <%!
            Conexion conexion = new Conexion();
            UsuariosDao usuariosDao = new UsuariosDao(conexion);
        %>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.jsp">VT Colitas Felices</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">

            </form>

        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Principal</div>
                            <a class="nav-link" href="menu.jsp">
                                <div class="sb-nav-link-icon"><i class="bi bi-menu-button"></i></div>
                                Menu Principal
                            </a>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="bi bi-card-checklist"></i></div>
                                Gestiones
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="Clientes.jsp">Clientes</a>
                                    <a class="nav-link" href="Mascotas.jsp">Mascotas</a>
                                    <a class="nav-link" href="Citas.jsp">Registrar Cita</a>
                                </nav>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Gestion De Usuarios</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"></li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="row">
                                <div class="col-8"><h3> Usuarios</h3></div>
                                <div class="col-4 aling-self-center">
                                    <div class="d-grid gap-2">
                                        <button type="button" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="bi bi-person-fill-add"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>

                                    <th>Nombres y Apellidos</th>
                                    <th>Correo Electronico</th>
                                    <th>Usuario</th>
                                    <th>Contrasena</th>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Login> lista = usuariosDao.mostrarUsuario();
                                            for (Login elem : lista) {
                                        %>
                                        <tr>

                                            <td class="nombres"><%=elem.getNombres_Apellidos()%></td>
                                            <td class="correo"><%=elem.getCorreo_Electronico()%></td>
                                            <td class="usuario"><%=elem.getUsuario()%></td>
                                            <td class="password"><%=elem.getPassword()%></td>
                                            <td>
                                                <button type="button" class="btn btn-outline-warning"><i class="bi bi-pencil-square"></i></button>
                                                <button type="button" class="btn btn-outline-danger"><i class="bi bi-trash3-fill"></i></button>
                                            </td>
                                        </tr>

                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog  ">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Nuevo Usuario</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <form action="${pageContext.servletContext.contextPath}/UsuarioController" method="POST"  id="SendData">
                                            <div class="modal-body">
                                                <table class="table">
                                                    <tr>
                                                        <td>Nombres</td>
                                                        <td><input type="text" id="txtNombre" name="txtNombre" class="form-control"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Correo</td>
                                                        <td><input type="text" id="txtCorreo" name="txtCorreo" class="form-control"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Usuario</td>
                                                        <td><input type="text" id="txtUsuario" name="txtUsuario" class="form-control"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Password</td>
                                                        <td><input type="text" id="txtContrasena" name="txtContrasena" class="form-control"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Rol</td>
                                                        <td>
                                                            <select class="form-select"required>  </select>
                                                        </td>
  
                                                    </tr>                                                  
                                                </table>
                                            </div>                                              
                                            <div class="modal-footer">                                                    
                                                <div class="col-12">
                                                    <button type="submit" class="btn btn-success">Guardar</button>
                                                    <button type="button" class="btn btn-info" data-bs-dismiss="modal">Cancelar</button>
                                                </div>
                                            </div>                                                                                                 
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted"> &copy;Colitas Felices 2024</div>

                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.3/dist/sweetalert2.all.min.js"></script>  
        <script>
            $(document).ready(function () {
                $("#exampleModal").on("hidden.bs.modal", function () {
                    $("#SendData")[0].reset();
                });
                $(document).on("submit", "#SendData", function (e) {
                    e.preventDefault();
                    var form = $(this);
                    var ruta = form.attr("action");
                    $.ajax({
                        url: ruta,
                        type: "POST",
                        dataType: "JSON",
                        data: form.serializeArray()
                    })
                            .done(function (data) {
                                Swal.fire({
                                    position: "center",
                                    icon: "success",
                                    title: data[0],
                                    showConfirmButton: false,
                                    timer: 1500
                                });
                            })
                            .fail(function () {
                                console.log("Error interno");
                            });
                });
            });
        </script>
    </body>
</html>

