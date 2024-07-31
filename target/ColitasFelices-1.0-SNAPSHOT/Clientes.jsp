
<%-- 
    Document   : Clientes
    Created on : 3 jul. 2024, 22:22:56
    Author     : JOSUEDAVID
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Clientes"%>
<%@page import="Dao.ClientesDao"%>
<%@page import="Conexion.Conexion" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Sistema Veterinaria</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/stylesp.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    </head>
    <body>
        <%!
            Conexion conexion = new Conexion();
            ClientesDao clientesDao = new ClientesDao(conexion);
        %>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">VT Colitas Felices</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0"></form>
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
                                    <a class="nav-link" href="Usuarios.jsp">Usuarios</a>
                                    <a class="nav-link" href="Mascotas.jsp">Mascotas</a>
                                    <a class="nav-link" href="Citas.jsp">Regisrar Cita</a>
                                </nav>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Gestion De Clientes</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"></li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="row">
                                <div class="col-8"><h3> Clientes</h3></div>
                                <div class="col-4 aling-self-center">
                                    <div class="d-grid gap-2">
                                        <button type="button" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar</button>
                                    </div>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead >
                                    <th>Nombres y Apellidos</th>
                                    <th>Telefono</th>
                                    <th>Correo Electronico</th>
                                    <th>Direccion</th>
                                    <th>DNI</th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                    <tbody>
                                        <%
                                            List<Clientes> lista = clientesDao.mostrarClientes();
                                            for (Clientes elem : lista) {

                                        %>
                                        <tr>
                                            <td class="nombres"><%=elem.getNombres_Apellidos()%></td>
                                            <td class="correo"><%=elem.getTelefono()%></td>
                                            <td class="usuario"><%=elem.getCorreo_Electronico()%></td>
                                            <td class="pass"><%=elem.getDireccion()%></td>
                                            <td class="pass"><%=elem.getDNI()%></td>
                                            <td>
                                                <button type="button" class="btn btn-outline-warning">Editar</button>
                                                <button type="button" class="btn btn-outline-danger">Eliminar</button>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                    </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog  modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Nuevo Cliente</h1>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="" role="form">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <label>Nombres</label>
                                                            <input type="text" name="txtNombre" class="form-control" id="txtNombre">
                                                        </div>
                                                        <div class="col-6">
                                                            <label>Telefono</label>
                                                            <input type="text" name="txtContraseña" class="form-control" id="txtContraseña">
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <label>Correo</label>
                                                            <input type="text" name="txCorreo" class="form-control" id="txtCorreo">
                                                        </div>
                                                         <div class="col-6">
                                                            <label>Direccion</label>                             
                                                                <input type="text" name="txtDNI" class="form-control" id="txtDNI">                                             
                                                        </div>
                                                        <div class="col-6">
                                                            <label>DNI</label>                             
                                                                <input type="number" name="txtDNI" class="form-control" id="txtDNI">                                             
                                                        </div>
                                                    </div>
                                                </form>                           
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary">Guardar</button>
                                                </div>
                                            </div>
                                        </div>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>
