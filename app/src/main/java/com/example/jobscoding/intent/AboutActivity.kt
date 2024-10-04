package com.example.jobscoding.intent

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jobscoding.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        val image: ImageView = findViewById(R.id.img_profile)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/bangkit-dashboard/o/production%2F2024-B2%2Fprofiles%2Fdf8a45ee-6869-44ea-8b50-28890cb1116b.jpg?alt=media&token=b37f46c5-6b82-4203-b6e9-3b35ace82756") // Ganti dengan URL atau Drawable
            .apply(RequestOptions.circleCropTransform())
            .into(image)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}