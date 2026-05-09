package com.example.animepromix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// Data class to hold Anime info
data class Anime(val name: String, val image: String)

class AnimeAdapter(private val animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val animeImage: ImageView = view.findViewById(R.id.animeImage)
        val animeTitle: TextView = view.findViewById(R.id.animeTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val currentAnime = animeList[position]
        holder.animeTitle.text = currentAnime.name

        // Loading image using Glide
        Glide.with(holder.itemView.context)
            .load(currentAnime.image)
            .into(holder.animeImage)
    }

    override fun getItemCount(): Int = animeList.size
}