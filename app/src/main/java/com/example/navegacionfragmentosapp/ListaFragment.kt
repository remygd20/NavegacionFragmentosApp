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

        val listaDeDatos = generarDatosDeEjemplo()

        val adapter = CustomAdapter(listaDeDatos)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun generarDatosDeEjemplo(): List<MiDataModel> {


        val datos = listOf(
            Triple("Revuelto", "Híbrido V12 - 1015 CV | El sucesor del Aventador", "https://media.es.wired.com/photos/6425e0e4b4e328f8839787f4/16:9/w_1900,h_1069,c_limit/Lamborghini-Revuelto-Featured-Gear.jpg"),
            Triple("Huracán STO", "V10 - 640 CV | Super Trofeo Omologata (Pista)", "https://cdn.forbes.com.mx/2020/12/Lamborghini-Hurca%CC%81n-STO-hiperdeportivo-scaled-e1607466536373.jpg"),
            Triple("Urus Performante", "V8 Bi-Turbo - 666 CV | El Super SUV más deportivo", "https://images.ecestaticos.com/MPXfpQbRJQMgYwJu50BSulaIJaM=/307x146:1996x1413/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F42d%2Fef5%2Fdd3%2F42def5dd339207ffea73daa10537f6bf.jpg"),
            Triple("Huracán Tecnica", "V10 - 640 CV | Equilibrio perfecto Pista-Calle", "https://cdn.motor1.com/images/mgl/pbxVkV/s1/lamborghini-huracan-tecnica.jpg"),
            Triple("Huracán Sterrato", "V10 - 610 CV | El primer superdeportivo Off-Road", "https://acnews.blob.core.windows.net/imgnews/medium/NAZ_c2edc2af43d847c19ebb1fcbed7aebd6.webp"),
            Triple("Countach LPI 800-4", "Híbrido V12 - 814 CV | Homenaje moderno al clásico", "https://upload.wikimedia.org/wikipedia/commons/2/24/2022_Lamborghini_Countach.jpg"),
            Triple("Sián FKP 37", "Híbrido V12 - 819 CV | Primer híbrido (Supercondensador)", "https://upload.wikimedia.org/wikipedia/commons/1/18/Lamborghini_Sian_at_IAA_2019_IMG_0332.jpg"),
            Triple("Urus S", "V8 Bi-Turbo - 666 CV | Lujo y potencia en un Super SUV", "https://media.autoexpress.co.uk/image/private/s--X-WVjvBW--/f_auto,t_content-image-full-desktop@1/v1683648332/evo/2023/05/Lamborghini%20Urus%20S%202023%20review.jpg"),
            Triple("Aventador Ultimae", "V12 - 780 CV | El último V12 puro de Lamborghini", "https://cdn.motor1.com/images/mgl/4JyZA/s1/lamborghini-aventador-lp-780-4-ultimae.jpg"),
            Triple("Aventador SVJ", "V12 - 770 CV | Super Veloce Jota (Récord en Nürburgring)", "https://m.media-amazon.com/images/I/61OrlURuInL._AC_UF894,1000_QL80_.jpg"),
            Triple("Aventador S", "V12 - 740 CV | Con eje trasero direccional", "https://hips.hearstapps.com/es.h-cdn.co/cades/contenidos/48896/lamborghini-aventador_s_roadster-2018-1600-01.jpg?resize=640:*"),
            Triple("Murciélago LP 670-4", "V12 - 670 CV | Edición SuperVeloce (Muy ligero)", "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/masterpieces/murcielago-lp-670-superveloce/murcielago_lp_670_superveloce_hero_01.jpg"),
            Triple("Gallardo LP 570-4", "V10 - 570 CV | Superleggera (El más vendido)", "https://www.guide-autosport.com/wp-content/uploads/2017/04/lamborghini-murcielago-lp670-4sv-1-1000x288.jpg"),
            Triple("Centenario", "V12 - 770 CV | Homenaje a 100 años de Ferruccio", "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/facelift_2019/model_detail/few_off/Centenario/header_Centenario_og_wa%20%281%29.jpg"),
            Triple("Veneno", "V12 - 750 CV | Exclusividad extrema (Solo 13 unidades)", "https://upload.wikimedia.org/wikipedia/commons/0/07/Geneva_MotorShow_2013_-_Lamborghini_Veneno_1.jpg"),
            Triple("Sesto Elemento", "V10 - 570 CV | Ultra-ligero (Menos de 1000kg)", "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/masterpieces/sesto-elemento/sesto-elemento-HEADER.jpg"),
            Triple("Reventón", "V12 - 650 CV | Diseño inspirado en un avión caza", "https://upload.wikimedia.org/wikipedia/commons/1/1b/Lamborghini_Revent%C3%B3n.jpg"),
            Triple("Essenza SCV12", "V12 - 830 CV | Exclusivo para Pista (No legal en calle)", "https://upload.wikimedia.org/wikipedia/commons/8/8c/Lamborghini_Essenza_SCV12_001.jpg"),
            Triple("Egoista", "V10 - 600 CV | Concepto de un solo asiento (Monoplaza)", "https://m.media-amazon.com/images/I/71FobRfJgPL._AC_SL1200_.jpg"),
            Triple("Terzo Millennio", "Concepto Eléctrico | Carrocería autorreparable", "https://upload.wikimedia.org/wikipedia/commons/d/dc/Festival_automobile_international_2018_-_Lamborghini_Terzo_Millennio_-_015_%28cropped%29.jpg"),
            Triple("Estoque", "Concepto Sedán V10 | El sedán que nunca se produjo", "https://memolira.com/wp-content/uploads/2022/01/Lamborghini-Estoque.png"),
            Triple("Diablo", "V12 - 575 CV | El ícono de los años 90", "https://images.unsplash.com/photo-1733981787000-fffca13abb29?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8bGFtYm9yZ2hpbmklMjBkaWFibG98ZW58MHx8MHx8fDA%3D&fm=jpg&q=60&w=3000"),
            Triple("Countach (Clásico)", "V12 - 455 CV | El coche-póster original", "https://acnews.blob.core.windows.net/imgnews/large/NAZ_63371a1ebfe8499dab989cd1017606e0.jpg"),
            Triple("Miura P400", "V12 - 350 CV | El primer superdeportivo (Motor central)", "https://upload.wikimedia.org/wikipedia/commons/d/d2/1968_Lamborghini_Miura_P400.jpg"),
            Triple("LM002", "V12 - 450 CV | El Rambo-Lambo (SUV V12)", "https://assets.dyler.com/uploads/posts/272/images/5577/the-lm002-weighed-nearly-three-tons.jpg")
        )

        val lista = mutableListOf<MiDataModel>()
        datos.forEach { (titulo, specs, url) ->
            lista.add(MiDataModel(titulo, specs, url))
        }
        return lista
    }
}