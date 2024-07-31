/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function llenarFormulario(fila) {
    var nombres = $(fila).find(".Nombre").text();
    var correo = $(fila).find(".Correo").text();
    var usuario = $(fila).find(".Usuario").text();
    var password= $(fila).find(".Contraseña").text();

    $("#txtNombre").val(nombres);
    $("#txtCorreo").val(correo);
    $("#txtUsuario").val(usuario);
    $("#txtContrasena").val(password);




}

$(document).ready(function () {
    

    $(document).on('click', '.btnEditar', function () {
        llenarFormulario($(this).closest('tr'));
    });

    $(document).on('click', '.btnEliminar', function () {
        llenarFormulario($(this).closest('tr'));
    });
});
