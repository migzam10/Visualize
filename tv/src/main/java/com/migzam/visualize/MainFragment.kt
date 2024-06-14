package com.migzam.visualize

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide

class MainFragment:BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title= getString(R.string.Visualize)

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        (3..6).forEach{metrosId->
            val titulo = "$metrosId metros"
            val listRowAdapter = ArrayObjectAdapter(CardPresenter())
            listRowAdapter.addAll(0, listOf("SNELLEN", "LETRAS LOGMAR", "NUMERO LOGMAR", "C LANDOLT LOG", "NIÑOS","LETRAS",
                                                    "NUMEROS","E DIRECCIONAL","ROJO-VERDE","DIAL","HERRAMIENTAS","PRUEBA Y AYUDA DIAGNOSTICAS"))
            val header = HeaderItem(metrosId.toLong(),titulo)
            rowsAdapter.add(ListRow(header,listRowAdapter))
        }
        // Categoría 1
        val categoryTitle1 = "Maculopatia"
        val listRowAdapter1 = ArrayObjectAdapter(CardPresenter())
        listRowAdapter1.addAll(0, listOf("Título 1.1", "Título 1.2", "Título 1.3", "Título 1.4", "Título 1.5"))
        val header1 = HeaderItem(1L, categoryTitle1)
        rowsAdapter.add(ListRow(header1, listRowAdapter1))

        // Categoría 2
        val categoryTitle2 = "Test de Estereopsis"
        val listRowAdapter2 = ArrayObjectAdapter(CardPresenter())
        listRowAdapter2.addAll(0, listOf("Título 2.1", "Título 2.2", "Título 2.3", "Título 2.4", "Título 2.5"))
        val header2 = HeaderItem(2L, categoryTitle2)
        rowsAdapter.add(ListRow(header2, listRowAdapter2))

        // Categoría 3
        val categoryTitle3 = "Test de color (ISHIHARA)"
        val listRowAdapter3 = ArrayObjectAdapter(CardPresenter())
        listRowAdapter3.addAll(0, listOf("Título 3.1", "Título 3.2", "Título 3.3", "Título 3.4", "Título 3.5"))
        val header3 = HeaderItem(3L, categoryTitle3)
        rowsAdapter.add(ListRow(header3, listRowAdapter3))

        adapter = rowsAdapter

    }
}

class CardPresenter : Presenter() {


    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {

        val cardView = ImageCardView(parent.context)
        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true

        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val titulo = item as String
        val cardView = viewHolder.view as ImageCardView

        cardView.titleText = titulo
        cardView.setMainImageDimensions(313,176)

    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {

    }
}