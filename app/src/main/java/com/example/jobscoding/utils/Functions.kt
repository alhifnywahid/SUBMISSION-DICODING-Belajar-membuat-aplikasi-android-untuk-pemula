package com.example.jobscoding.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import java.text.NumberFormat
import java.util.Locale

fun goToWhatsApp(context: Context, message: String) {
    try {
        val url = "https://api.whatsapp.com/send?text=" + Uri.encode(message)
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "WhatsApp tidak terinstal", Toast.LENGTH_SHORT).show()
    }
}

fun goToWebDicodingJobs(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "Website tidak tersedia", Toast.LENGTH_SHORT).show()
    }
}