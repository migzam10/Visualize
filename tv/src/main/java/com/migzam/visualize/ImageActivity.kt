package com.migzam.visualize

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val imageResourceIds = intent.getIntArrayExtra("imageResourceIds") ?: intArrayOf()

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ImagePagerAdapter(this, imageResourceIds.toList())
        viewPager.adapter = adapter
    }
}
