package com.poligran.medicalendar.ui.historial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.poligran.medicalendar.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val fecha= "<b><br>Fecha: </b>"
private const val hora = "<b><br>Hora: </b>"
private const val motivo = "<b><br>Motivo: </b>"
private const val estado = "<b><br>Estado: </b>"
private const val medico = "<b><br>Medico: </b>"
private const val sede = "<b><br>Sede: </b>"

/**
 * A simple [Fragment] subclass.
 * Use the [HistorialFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistorialFragment : Fragment() {

    private lateinit var listViewInformationH: ListView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_historial, container, false)

        val listaHistorialC = listOf(
            InformacionItem("$fecha 12/04/2024", "$hora 10:00 AM", "$motivo Consulta", "$estado Pendiente", "$medico Dr. García", "$sede Sede Chapinero"),
            InformacionItem("$fecha 13/04/2024", "$hora 11:30 AM", "$motivo Examen", "$estado Realizado", "$medico Dra. Rodríguez", "$sede Sede Usaquén"),
            InformacionItem("$fecha 14/04/2024", "$hora 09:00 AM", "$motivo Control", "$estado Pendiente", "$medico Dr. Gómez", "$sede Sede Fontibón"),
            InformacionItem("$fecha 15/04/2024", "$hora 08:00 AM", "$motivo Consulta", "$estado Pendiente", "$medico Dr. Martínez", "$sede Sede Kennedy"),
            InformacionItem("$fecha 16/04/2024", "$hora 02:30 PM", "$motivo Examen", "$estado Realizado", "$medico Dra. Pérez", "$sede Sede Bosa"),
            InformacionItem("$fecha 17/04/2024", "$hora 03:45 PM", "$motivo Control", "$estado Pendiente", "$medico Dr. Sánchez", "$sede Sede Engativá"),
            InformacionItem("$fecha 18/04/2024", "$hora 11:15 AM", "$motivo Consulta", "$estado Pendiente", "$medico Dr. López", "$sede Sede Suba"),
            InformacionItem("$fecha 19/04/2024", "$hora 04:20 PM", "$motivo Examen", "$estado Realizado", "$medico Dra. González", "$sede Sede Teusaquillo"),
            InformacionItem("$fecha 20/04/2024", "$hora 01:00 PM", "$motivo Control", "$estado Pendiente", "$medico Dr. Ramírez", "$sede Sede Barrios Unidos")

        )

        listViewInformationH = view.findViewById(R.id.listViewInformation)
        val adapter = InformationAdapter(requireContext(), listaHistorialC)
        listViewInformationH.adapter = adapter

        return view
    }

}