<%-- 
    Document   : Reportes
    Created on : 3 jul. 2024, 20:09:42
    Author     : josel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Model.Cita"%>
<%@page import="Dao.CitaDao"%>
<%@page import="Model.EstadoCita"%>
<%@page import="Dao.EstadoCitaDao"%>
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
    </head>
    <body class="sb-nav-fixed">
        <%
            CitaDao citaDao = new CitaDao();
            EstadoCitaDao estadoCitaDao = new EstadoCitaDao();
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
                            <a class="nav-link" href="Registro_de_Atencion.jsp">
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
                        <h1 class="mt-4">Gestion Citas</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"></li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                            </div>
                        </div>
                        <div class="card">
                            <div class="row">
                                <div class="col-8"><h3></h3></div>
                                <div class="col-4 aling-self-center">
                                    <div class="d-grid gap-2">

                                    </div>
                                </div>                                   
                            </div>
                            <div class="table-responsive">
                                <div class="row">
                                    <div class="col-12">
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Hora Programada</th>
                                                    <th>Mascota</th>
                                                    <th>Estado</th>
                                                    <th>Motivo</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    List<Cita> lista = citaDao.listarCitas();
                                                    for (Cita elem : lista) {
                                                %>
                                            <td class="id" style="display: none;" ><%=elem.getIdCita()%></td>
                                            <td class="hora"><%=elem.getHora_Cita()%></td>
                                            <td class="mascota"><%=elem.getNombreM()%></td>
                                            <td class="estado"><%=elem.getEstado_Cita()%></td>
                                            <td class="motivo"><%=elem.getMotivo()%></td>
                                            <td>
                                                <button type="button" class="btn btn-warning btnEditar" data-bs-toggle="modal" data-bs-target="#exampleModal">Editar</button>
                                                <button type="button" class="btn btn-info atender-btn">Atender</button>
                                            <td colspan="1">
                                                <div class="d-flex gap-2">
                                                    <form action="${pageContext.servletContext.contextPath}/EliminarCita" method="POST">
                                                        <input type="hidden" name="id" value="<%=elem.getIdCita()%>">
                                                        <button type="submit" class="btn btn-danger" onclick="return confirm('¿Seguro de eliminar cita?')">Eliminar</button>
                                                    </form>
                                                </div>
                                            </td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                            </tbody>
                                        </table>
                                    </div>                                   
                                </div>
                                <!-- Modal -->
                                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog  ">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Editar Cita</h1>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <form action="${pageContext.servletContext.contextPath}/EstadoCita" method="POST" id="form">
                                                <div class="modal-body">
                                                    <table class="table">
                                                            <input type="hidden" id="txtID" name="txtID" class="form-control" value="0" readonly="true">
                                                        <tr>
                                                            <td>Hora</td>
                                                            <td><input  name="txtHora" id="txtHora" type="time" class="form-control" id="exampleFormControlInput1" placeholder="10:45 am"></td> 
                                                        </tr>
                                                        <tr>
                                                            <td>Mascota</td>
                                                            <td><input type="text" id="txtMascota" name="txtMascota" class="form-control"  readonly="true"></td> 
                                                        </tr>
                                                        <tr>
                                                            <td>Estado de la cita</td>
                                                            <td>
                                                                <select name="txtEstado" id="txtEstado" class="form-select"required>
                                                                    <option  value="first"></option>
                                                                    <%
                                                                        ArrayList<EstadoCita> List = estadoCitaDao.listarEstado();
                                                                        for (EstadoCita elem : List) {
                                                                    %>
                                                                    <option value="<%=elem.getIdEstado_Cita()%>"><%=elem.getEstado_Cita()%></option>
                                                                    <%}%>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Motivo</td>
                                                            <td><input type="text" id="txtMotivo" name="txtMotivo" class="form-control"></td> 
                                                        </tr>
                                                    </table>
                                                </div>                                              
                                                <div class="modal-footer">                                                    
                                                    <div class="col-12">
                                                        <button type="submit" name="btnEditar" class="btn btn-dark">Editar</button>
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
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/Cita.js"></script>
        <%
            if (request.getAttribute("message") != null) {
        %>
        <script>alert('<%=request.getAttribute("message")%>')</script>
        <%
            }
        %>
        <script>
            document.querySelectorAll('.atender-btn').forEach(function (button) {
                button.addEventListener('click', function () {
                    var row = this.closest('tr');
                    var citaId = row.querySelector('.id').innerText;
                    window.location.href = 'Registro_de_Atencion.jsp?idCita=' + citaId;
                });
            });
        </script>
    </body>
</html>
