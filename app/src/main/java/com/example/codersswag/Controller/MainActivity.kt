package com.example.codersswag.Controller

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codersswag.Adapters.CategoryAdapter
import com.example.codersswag.Adapters.CategoryRecycleAdapter
import com.example.codersswag.Model.Category
import com.example.codersswag.R
import com.example.codersswag.Services.DataService
import com.example.codersswag.Utility.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)



        //Toast message on click the item
        //categoryListView.setOnItemClickListener{adapterView, view: View?, position: Int, id: Long ->
            //val category = DataService.categories[position]
            //Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show() }
    }
}