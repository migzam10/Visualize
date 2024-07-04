package com.migzam.visualize

import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter



class MainFragment:BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title= getString(R.string.Visualize)

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        val cardDataMap = mapOf(
            "3 metros" to generarListCardItems(3),
            "4 metros" to generarListCardItems(4),
            "5 metros" to generarListCardItems(5),
            "6 metros" to generarListCardItems(6),

            "Test de color (ISHIHARA)" to listOf(
                CardItem(listOf(R.drawable.submenu_ishihara,R.drawable.submenu_ishihara), "ISHIHARA"),
                CardItem(listOf(R.drawable.submenu_ishiharaninos,R.drawable.submenu_ishihara), "NIÑOS")
            ),
            "Maculopatia" to listOf(
                CardItem(listOf(R.drawable.submenu_maculopatia, R.drawable.submenu_maculopatia), "MACULOPATIA")
            ),
            "Test de Estereopsis" to listOf(
                CardItem(listOf(R.drawable.submenu_estereopsis, R.drawable.submenu_estereopsis), "ESTEREOPSIS")
            )
        )

        // Agregar las filas al adaptador
        cardDataMap.forEach { (headerTitle, cardItems) ->
            val listRowAdapter = ArrayObjectAdapter(CardPresenter())
            listRowAdapter.addAll(0, cardItems)
            val header = HeaderItem(headerTitle.hashCode().toLong(), headerTitle)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        adapter = rowsAdapter

    }

    fun generarListCardItems(metrosNum: Int): List<CardItem> {
        val prefijo = "metros${metrosNum}_"
        return listOf(
            CardItem(listOf(
                R.drawable::class.java.getField("${prefijo}snellen2").getInt(null),
                R.drawable::class.java.getField("${prefijo}snellen1").getInt(null),
                R.drawable::class.java.getField("${prefijo}snellen2").getInt(null)), "SNELLEN"),
            CardItem(listOf(
                R.drawable.submenu_log,
                R.drawable::class.java.getField("${prefijo}letraslog1").getInt(null),
                R.drawable::class.java.getField("${prefijo}letraslog1n").getInt(null),
                R.drawable::class.java.getField("${prefijo}letraslog2").getInt(null),
                R.drawable::class.java.getField("${prefijo}letraslog2n").getInt(null),
                R.drawable::class.java.getField("${prefijo}letraslog3").getInt(null),
                R.drawable::class.java.getField("${prefijo}letraslog3n").getInt(null)), "LETRAS LOGMAR"),
            CardItem(listOf(
                R.drawable.submenu_numeroslog,
                R.drawable::class.java.getField("${prefijo}numerolog1").getInt(null),
                R.drawable::class.java.getField("${prefijo}numerolog1n").getInt(null),
                R.drawable::class.java.getField("${prefijo}numerolog2").getInt(null),
                R.drawable::class.java.getField("${prefijo}numerolog2n").getInt(null),
                R.drawable::class.java.getField("${prefijo}numerolog3").getInt(null),
                R.drawable::class.java.getField("${prefijo}numerolog3n").getInt(null)), "NUMERO LOGMAR"),
            CardItem(listOf(
                R.drawable.submenu_clandoltlog,
                R.drawable::class.java.getField("${prefijo}clandolt1").getInt(null),
                R.drawable::class.java.getField("${prefijo}clandolt1n").getInt(null),
                R.drawable::class.java.getField("${prefijo}clandolt2").getInt(null),
                R.drawable::class.java.getField("${prefijo}clandolt2n").getInt(null),
                R.drawable::class.java.getField("${prefijo}clandolt3").getInt(null),
                R.drawable::class.java.getField("${prefijo}clandolt3n").getInt(null)), "LANDOLT LOGMAR"),
            CardItem(listOf(
                R.drawable.submenu_ninos,
                R.drawable::class.java.getField("${prefijo}ninos1").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos1n").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos2").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos2n").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos3").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos3n").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos4").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos4n").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos5").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos5n").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos6").getInt(null),
                R.drawable::class.java.getField("${prefijo}ninos6n").getInt(null)), "NIÑOS"),
            CardItem(listOf(R.drawable.submenu_letras), "LETRAS"),
            CardItem(listOf(R.drawable.submenu_numeros), "NUMEROS"),
            CardItem(listOf(
                R.drawable.submenu_edireccional,
                R.drawable::class.java.getField("${prefijo}edirlog1").getInt(null),
                R.drawable::class.java.getField("${prefijo}edirlog1n").getInt(null),
                R.drawable::class.java.getField("${prefijo}edirlog2").getInt(null),
                R.drawable::class.java.getField("${prefijo}edirlog2n").getInt(null),
                R.drawable::class.java.getField("${prefijo}edirlog3").getInt(null),
                R.drawable::class.java.getField("${prefijo}edirlog3n").getInt(null)), "E DIRECCIONAL")
            //CardItem(listOf(R.drawable.submenu_rojoverde), "ROJO VERDE")
        )
    }

}