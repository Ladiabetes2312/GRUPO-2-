/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function llenarFormulario(fila) {

    var id = $(fila).find(".id").text();
    var nombre = $(fila).find(".nombre").text();
    var fecha = $(fila).find(".fecha").text();
    var hora = $(fila).find(".hora").text();
    var motivo = $(fila).find(".motivo").text();
    var estado = $(fila).find(".estado").text();
    var diagnostico = $(fila).find(".diagnostico").text();
    var tratamiento = $(fila).find(".tratamiento").text();
    var observaciones = $(fila).find(".observaciones").text();
    


    $("#txtNombreMascota").val(nombre);
    $("#txtFecha").val(fecha);
    $("#txtHora").val(hora);
    $("#txtMotivos").val(motivo);
    $("#txtEstadoMascota").val(estado);
    $("#txtDiagnostico").val(diagnostico);
    $("#txtTratamientos").val(tratamiento);
    $("#txtObservaciones").val(observaciones);
 
}


$(document).ready(function () {
    $("#exampleModal").on("hidden.bs.modal", function () {
        $("#form")[0].reset();
    });
    $(document).on('click', '.btnIm', function () {
        llenarFormulario($(this).closest('tr'));
    });
});
