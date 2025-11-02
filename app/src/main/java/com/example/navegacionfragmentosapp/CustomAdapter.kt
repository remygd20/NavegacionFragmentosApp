package com.example.navegacionfragmentosapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(private val items: List<MiDataModel>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // El ViewHolder que contiene las vistas
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagenItem: ImageView
        val textoTitulo: TextView
        val textoSpecs: TextView

        init {
            // Encontrar las vistas usando findViewById
            imagenItem = view.findViewById(R.id.imagenItem)
            textoTitulo = view.findViewById(R.id.textoTituloItem)
            textoSpecs = view.findViewById(R.id.textoSubtituloItem)
        }
    }

    // Crea un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    // Retorna la cantidad total de ítems
    override fun getItemCount(): Int {
        return items.size
    }

    // Rellena los datos de un ítem
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        // Ponemos los textos
        holder.textoTitulo.text = item.titulo
        holder.textoSpecs.text = item.specs

        Glide.with(holder.itemView.context)
            .load(item.imageUrl) // Carga la URL del item
            .placeholder(R.drawable.lambo_logo)
            .error(R.drawable.placeholder_image) // Imagen si falla (usa tu foto del carro)
            .into(holder.imagenItem)
    }
}