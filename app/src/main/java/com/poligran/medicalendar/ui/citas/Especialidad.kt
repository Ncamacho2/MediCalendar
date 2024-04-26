package com.poligran.medicalendar.ui.citas

class Especialidad(var nombre: String) {
    // Obtener el nombre de la especialidad
    fun obtenerNombre(): String {
        return nombre
    }

    // Establecer el nombre de la especialidad
    fun llenarNombre(nombre: String) {
        this.nombre = nombre
    }
}
