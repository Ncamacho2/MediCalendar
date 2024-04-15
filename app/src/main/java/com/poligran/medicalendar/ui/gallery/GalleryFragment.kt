package com.poligran.medicalendar.ui.gallery

import ImagenAdapter
import ImagenItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poligran.medicalendar.R
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

private const val NombreSede = "<b><br>Nombre de la Sede: </b>"

private const val direccion = "<b><br>Dirección: </b>"

private const val contact = "<b><br>Contacto: </b>"

class GalleryFragment : Fragment() {

    private lateinit var listViewImagenes: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        val listaImagenes = listOf(
            ImagenItem(R.drawable.sede_1, "$NombreSede Sede Chapinero $direccion Carrera 7 # 42-26, Chapinero $contact Juan Martínez"),
            ImagenItem(R.drawable.sede_2, "$NombreSede Sede Zona T $direccion Calle 85 # 15-10, Zona T $contact Laura García"),
            ImagenItem(R.drawable.sede_3, "$NombreSede Sede Usaquén $direccion Carrera 15 # 80-56, Usaquén $contact María Rodríguez"),
            ImagenItem(R.drawable.sede_4, "$NombreSede Sede Fontibón $direccion Avenida Boyacá # 72-10, Fontibón $contact Andrés Gómez"),
            ImagenItem(R.drawable.sede_5, "$NombreSede Sede Teusaquillo $direccion Calle 72 # 12-30, Teusaquillo $contact Ana López"),
            ImagenItem(R.drawable.sede_6, "$NombreSede Sede Chico $direccion Carrera 9 # 65-15, Chico $contact Andrés Gómez") ,
            ImagenItem(R.drawable.sede_7, "$NombreSede Sede Cedritos $direccion Calle 127 # 45-80, Cedritos $contact Ana López"),
            ImagenItem(R.drawable.sede_8, "$NombreSede Sede La Candelaria $direccion Avenida Caracas # 36-20, La Candelaria $contact Laura García"),
            ImagenItem(R.drawable.sede_9, "$NombreSede Sede El Chicó $direccion Calle 100 # 19-30, El Chicó $contact Juan Martínez")
        )

        listViewImagenes = view.findViewById(R.id.listViewImagenes)
        val adapter = ImagenAdapter(requireContext(), listaImagenes)
        listViewImagenes.adapter = adapter

        return view
    }

}