package com.poligran.medicalendar.ui.citas

import android.widget.Button
import android.widget.Toast

class CitasManager(private val botonNuevaCita: Button) {

    private var especialidadSeleccionada: String? = null
    private var especialistaSeleccionado: String? = null
    private var fechaSeleccionada: String? = null
    private var horaSeleccionada: String? = null

    init {
        botonNuevaCita.isEnabled = true
    }

    fun seleccionarEspecialidad(indice: Int) {
        especialidadSeleccionada = obtenerEspecialidades()[indice]
    }

    fun seleccionarEspecialista(indice: Int) {
        especialistaSeleccionado = obtenerEspecialistasDisponibles()[indice]
    }

    fun seleccionarFechaHora(fecha: String, hora: String) {
        fechaSeleccionada = fecha
        horaSeleccionada = hora
    }

    fun asignarCita() {
        Toast.makeText(
            botonNuevaCita.context,
            "Cita asignada para el especialista $especialistaSeleccionado" +
                    " en la especialidad de $especialidadSeleccionada" +
                    " el día $fechaSeleccionada a las $horaSeleccionada",
            Toast.LENGTH_SHORT
        ).show()

        botonNuevaCita.isEnabled = true
    }

    fun cancelarCita() {
        botonNuevaCita.isEnabled = false
    }

    private fun obtenerEspecialidades(): List<String> {
        return listOf("Cardiología", "Dermatología", "Otras")
    }

    private fun obtenerEspecialistasDisponibles(): List<String> {
        return listOf("Diana Montes", "Sara Uribe")
    }
}
