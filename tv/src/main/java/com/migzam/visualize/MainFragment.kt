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

        (3..6).forEach { metrosId ->
            val titulo = "$metrosId metros"
            val listRowAdapter = ArrayObjectAdapter(CardPresenter())

            val imageResourceIds = listOf(R.drawable.submenu_snellen, R.drawable.submenu_log,
                R.drawable.submenu_numeroslog, R.drawable.submenu_clandoltlog,
                R.drawable.submenu_ninos, R.drawable.submenu_letras,
                R.drawable.submenu_numeros, R.drawable.submenu_edireccional,
                R.drawable.submenu_rojoverde)

            val titles = listOf("SNELLEN", "LETRAS LOGMAR", "NUMERO LOGMAR", "LANDOLT LOGMAR", "NIÑOS","LETRAS",
                "NUMEROS","E DIRECCIONAL","ROJO VERDE")

            listRowAdapter.addAll(0, imageResourceIds.zip(titles) { imageId, title ->
                CardItem(listOf(imageId), title)})

            val header = HeaderItem(metrosId.toLong(), titulo)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        val titulo1 = "Test de color (ISHIHARA)"
        val listRowAdapter1 = ArrayObjectAdapter(CardPresenter())
        val imageResourceIds1 = listOf(R.drawable.submenu_ishihara, R.drawable.submenu_ishiharaninos)
        val titles1 = listOf("ISHIHARA","NIÑOS")
        listRowAdapter1.addAll(0, imageResourceIds1.zip(titles1) { imageId, title ->
            CardItem(listOf(imageId), title)})
        val header1 = HeaderItem(1L, titulo1)
        rowsAdapter.add(ListRow(header1, listRowAdapter1))

        val tittulo2 = "Maculopatia"
        val listRowAdapter2 = ArrayObjectAdapter(CardPresenter())
        val imageResourceIds2 = listOf(R.drawable.submenu_maculopatia)
        val titles2 = listOf("MACULOPATIA")
        listRowAdapter2.addAll(0, imageResourceIds2.zip(titles2) { imageId, title ->
            CardItem(listOf(imageId), title)})
        val header2 = HeaderItem(1L, tittulo2)
        rowsAdapter.add(ListRow(header2, listRowAdapter2))


        val tittulo3 = "Test de Estereopsis"
        val listRowAdapter3 = ArrayObjectAdapter(CardPresenter())
        val imageResourceIds3 = listOf(R.drawable.submenu_estereopsis)
        val titles3 = listOf("ESTEREOPSIS")
        listRowAdapter3.addAll(0, imageResourceIds3.zip(titles3) { imageId, title ->
            CardItem(listOf(imageId), title)})
        val header3 = HeaderItem(1L, tittulo3)
        rowsAdapter.add(ListRow(header3, listRowAdapter3))

        adapter = rowsAdapter

    }
}

data class CardItem(val imageResourceIds: List<Int>, val title: String)


