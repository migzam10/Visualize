package com.migzam.visualize

import android.content.Intent
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide

class CardPresenter : Presenter() {


    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {

        val cardView = ImageCardView(parent.context)
        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true

        cardView.setOnClickListener {
            val context = it.context
            val cardItem = it.tag as CardItem
            val intent = Intent(context, ImageActivity::class.java)
            intent.putExtra("imageResourceIds", cardItem.imageResourceIds.toIntArray())
            context.startActivity(intent)
        }

        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val cardItem = item as CardItem
        val cardView = viewHolder.view as ImageCardView

        Glide.with(cardView.context)
            .load(ContextCompat.getDrawable(cardView.context, cardItem.imageResourceIds[0]))
            .into(cardView.mainImageView)

        cardView.titleText = cardItem.title

        cardView.setMainImageDimensions(333,206)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {

    }
}