package com.example.navegacionfragmentosapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout
        val view = inflater.inflate(R.layout.fragment_lista, container, false)

        // Encontrar el RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewLista)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Preparar los datos
        val listaDeDatos = generarDatosDeEjemplo()

        // 2. Crear el Adaptador
        val adapter = CustomAdapter(listaDeDatos)

        // 3. Configurar el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    // Función para crear datos de ejemplo
    private fun generarDatosDeEjemplo(): List<MiDataModel> {
        val lista = mutableListOf<MiDataModel>()
        for (i in 1..20) {
            // Usamos requireContext().getString para poder formatear el string
            val titulo = requireContext().getString(R.string.titulo_elemento_lista, i)
            val subtitulo = requireContext().getString(R.string.subtitulo_elemento_lista, i)
            val icono = android.R.drawable.ic_menu_view // Icono de Android

            lista.add(MiDataModel(titulo, subtitulo, icono))
        }
        return lista
    }
}