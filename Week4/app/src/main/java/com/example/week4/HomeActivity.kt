package com.example.week4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_id)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SimpleAdapter()
    }
}

class SimpleViewHolder(val root: TextView) : RecyclerView.ViewHolder(root)

class SimpleAdapter : RecyclerView.Adapter<SimpleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val txtView = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_row, parent, false)
        return SimpleViewHolder(txtView as TextView)
    }

    override fun onBindViewHolder(viewHolder: SimpleViewHolder, position: Int) {
        viewHolder.root.text = "HELLO"
    }

    override fun getItemCount(): Int {
        return AppData.countries.size
    }
}