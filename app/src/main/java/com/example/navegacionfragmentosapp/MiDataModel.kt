package com.example.navegacionfragmentosapp

// Data class para guardar la info de cada fila
data class MiDataModel(
    val titulo: String,
    val subtitulo: String,
    val imageUrl: Int // Usamos un Int porque la imagen vendrá de @android:drawable
)