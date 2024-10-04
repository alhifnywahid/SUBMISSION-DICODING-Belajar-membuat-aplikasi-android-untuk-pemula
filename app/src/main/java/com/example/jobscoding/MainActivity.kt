package com.example.jobscoding
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobscoding.adapter.ListJobsAdapter
import com.example.jobscoding.data.JobDataResources
import com.example.jobscoding.data.JobsData
import com.example.jobscoding.intent.AboutActivity
import com.example.jobscoding.intent.DetailJobsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var rvListJobs: RecyclerView
    private val list = ArrayList<JobsData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        rvListJobs = findViewById(R.id.rv_list_jobs)
//        list.addAll(getListJobs())
        list.addAll(JobDataResources.JobList)
        showRecyclerList()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showRecyclerList() {
        rvListJobs.layoutManager = LinearLayoutManager(this)
        val listJobsAdapter = ListJobsAdapter(list)
        rvListJobs.adapter = listJobsAdapter
        listJobsAdapter.setOnItemClickCallback(object : ListJobsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: JobsData) {
                val intent = Intent(this@MainActivity, DetailJobsActivity::class.java)
                intent.putExtra("data", data)
                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}