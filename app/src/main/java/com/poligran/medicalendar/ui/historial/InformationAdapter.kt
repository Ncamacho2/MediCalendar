package com.poligran.medicalendar.ui.historial

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.poligran.medicalendar.R

data class InformacionItem(
    val fecha: String,
    val hora: String,
    val motivo: String,
    val estado: String,
    val medico: String,
    val sede: String
)
class InformationAdapter(context: Context, private val listaHistorialC: List<InformacionItem>) :
    ArrayAdapter<InformacionItem>(context, 0, listaHistorialC) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var itemView = convertView
            if (itemView == null) {
                itemView = LayoutInflater.from(context).inflate(R.layout.item_informacion_historial, parent, false)
            }

            val currentInformacion = listaHistorialC[position]

            val textViewDescripcionHistorial: TextView = itemView!!.findViewById(R.id.textViewDescripcionhistorial)
            val concatenar = "${currentInformacion.fecha}<br>${currentInformacion.hora}<br>${currentInformacion.motivo}<br>${currentInformacion.estado}<br>${currentInformacion.medico}<br>${currentInformacion.sede}"

            //val concatenar = currentInformacion.fecha+currentInformacion.hora+currentInformacion.motivo+currentInformacion.estado+currentInformacion.medico+currentInformacion.sede
            textViewDescripcionHistorial.text = Html.fromHtml(concatenar)

            val textViewDescripcionMotivo: TextView = itemView!!.findViewById(R.id.textViewDescripcionmotivo)
            textViewDescripcionMotivo.text = Html.fromHtml(currentInformacion.motivo)

            itemView.setOnClickListener {
                // Toggle visibility of textViewDescripcion when the item is clicked
                textViewDescripcionHistorial.visibility = if (textViewDescripcionHistorial.visibility == View.VISIBLE) {
                    View.GONE
                } else {
                    View.VISIBLE
                }

                textViewDescripcionMotivo.visibility = if (textViewDescripcionMotivo.visibility == View.VISIBLE) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            }

            return itemView
        }

    }

