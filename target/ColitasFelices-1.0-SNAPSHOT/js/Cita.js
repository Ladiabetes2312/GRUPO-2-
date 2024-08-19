/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function llenarFormulario(fila) {

    var id = $(fila).find(".id").text();
    var hora = $(fila).find(".hora").text();
    var mascota = $(fila).find(".mascota").text();
    var estado = $(fila).find(".estado").text();
    var motivo = $(fila).find(".motivo").text();

    $("#txtID").val(id);
    $("#txtHora").val(hora);
    $("#txtMascota").val(mascota);
    $("#txtEstado option[selected]").removeAttr('selected');
    $("#txtEstado option:contains(" + estado + ")").attr('selected', true);
    $("#txtMotivo").val(motivo);
}


$(document).ready(function () {
    $("#exampleModal").on("hidden.bs.modal", function () {
        $("#form")[0].reset();
        $("#txtCargo option[selected]").removeAttr('selected');
    });
    $(document).on('click', '.btnEditar', function () {
        llenarFormulario($(this).closest('tr'));
    });
});





