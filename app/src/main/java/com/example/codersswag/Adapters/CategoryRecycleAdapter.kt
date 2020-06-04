package com.example.codersswag.Adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.codersswag.Model.Category
import com.example.codersswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*


class CategoryRecycleAdapter(val context: Context, val categories: List<Category>) : Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(Holder: Holder, position: Int) {
        Holder?.bindCategory(categories[position], context)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<ImageView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title

        }
    }

}