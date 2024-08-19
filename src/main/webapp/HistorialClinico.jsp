<%-- 
    Document   : HistorialClinico
    Created on : 3 jul. 2024, 18:06:00
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Model.Cita"%>
<%@page import="Model.R_Atencion"%>
<%@page import="Dao.CitaDao"%>
<%@page import="Dao.R_AtencionDao"%>
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
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/stylesp.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"/>
        <style>
            /* Estilos generales */
            body {
                font-family: Arial, sans-serif;
            }

            .modal-content{
                background-color: white;
                padding: 20px;
                margin: 20px auto;
                width: 80%; /* Aumenta el ancho del formulario */
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }

            .modal-footer {
                margin-top: 20px;
            }

            /* Ocultar la tabla de fondo durante la impresión */
            @media print {
                .registro-tabla {
                    display: none;
                    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                }
                .modal-content{
                    margin-top: 50px;
                    height: 0;
                }
                .print-modal .modal-content {
                    border: none;
                    box-shadow: none;
                }
                .print-modal .modal-header,
                .print-modal .modal-footer {
                    display: none;
                }
                .print-modal .modal-body {
                    border: none;
                }

                .titulo {
                    display: none;
                }
                .modal-dialog modal-xl{
                    display:  none;
                }
                .modal-footer, .btn {
                    display: none; /* Ocultar botones y pie de modal en la impresión */
                }

                .registro-daa {
                    width: 170%;
                    height: 20%;/* Expandir el formulario para ocupar todo el ancho de la página al imprimir */
                    box-shadow: none;
                    padding: 0;
                    margin-top: 50px;
                    box-shadow: none;
                    margin-left: -130px ;
                }

                body {
                    background-color: white;
                    margin: 0;
                    padding: 0;
                }

                textarea, input {
                    border: none;
                    background-color: white;
                }

                label {
                    font-weight: bold;
                }

                textarea {
                    resize: none;
                    height: auto;
                }

                @page {
                    margin: 20mm;
                }
            }
        </style>
    </head>
    <body class="sb-nav-fixed">
        <%
            CitaDao citaDao = new CitaDao();
            R_AtencionDao r_AtencionDao = new R_AtencionDao();
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
                            <a class="nav-link" href="Reportes.jsp">
                                <div class="sb-nav-link-icon"><i class="bi bi-graph-up-arrow"></i></div>
                                Reportes
                            </a>
                            <a class="nav-link" href="Registro de Atencion.jsp">
                                <div class="sb-nav-link-icon"><i class="bi bi-clipboard-data-fill"></i></div>
                                Registro De Atencion
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">                     
                        <h1 class="mt-4 titulo">Historiales Clinicos</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"></li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                            </div>
                        </div>
                        <div class="card">
                            <div class="row">                                  
                            </div>
                            <div class="table-responsive">
                                <div class="row">
                                    <div class="col-12">
                                        <table class="table table-hover registro-tabla">
                                            <thead>
                                            <th>Mascota</th>
                                            <th>Fecha de Visita</th>
                                            <th>Hora</th>
                                            <th>Motivo</th>
                                            </thead>
                                            <tbody>
                                                <%
                                                    ArrayList<R_Atencion> lista = r_AtencionDao.mostrarRegistros();
                                                    for (R_Atencion elem : lista) {


                                                %>
                                                <tr>
                                                    <td class="id" style="display: none;" ><%=elem.getIdRegistro()%></td>
                                                    <td class="nombre"><%=elem.getNombreM()%></td>
                                                    <td class="fecha"><%=elem.getFechaVisita()%></td>
                                                    <td class="hora"><%=elem.getHora()%></td>
                                                    <td class="motivo" ><%=elem.getMotivoVisita()%></td>
                                                    <td class="estado" style="display: none;"><%=elem.getEstadoMascota()%></td>
                                                    <td class="diagnostico" style="display: none;"><%=elem.getDiagnosticoGenerado()%></td>
                                                    <td class="tratamiento" style="display: none;"><%=elem.getTratamiento()%></td>
                                                    <td class="observaciones" style="display: none;" ><%=elem.getObservaciones()%></td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary btnIm" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="fa-regular fa-eye"></i></button>
                                                    </td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                            </tbody>
                                        </table>
                                    </div>                                   
                                </div> 
                                <div class="modal fade print-modal" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-xl">
                                        <div class="modal-content">
                                            <div class="registro">
                                                <div class="container-fluid px-4 registro-daa">
                                                    <h2 class="text-center mb-4">Formulario de Atención Veterinaria</h2>
                                                    <div class="row">
                                                        <div class="col mb-3">
                                                            <label for="txtNombreMascota">Nombre de la Mascota:</label>
                                                            <input type="text" id="txtNombreMascota" name="txtNombreMascota" class="form-control input-nombre-mascota">
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col mb-3">
                                                            <label for="txtFecha">Fecha:</label>
                                                            <input type="date" id="txtFecha" name="txtFecha" class="form-control input-fecha">
                                                        </div>
                                                        <div class="col">
                                                            <label for="txtHora">Hora:</label>
                                                            <input type="time" id="txtHora" name="txtHora" class="form-control input-hora">
                                                        </div>
                                                    </div>
                                                    <div class="form-floating mb-3">
                                                        <textarea class="form-control" id="txtMotivos" name="txtMotivos" style="height: 100px"></textarea>
                                                        <label for="txtMotivos">Motivo de la Visita</label>
                                                    </div> 
                                                    <div class="form-floating mb-3">
                                                        <textarea class="form-control" id="txtEstadoMascota" name="txtEstadoMascota"></textarea>
                                                        <label for="txtEstadoMascota">Estado de la Mascota</label>
                                                    </div>
                                                    <div class="form-floating mb-3">
                                                        <textarea class="form-control" id="txtDiagnostico" name="txtDiagnostico" style="height: 100px"></textarea>
                                                        <label for="txtDiagnostico">Diagnóstico Generado</label>
                                                    </div>
                                                    <div class="row g-3">
                                                        <div class="col">
                                                            <label for="txtTratamientos">Tratamientos</label>
                                                            <textarea class="form-control" id="txtTratamientos" name="txtTratamientos" rows="3"></textarea>
                                                        </div>
                                                        <div class="col mb-3">
                                                            <label for="txtObservaciones">Observaciones</label>
                                                            <textarea class="form-control" id="txtObservaciones" name="txtObservaciones" rows="3"></textarea>
                                                        </div>
                                                        <input type="hidden" name="idCita" id="idCita" value="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <div class="col-12">
                                                    <button type="button" class="btn btn-info" onclick="print()"><i class="fa-solid fa-print"></i></button>
                                                    <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Cancelar</button>
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
                    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
                    <script src="js/scripts.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
                    <script src="assets/demo/chart-area-demo.js"></script>
                    <script src="assets/demo/chart-bar-demo.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
                    <script src="js/datatables-simple-demo.js"></script>
                    <script src="${pageContext.servletContext.contextPath}/js/Historia_C.js"></script>
                    </body>
                    </html>

