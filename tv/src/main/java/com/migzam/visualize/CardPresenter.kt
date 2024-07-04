package com.migzam.visualize

import android.content.Intent
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide

class CardPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = ImageCardView(parent.context)
        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val cardItem = item as CardItem
        val cardView = viewHolder.view as ImageCardView
        cardView.tag = cardItem

        // Cargo la primera imagen como miniatura para no crear otro objeto
        Glide.with(cardView.context)
            .load(ContextCompat.getDrawable(cardView.context, cardItem.imageResourceIds[0]))
            .into(cardView.mainImageView)


        cardView.titleText = cardItem.title
        cardView.setMainImageDimensions(333, 206)

        //no centra la imagen jajajjaja
        val titleTextView: TextView = cardView.findViewById(androidx.leanback.R.id.title_text)
        titleTextView.gravity = Gravity.CENTER

        cardView.setOnClickListener {
            val context = it.context
            val cardItem = it.tag as CardItem
            val intent = Intent(context, ImageActivity::class.java)
            intent.putExtra("imageResourceIds", cardItem.imageResourceIds.toIntArray())
            context.startActivity(intent)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {}

}