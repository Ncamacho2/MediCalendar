package com.poligran.medicalendar.ui.citas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.poligran.medicalendar.R


class CitasManager() : Fragment() {

    private val especialidades = mutableListOf<Especialidad>()
    private var especialidadSeleccionada: Especialidad? = null
    private var especialistaSeleccionado: Especialista? = null
    private var fechaSeleccionada: String? = null
    private var horaSeleccionada: String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_citas, container, false)
        // Agregar algunas especialidades de ejemplo
        especialidades.add(Especialidad("Cardiología"))
        especialidades.add(Especialidad("Dermatología"))
        // Agregar más especialidades según sea necesario

        //botonNuevaCita.isEnabled = false // Botón desactivado inicialmente

        return view
    }



    fun getEspecialidades(): List<Especialidad> {
        return especialidades
    }

    fun seleccionarEspecialidad(indice: Int) {
        especialidadSeleccionada = especialidades[indice]
    }

    fun getEspecialistasDisponibles(): List<Especialista> {
        // Aquí deberías obtener los especialistas disponibles para la especialidad seleccionada
        // Puedes obtenerlos de una base de datos, de una API, etc.
        // Por ahora, solo devolveremos una lista vacía
        return emptyList()
    }

    fun seleccionarEspecialista(indice: Int) {
        especialistaSeleccionado = getEspecialistasDisponibles()[indice]
    }

    fun seleccionarFechaHora(fecha: String, hora: String) {
        fechaSeleccionada = fecha
        horaSeleccionada = hora
    }

    fun asignarCita(view: View) {
        // Simplemente mostramos un mensaje de cita asignada
        Toast.makeText(
            view.context,
            "Cita asignada para el especialista ${especialistaSeleccionado?.nombre}" +
                    " en la especialidad de ${especialidadSeleccionada?.nombre}" +
                    " el día $fechaSeleccionada a las $horaSeleccionada",
            Toast.LENGTH_SHORT
        ).show()

        // Activamos el botón de nueva cita
        //botonNuevaCita.isEnabled = true
    }

    fun cancelarCita() {
        // Aquí iría el código para cancelar la cita

        // Una vez cancelada la cita, desactivamos el botón de nueva cita
        //botonNuevaCita.isEnabled = false
    }
}
