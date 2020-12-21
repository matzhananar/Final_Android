package com.example.final_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.final_android.MainActivity.Companion.countries

class CountryAdapter(
    val countries: ArrayList<Country>,
    val context: Context
) : RecyclerView.Adapter<CountryAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.first_page, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country = countries[position]
        holder.countryText.text = country.country
        holder.codeText.text = country.code

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("country" to country.country)
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryText: TextView = itemView.findViewById(R.id.country)
        var codeText: TextView = itemView.findViewById(R.id.code)
    }
}