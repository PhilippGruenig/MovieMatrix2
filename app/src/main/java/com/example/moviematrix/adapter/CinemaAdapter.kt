package com.example.moviematrix.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviematrix.R
import com.example.moviematrix.data.model.Cinema
import com.example.moviematrix.ui.FragmentCinema
import com.example.moviematrix.ui.FragmentCinemaDirections

class CinemaAdapter(
    private val context: Context,
    private val dataset: List<Cinema>
    ) : RecyclerView.Adapter<CinemaAdapter.ItemViewHolder>(){

        class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val name: TextView = view.findViewById(R.id.cinema_name)
            val button: ImageButton = itemView.findViewById(R.id.cinema_button)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.cinema_item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]
        holder.name.text = item.name
        holder.button.setOnClickListener { view ->
            view.findNavController()
                .navigate(FragmentCinemaDirections.actionFragmentCinemaToFragmentMovies())

        }
    }
    override fun getItemCount(): Int {
        return  dataset.size
    }

}

