package com.example.jobscoding.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JobsData(
    val companyLogo: String,
    val title: String,
    val companyName: String,
    val location: String,
    val minimumTalentExperience: String,
    val jobType: String,
    val createAt: String,
    val experationDate: String,
    val salary: String,
    val description: String,
    val companyEmloyeesSize: String,
    val url: String,
) : Parcelable