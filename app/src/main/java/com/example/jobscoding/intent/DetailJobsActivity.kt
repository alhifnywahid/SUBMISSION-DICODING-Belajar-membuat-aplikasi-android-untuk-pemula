package com.example.jobscoding.intent

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.jobscoding.R
import com.example.jobscoding.data.JobsData
import com.example.jobscoding.utils.goToWebDicodingJobs
import com.example.jobscoding.utils.goToWhatsApp

class DetailJobsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_jobs)

        val imageCompanyLogo: ImageView = findViewById(R.id.img_item_photo)
        val tvTitle: TextView = findViewById(R.id.tv_title)
        val tvCompnayName: TextView = findViewById(R.id.tv_company_name)
        val salary: TextView = findViewById(R.id.tv_salary)
        val tvDescription: TextView = findViewById(R.id.tv_desc)
        val tvLocation: TextView = findViewById(R.id.tv_location)
        val tvJobType: TextView = findViewById(R.id.job_type)
        val tvRange: TextView = findViewById(R.id.tv_range)
        val tvKarywan: TextView = findViewById(R.id.tv_karyawan)
        val btnShare: TextView = findViewById(R.id.action_share)
        val btnSend: TextView = findViewById(R.id.tv_sendbtn)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<JobsData>("data", JobsData::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<JobsData>("data")
        }
        if (data != null) {
            Glide.with(this).load(data.companyLogo).into(imageCompanyLogo)
            tvTitle.text = data.title
            tvCompnayName.text = data.companyName
            salary.text = data.salary
            tvDescription.text = data.description
            tvLocation.text = data.location
            tvJobType.text = data.jobType
            tvRange.text = data.minimumTalentExperience
            tvKarywan.text = data.companyEmloyeesSize
            btnShare.setOnClickListener {
                goToWhatsApp(this, data.url)
            }
            btnSend.setOnClickListener {
                goToWebDicodingJobs(this, data.url)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}