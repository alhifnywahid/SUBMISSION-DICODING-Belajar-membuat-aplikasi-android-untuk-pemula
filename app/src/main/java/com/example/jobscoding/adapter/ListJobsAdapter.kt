package com.example.jobscoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jobscoding.R
import com.example.jobscoding.data.JobsData

class ListJobsAdapter(private val listHero: ArrayList<JobsData>) : RecyclerView.Adapter<ListJobsAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyLogo: ImageView = itemView.findViewById(R.id.img_item_photo)
        val title: TextView = itemView.findViewById(R.id.tv_item_name)
        val companyName: TextView = itemView.findViewById(R.id.tv_company_name)
        val location: TextView = itemView.findViewById(R.id.tv_location)
        val minimumTalentExperience: TextView = itemView.findViewById(R.id.tv_range)
        val jobType: TextView = itemView.findViewById(R.id.tv_fulltime)
        val createdAt: TextView = itemView.findViewById(R.id.tv_created_at)
        val expiredAt: TextView = itemView.findViewById(R.id.tv_expired)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListJobsAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_jobs, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListJobsAdapter.ListViewHolder, position: Int) {
        val (companyLogo, title, companyName, location, minimumTalentExperience, jobType, createdAt, expiredAt ) = listHero[position]
        Glide.with(holder.itemView.context).load(companyLogo).into(holder.companyLogo)
        holder.title.text = title
        holder.companyName.text = companyName
        holder.location.text = location
        holder.minimumTalentExperience.text = minimumTalentExperience
        holder.jobType.text = jobType
        holder.createdAt.text = createdAt
        holder.expiredAt.text = expiredAt
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listHero.size

    interface OnItemClickCallback {
        fun onItemClicked(data: JobsData)
    }
}