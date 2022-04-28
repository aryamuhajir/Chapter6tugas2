package com.binar.chapter6tugas2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.chapter6tugas2.Model.GetAllFilmResponseItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_film_adapter.view.*

class RvAdapter() : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    private var datafilm : List<GetAllFilmResponseItem>? = null

    fun setDataFilm(film : List<GetAllFilmResponseItem>){
        this.datafilm = film
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_film_adapter, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
        holder.itemView.judulFilm.text = datafilm!![position].title
        holder.itemView.tanggalFilm.text = datafilm!![position].createdAt
        holder.itemView.sutradaraFilm.text = datafilm!![position].director
        Glide.with(holder.itemView.context).load(datafilm!![position].image).apply(RequestOptions().override(120, 120)).into(holder.itemView.imageFilm)





    }

    override fun getItemCount(): Int {
        if (datafilm == null){
            return 0
        }else{
            return datafilm!!.size

        }
    }
}