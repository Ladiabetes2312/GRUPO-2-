<%-- 
    Document   : Mascotas
    Created on : 10 jul. 2024, 01:58:54
    Author     : JOSUEDAVID
--%>

<%@page import="java.util.List"%>
<%@page import="com.zegel.vet.colitasfelices.model.Mascotas"%>
<%@page import="com.zegel.vet.colitasfelices.dao.MascotasDao"%>
<%@page import="com.zegel.vet.colitasfelices.model.Raza"%>
<%@page import="com.zegel.vet.colitasfelices.dao.RazaDao"%>
<%@page import="com.zegel.vet.colitasfelices.model.Sexo"%>
<%@page import="com.zegel.vet.colitasfelices.dao.SexoDao"%>
<%@page import="com.zegel.vet.colitasfelices.model.Tipo_Animal"%>
<%@page import="com.zegel.vet.colitasfelices.dao.Tipo_AnimalDao"%>
<%@page import="com.zegel.vet.colitasfelices.conexion.Conexion" %>
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
    </head>
    <body>
        <%!
            Conexion conexion = new Conexion();
            MascotasDao mascotasDao = new MascotasDao(conexion);
            RazaDao razaDao = new RazaDao(conexion);
            SexoDao sexoDao = new SexoDao(conexion);
            Tipo_AnimalDao tipo_animalDao = new Tipo_AnimalDao(conexion);
            
        %>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">VT Colitas Felices</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Barra Usuario-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="index.jsp">Cerrar Sesion</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">

                            <div class="sb-sidenav-menu-heading">Principal</div>
                            <a class="nav-link" href="menu.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Menu Principal
                            </a>

                            <div class="sb-sidenav-menu-heading">Gestiones</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Clientes
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>

                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="Clientes.jsp">Clientes</a>
                                    <a class="nav-link" href="Mascotas.jsp">Mascotas</a>
                                </nav>
                            </div>

                            <div class="sb-sidenav-menu-heading">Gestiones</div>
                            <a class="nav-link" href="Usuarios.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Usuarios
                            </a>

                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Gestion Mascotas</h1>
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
                                        <button type="button" class="btn btn-outline-success">Agregar</button>
                                    </div>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead >
                                    <th>ID</th>
                                    <th>Nombres</th>
                                    <th>Fecha Nacimiento</th>
                                    <th>Id Clientes</th>
                                    <th>Id Raza</th>
                                    <th>Id Sexo</th>
                                    <th>Id Tipo de Animal</th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                    <tbody>
                                        <%
                                            List<Mascotas> lista = mascotasDao.mostrarMascotas();
                                            for (Mascotas elem : lista) {
                                        %>
                                        <tr>
                                            <td class="id"><%=elem.getIdMascotas()%></td>
                                            <td class="nombres"><%=elem.getNombre()%></td>
                                            <td class="f_nacimiento"><%=elem.getF_Nacimiento()%></td>
                                            <td class="idclientes"><%=elem.getIdClientes()%></td>
                                            <td class="idraza"><%=elem.getIdRaza()%></td>
                                            <td class="idsexo"><%=elem.getIdSexo()%></td>
                                            <td class="idtipo_de_animal"><%=elem.getIdTipo_De_Animal()%></td>
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
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted"> &copy;Colitas Felices 2024</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
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