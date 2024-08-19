/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validarFormulario() {
    console.log("Validando formulario...");

    var hora = document.getElementById('txtHora').value.trim();
    var cliente = document.getElementById('txtCliente').value.trim();
    var mascota = document.getElementById('txtMascota').value.trim();
    var vet = document.getElementById('txtVet').value.trim();
    var motivo = document.getElementById('txtMotivo').value.trim();
    var estado = document.getElementById('txtEstado').value.trim();

    if (hora === "") {
        alert("Por favor, ingresa la hora de la cita.");
        return false;
    }

    if (cliente === "..Seleccionar Cliente..") {
        alert("Por favor, selecciona un cliente.");
        return false;
    }

    if (mascota === "..Seleccionar Mascota..") {
        alert("Por favor, selecciona una mascota.");
        return false;
    }

    if (vet === "..Seleccionar Veterinario..") {
        alert("Por favor, selecciona un veterinario.");
        return false;
    }

    if (motivo === "") {
        alert("Por favor, ingresa el motivo de la cita.");
        return false;
    }

    if (estado === "....") {
        alert("Por favor, selecciona un estado para la cita.");
        return false;
    }

    console.log("Formulario validado correctamente.");
    return true;
}






