package com.dzak.detikcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.dzak.detikcom.activity.DetailUsActivityActivity
import com.dzak.detikcom.databinding.ItemRecyclerNewsIndoBinding
import com.dzak.detikcom.model.ArticlesItem

class AdapterNewsUK(private val listNews : ArrayList<ArticlesItem> = arrayListOf()) : RecyclerView.Adapter<AdapterNewsUK.ViewHolder>(){

    @SuppressLint("NotifyDataSetChanged")
    fun adddatanewsuk(xrplambildata : List<ArticlesItem>){
        listNews.clear()
        listNews.addAll(xrplambildata)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding : ItemRecyclerNewsIndoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerNewsIndoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = listNews[position]

        holder.binding.txtTittle.text = news.title
        holder.binding.txtPublishat.text = news.publishedAt
        holder.binding.txtAuthor.text = news.author
        holder.binding.imgNewsindo.load(news.urlToImage){
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val pindah = Intent(it.context, DetailUsActivityActivity::class.java)
            pindah.putExtra(DetailUsActivityActivity.TITTLE_US,news.title)
            pindah.putExtra(DetailUsActivityActivity.PUBLISHET_US,news.publishedAt)
            pindah.putExtra(DetailUsActivityActivity.IMG_US,news.urlToImage)
            pindah.putExtra(DetailUsActivityActivity.AUTHOR_US,news.author)
            pindah.putExtra(DetailUsActivityActivity.DESK_US,news.description)
            pindah.putExtra(DetailUsActivityActivity.CONTENT_US,news.content)
            it.context.startActivity(pindah)
        }
    }

    override fun getItemCount(): Int {
        return  listNews.size
    }
}