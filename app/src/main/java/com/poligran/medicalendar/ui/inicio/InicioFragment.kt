package com.poligran.medicalendar.ui.inicio


import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.poligran.medicalendar.R
import com.poligran.medicalendar.ui.perfil.ProfileFragment


class InicioFragment : Fragment() {

    companion object {
        fun newInstance() = InicioFragment()
    }

    private val viewModel: InicioViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)
        val botonCambio = view.findViewById<Button>(R.id.buttonIniciarSesion)
        botonCambio.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Bienvenido")
            builder.setMessage("¡Hola! Bienvenido MediCalendar.")
            builder.setPositiveButton("Aceptar") { dialogInterface: DialogInterface, _: Int ->

                dialogInterface.dismiss()

            }
            val dialog = builder.create()
            dialog.show()
        }
        return view
    }

    fun navegar(view: View) {

    }

}