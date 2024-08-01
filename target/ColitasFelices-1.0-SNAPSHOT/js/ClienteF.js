/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function getListado() {
    $.ajax({
        url: "/ColitasFelices/ClienteController",
        type: "POST",
        datatype: "JSON",
        data: {accion: "show"}
    })
            .done(function (data) {
                console.log(data);
                var tr = "";
                $.each(data[0], function (key, val) {
                    tr += "<tr>";
                    var botones = "<a class='btn btn-sm btn-success'><i class='fa-regular fa-pen-to-square'></i></a>";
                    botones += "<a class='btn btn-sm btn-success'><i class='fa-solid fa-trash-can'></i></a>";
                });
            });
}
function saveData(form, ruta) {
    $.ajax({
        url: ruta,
        type: "POST",
        dataType: "JSON",
        data: form.serializeArray()
    })
            .done(function (data) {
                getListado();
                $("#exampleModal").modal("hide");
                Swal.fire({
                    position: "top-end",
                    icon: "success",
                    title: data[0],
                    showConfirmButton: false,
                    timer: 1500
                });
            })
            .fail(function () {
                console.log("Error interno");
            });

}


