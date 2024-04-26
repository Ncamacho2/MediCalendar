package com.poligran.medicalendar.ui.citas

class Especialista(var nombre: String) {
    // Obtener el nombre del especialista
    fun obtenerNombre(): String {
        return nombre
    }

    // Establecer el nombre del especialista
    fun llenarNombre(nombre: String) {
        this.nombre = nombre
    }
}

