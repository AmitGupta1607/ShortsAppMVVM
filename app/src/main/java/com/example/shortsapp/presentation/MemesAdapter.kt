package com.example.shortsapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shortsapp.data.Meme
import com.example.shortsapp.databinding.ItemMemeBinding

class MemesAdapter(val listItems:ArrayList<Meme>)
    : RecyclerView.Adapter<MemesAdapter.MemesViewHolder>() {

    class MemesViewHolder(val itemMemeBinding: ItemMemeBinding) : RecyclerView.ViewHolder(itemMemeBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemesViewHolder {
       val binding = ItemMemeBinding.inflate(LayoutInflater.from(parent.context),parent,false);
        return MemesViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MemesViewHolder, position: Int) {
        val item = listItems[position]
        holder.itemMemeBinding.titleMeme.text = item.name
        Glide.with(holder.itemView.context)
            .load(item.url)
            .into(holder.itemMemeBinding.imageViewMeme)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}