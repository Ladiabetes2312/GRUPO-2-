<%-- 
    Document   : Registro de Atencion
    Created on : 3 jul. 2024, 18:05:50
    Author     : josue David
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Cita"%>
<%@page import="Dao.CitaDao"%>
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
    <style>
        /* Estilos generales del formulario */
        .container-fluid {
            background-color: white;
            padding: 20px;
            margin: 20px auto;
            width: 80%;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        /* Estilos específicos para la impresión */
        @media print {
            .container-fluid {
                width: 60%; /* Ajusta el ancho del formulario durante la impresión */
                margin: 0 auto; /* Centrar el formulario */
                padding: 0;
                box-shadow: none;
                background-color: transparent; /* Fondo transparente para impresión */
            }

            input, textarea {
                border: none; /* Quitar los bordes */
                background-color: transparent; /* Hacer los campos transparentes */
                box-shadow: none; /* Quitar sombras */
            }

            button {
                display: none; /* Ocultar los botones durante la impresión */
            }

            @page {
                margin: 20mm; /* Ajusta los márgenes de la página al imprimir */
            }
        }
    </style>
    <body class="sb-nav-fixed">
        <%
            CitaDao citaDao = new CitaDao();
        %>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="menu.jsp">VT Colitas Felices</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
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

                            <div class="sb-sidenav-menu-heading">Gestiones</div>
                            <a class="nav-link" href="HistorialClinico.jsp">
                                <div class="sb-nav-link-icon"><i class="bi bi-person-circle"></i></div>
                                Historial Clinico
                            </a>
                            <a class="nav-link" href="Reportes.jsp">
                                <div class="sb-nav-link-icon"><i class="bi bi-graph-up-arrow"></i></div>
                                Reportes
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
            <!-- FIN DE BARRA DE MENU -->
            <div id="layoutSidenav_content">
                <h1 class="mt-4" style="text-align: center;">Registro de Atención</h1> 
                <form action="${pageContext.servletContext.contextPath}/AtencionController" method="POST" id="form">
                    <div class="container-fluid px-4">
                        <div class="row">
                            <div class="col mb-3">
                                <input type="date" id="txtFecha" name="txtFecha" class="form-control input-fecha" placeholder="Last name" aria-label="Last name">
                            </div>
                            <div class="col">
                                <input type="time" id="txtHora" name="txtHora" class="form-control input-hora" placeholder="First name">
                            </div>
                        </div>
                        <div class="form-floating mb-3">
                            <textarea class="form-control" placeholder="Leave a comment here" id="txtMotivos" name="txtMotivos" style="height: 100px"></textarea>
                            <label for="txtMotivos">Motivo Visita:</label>
                        </div> 
                        <div class="form-floating mb-3">
                            <textarea class="form-control" placeholder="Leave a comment here" id="txtEstadoMascota" name="txtEstadoMascota"></textarea>
                            <label for="txtEstadoMascota">Estado de Mascota</label>
                        </div>
                        <div class="form-floating mb-3">
                            <textarea class="form-control" placeholder="Leave a comment here" id="txtDiagnostico" name="txtDiagnostico" style="height: 100px"></textarea>
                            <label for="txtDiagnostico">Diagnóstico Generado</label>
                        </div>
                        <div class="row g-3">
                            <div class="col">
                                <label for="txtTratamientos" class="form-label">Tratamientos</label>
                                <textarea class="form-control" id="txtTratamientos" name="txtTratamientos" rows="3"></textarea>
                            </div>
                            <div class="col mb-3">
                                <label for="txtObservaciones" class="form-label">Observaciones</label>
                                <textarea class="form-control" id="txtObservaciones" name="txtObservaciones" rows="3"></textarea>
                            </div>
                            <%
                                List<Cita> lista = citaDao.listarCitas();
                                for (Cita elem : lista) {
                            %>
                            <input type="hidden" name="idCita" id="idCita" value="<%=elem.getIdCita()%>">
                            <%
                                }
                            %>
                        </div>
                        <div class="d-grid gap-2 col-6 mx-auto mb-3">
                            <button type="submit" name="btnGuardar" class="btn btn-success" type="button">Guardar</button>
                        </div>
                    </div>
                </form>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
            <script src="js/scripts.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
            <script src="assets/demo/chart-area-demo.js"></script>
            <script src="assets/demo/chart-bar-demo.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
            <script src="js/datatables-simple-demo.js"></script>

            <%
                if (request.getAttribute("message") != null) {
            %>
            <script>alert('<%=request.getAttribute("message")%>')</script>
            <%
                }
            %>
    </body>
</html>
