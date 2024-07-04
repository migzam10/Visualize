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
            "3 metros" to listOf(
                CardItem(listOf(R.drawable.metros3_snellen2,R.drawable.metros3_snellen1,R.drawable.metros3_snellen2), "SNELLEN"),
                CardItem(listOf(R.drawable.submenu_log,R.drawable.metros3_letraslog1, R.drawable.metros3_letraslog1n,
                    R.drawable.metros3_letraslog2, R.drawable.metros3_letraslog2n, R.drawable.metros3_letraslog3,
                    R.drawable.metros3_letraslog3n), "LETRAS LOGMAR"),
                CardItem(listOf(R.drawable.submenu_numeroslog,R.drawable.metros3_numerolog1, R.drawable.metros3_numerolog1n,
                    R.drawable.metros3_numerolog2, R.drawable.metros3_numerolog2n, R.drawable.metros3_numerolog3, R.drawable.metros3_numerolog3n),
                    "NUMERO LOGMAR"),
                CardItem(listOf(R.drawable.submenu_clandoltlog,R.drawable.metros3_clandolt1,R.drawable.metros3_clandolt1n, R.drawable.metros3_clandolt2,
                    R.drawable.metros3_clandolt2n,R.drawable.metros3_clandolt3,R.drawable.metros3_clandolt3n), "LANDOLT LOGMAR"),
                CardItem(listOf(R.drawable.submenu_ninos,R.drawable.metros3_ninos1,R.drawable.metros3_ninos1n,R.drawable.metros3_ninos2,R.drawable.metros3_ninos2n,
                    R.drawable.metros3_ninos3,R.drawable.metros3_ninos3n,R.drawable.metros3_ninos4,R.drawable.metros3_ninos4n,R.drawable.metros3_ninos5,R.drawable.metros3_ninos5n,
                    R.drawable.metros3_ninos6,R.drawable.metros3_ninos6n), "NIÑOS"),
                CardItem(listOf(R.drawable.submenu_letras,), "LETRAS"),
                CardItem(listOf(R.drawable.submenu_numeros,), "NUMEROS"),
                CardItem(listOf(R.drawable.submenu_edireccional,R.drawable.metros3_edirlog1,R.drawable.metros3_edirlog1n,R.drawable.metros3_edirlog2,
                    R.drawable.metros3_edirlog2n,R.drawable.metros3_edirlog3,R.drawable.metros3_edirlog3n), "E DIRECCIONAL"),
                CardItem(listOf(R.drawable.submenu_rojoverde,), "ROJO VERDE"),
            ),

            "Test de color (ISHIHARA)" to listOf(
                CardItem(listOf(R.drawable.submenu_ishihara,R.drawable.submenu_snellen), "ISHIHARA"),
                CardItem(listOf(R.drawable.submenu_ishiharaninos,R.drawable.submenu_snellen), "NIÑOS")
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
}