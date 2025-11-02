package com.example.navegacionfragmentosapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ImagenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        return inflater.inflate(R.layout.fragment_imagen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Referencias a los elementos del layout
        val imageViewOficinas: ImageView = view.findViewById(R.id.imageViewOficinas)
        val textViewDescripcionOficinas: TextView = view.findViewById(R.id.textViewDescripcionOficinas)
        val imageViewTaller: ImageView = view.findViewById(R.id.imageViewTaller)
        val textViewDescripcionTaller: TextView = view.findViewById(R.id.textViewDescripcionTaller)

        val urlOficinas = "https://cdn.motor1.com/images/mgl/KbmqWM/s3/lamborghini-factory-evolution.jpg"
        Glide.with(this)
            .load(urlOficinas)
            .into(imageViewOficinas)
        textViewDescripcionOficinas.text = "La majestuosa sede de Automobili Lamborghini en Sant'Agata Bolognese, Italia. Donde la innovación y el legado se fusionan."

        val urlTaller = "https://cloudfront-eu-central-1.images.arcpublishing.com/diarioas/3V4V6EIJMRHLXBWNLECH7NNXGY.jpeg"
        Glide.with(this)
            .load(urlTaller)
            .into(imageViewTaller)
        textViewDescripcionTaller.text = "El arte de la creación: cada superdeportivo toma forma con precisión artesanal en los talleres de Lamborghini."
    }
}