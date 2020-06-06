package com.example.codersswag.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.codersswag.Adapters.ProductAdapter
import com.example.codersswag.R
import com.example.codersswag.Services.DataService
import com.example.codersswag.Utility.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)


        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductAdapter(this, DataService.getProducts(categoryType))

        //Orientation span count function when mobile in landscapae mode (rotate into landScape mode)
        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        //Fuctions for large screen size collums
        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }



        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}