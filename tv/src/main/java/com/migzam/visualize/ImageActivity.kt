package com.migzam.visualize


import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ImageActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private var imageResourceIds: IntArray = intArrayOf()
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        imageResourceIds = intent.getIntArrayExtra("imageResourceIds") ?: intArrayOf()
        Log.d("ImageActivity", "Recibidas imágenes: ${imageResourceIds.joinToString()}")
        if (imageResourceIds.isEmpty()) {
            Log.e("ImageActivity", "No se recibieron imágenes")
            finish()
            return
        }

        imageView = findViewById(R.id.imageView)
        prevButton = findViewById(R.id.prevButton)
        nextButton = findViewById(R.id.nextButton)

        showImage()

        prevButton.setOnClickListener {
            currentIndex = (currentIndex - 1 + imageResourceIds.size) % imageResourceIds.size
            showImage()
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % imageResourceIds.size
            showImage()
        }

        imageView.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN) {
                when (keyCode) {
                    KeyEvent.KEYCODE_DPAD_LEFT -> {
                        currentIndex = (currentIndex - 1 + imageResourceIds.size) % imageResourceIds.size
                        showImage()
                        true
                    }
                    KeyEvent.KEYCODE_DPAD_RIGHT -> {
                        currentIndex = (currentIndex + 1) % imageResourceIds.size
                        showImage()
                        true
                    }
                    else -> false
                }
            } else {
                false
            }
        }

        // Asegurar que la ImageView tenga foco para recibir eventos de teclas
        imageView.isFocusable = true
        imageView.isFocusableInTouchMode = true
        imageView.requestFocus()

    }

    private fun showImage() {
        imageView.setImageDrawable(ContextCompat.getDrawable(this, imageResourceIds[currentIndex+1]))
    }
}