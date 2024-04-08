import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.poligran.medicalendar.R

data class ImagenItem(val imagenResId: Int, val descripcion: String)
class ImagenAdapter(context: Context, private val listaImagenes: List<ImagenItem>) :
    ArrayAdapter<ImagenItem>(context, 0, listaImagenes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_imagen, parent, false)
        }

        val currentImagen = listaImagenes[position]
        val imageView: ImageView = itemView!!.findViewById(R.id.imageView)
        val textViewDescripcion: TextView = itemView.findViewById(R.id.textViewDescripcion)
        imageView.setImageResource(currentImagen.imagenResId)
        textViewDescripcion.text = Html.fromHtml(currentImagen.descripcion)

        itemView.setOnClickListener {
            // Toggle visibility of textViewDescripcion when the item is clicked
            textViewDescripcion.visibility = if (textViewDescripcion.visibility == View.VISIBLE) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }

        return itemView
    }

}
