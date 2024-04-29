package com.poligran.medicalendar.ui.citas

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.poligran.medicalendar.R

class CitasFragment : Fragment() {

    private lateinit var citasManager: CitasManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_citas, container, false)

        // Inicializar el CitasManager con el botón
        citasManager = CitasManager(view.findViewById(R.id.boton_nueva_cita))

        // Configurar el spinner de especialidades
        val spinnerEspecialidades: Spinner = view.findViewById(R.id.spinner_especialidades)
        val especialidades = arrayOf("Cardiología", "Dermatología", "Otras")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, especialidades)
        spinnerEspecialidades.adapter = adapter

        // Configurar el spinner de especialistas
        val spinnerEspecialistas: Spinner = view.findViewById(R.id.spinner_especialistas)
        val especialistas = arrayOf("Diana Montes", "Sara Uribe")
        val adapterEspecialistas = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, especialistas)
        spinnerEspecialistas.adapter = adapterEspecialistas

        // Obtener referencias a los botones
        val botonAceptar: Button = view.findViewById(R.id.boton_aceptar)
        val botonCancelar: Button = view.findViewById(R.id.boton_cancelar)

        // Agregar OnClickListener al botón Aceptar
        botonAceptar.setOnClickListener {
            mostrarMensaje("Su Cita ha sido confirmada satisfactoriamente")
        }

        // Agregar OnClickListener al botón Cancelar
        botonCancelar.setOnClickListener {
            mostrarMensaje("Su Cita ha sido cancelada satisfactoriamente")
        }

        return view
    }

    private fun mostrarMensaje(mensaje: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage(mensaje)
            .setPositiveButton("OK") { dialog, _ ->
                // Aquí puedes agregar alguna acción adicional si es necesario
                dialog.dismiss()
            }
        builder.create().show()
    }
}
