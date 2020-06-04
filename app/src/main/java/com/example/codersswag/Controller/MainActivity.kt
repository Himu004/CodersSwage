package com.example.codersswag.Controller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.codersswag.Adapters.CategoryAdapter
import com.example.codersswag.Model.Category
import com.example.codersswag.R
import com.example.codersswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)
        categoryListView.adapter = adapter

        //Toast message on click the item
        //categoryListView.setOnItemClickListener{adapterView, view: View?, position: Int, id: Long ->
            //val category = DataService.categories[position]
            //Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show() }
    }
}