package com.example.codersswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.codersswag.Model.Category
import com.example.codersswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

                                                                                //LAMDA Expression For item Click In Recycle View
class CategoryRecycleAdapter(val context: Context, val categories: List<Category>, val itemClick : (Category) -> Unit) : Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(Holder: Holder, position: Int) {
        Holder?.bindCategory(categories[position], context)
    }


    inner class Holder(itemView: View, val itemClick : (Category) -> Unit /*LAMDA uses Here*/) : RecyclerView.ViewHolder(itemView) {

        //Finding item From categori_item_list which is created for showing items
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        //Function for OnBind view holder to passing the view
        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title

            //Creating onClcikListener using Lamda
            itemView.setOnClickListener {
                itemClick(category)
            }
        }
    }

}