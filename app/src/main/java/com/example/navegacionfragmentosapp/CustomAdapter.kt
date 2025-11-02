package com.example.navegacionfragmentosapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val items: List<MiDataModel>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // El ViewHolder que contiene las vistas (usando findViewById)
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagenItem: ImageView
        val textoTitulo: TextView
        val textoSubtitulo: TextView

        init {
            // Encontrar las vistas usando findViewById
            imagenItem = view.findViewById(R.id.imagenItem)
            textoTitulo = view.findViewById(R.id.textoTituloItem)
            textoSubtitulo = view.findViewById(R.id.textoSubtituloItem)
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
        holder.textoTitulo.text = item.titulo
        holder.textoSubtitulo.text = item.subtitulo
        holder.imagenItem.setImageResource(item.imageUrl)
    }
}