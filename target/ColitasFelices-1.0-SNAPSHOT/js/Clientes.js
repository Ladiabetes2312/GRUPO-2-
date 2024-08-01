/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function () {

    $("#exampleModal").on("hidden.bs.modal", function () {
        $("#SendData")[0].reset();
    });
    $(document).on("click", "#btnAdd", function () {
        $("#accion").val("add");
    });
    //Agregar               
    $(document).on("submit", "#SendData", function (e) {
        e.preventDefault();
        var form = $(this);
        var ruta = form.attr("action");
        saveData(form, ruta);

    });
});
