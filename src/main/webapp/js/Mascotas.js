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
    var nombres = $(fila).find(".nombres").text();
    var f_nacimiento = $(fila).find(".f_nacimiento").text();
    var cliente = $(fila).find(".cliente").text();
    var raza = $(fila).find(".raza").text();
    var sexo = $(fila).find(".sexo").text();
    var tipo = $(fila).find(".tipo").text();

 
    
    $("#txtID").val(id);
    $("#txtNombre").val(nombres);
    $("#txtF_Nacimiento").val(f_nacimiento);
    $("#txtCli option:contains(" + cliente + ")").attr('selected', true);
    $("#txtRaza option:contains(" + raza + ")").attr('selected', true);
    $("#txtSexo option:contains(" + sexo + ")").attr('selected', true);
    $("#txtTipo option:contains(" + tipo + ")").attr('selected', true);
}
 
 
$(document).ready(function () {
    $("#exampleModal").on("hidden.bs.modal", function () {
        $("#form")[0].reset();
        $("#txtCli option[selected]").removeAttr('selected');
        $("#txtRaza option[selected]").removeAttr('selected');
        $("#txtSexo option[selected]").removeAttr('selected');
        $("#txtTipo option[selected]").removeAttr('selected');       
    });
    $(document).on('click', '.btnEditar', function () {
        llenarFormulario($(this).closest('tr'));
    });
});
