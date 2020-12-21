package com.example.final_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    val categories: ArrayList<Category>,
    val context: Context
) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.first_page, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val category = MainActivity.categories[position]
        holder.businessText.text = category.business
        holder.entertainmentText.text = category.entertainment
        holder.generalText.text = category.general
        holder.healthText.text = category.health
        holder.scienceText.text = category.science
        holder.sportsText.text = category.sports
        holder.technologyText.text = category.technology


        holder.itemView.setOnClickListener {
            val bundle = bundleOf("category" to category.business)
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var businessText: TextView = itemView.findViewById(R.id.business)
        var entertainmentText: TextView = itemView.findViewById(R.id.entertainment)
        var generalText: TextView = itemView.findViewById(R.id.general)
        var healthText: TextView = itemView.findViewById(R.id.health)
        var scienceText: TextView = itemView.findViewById(R.id.science)
        var sportsText: TextView = itemView.findViewById(R.id.sports)
        var technologyText: TextView = itemView.findViewById(R.id.technology)
    }
}