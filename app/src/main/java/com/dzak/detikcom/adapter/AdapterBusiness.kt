package com.dzak.detikcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.dzak.detikcom.activity.DetailIndoNewsActivity
import com.dzak.detikcom.databinding.ItemRecyclerNewsIndoBinding
import com.dzak.detikcom.model.ArticlesItem

class AdapterBusiness : RecyclerView.Adapter<AdapterBusiness.ViewHolder>() {

    private var listdatabusiness: ArrayList<ArticlesItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun adddatanews(businessambildata : List<ArticlesItem>){
        listdatabusiness.clear()
        listdatabusiness.addAll(businessambildata)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bindingitemnewsindo =
            ItemRecyclerNewsIndoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bindingitemnewsindo)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var dataartikel = listdatabusiness[position]

        holder.binding.txtTittle.text = dataartikel.title
        holder.binding.txtAuthor.text = dataartikel.author
        holder.binding.txtPublishat.text = dataartikel.publishedAt
        holder.binding.imgNewsindo.load(dataartikel.urlToImage){
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val pindah = Intent(it.context, DetailIndoNewsActivity::class.java)
            pindah.putExtra(DetailIndoNewsActivity.TITLE_uk,dataartikel.title)
            pindah.putExtra(DetailIndoNewsActivity.PUBLISHAT_uk,dataartikel.publishedAt)
            pindah.putExtra(DetailIndoNewsActivity.IMG_uk,dataartikel.urlToImage)
            pindah.putExtra(DetailIndoNewsActivity.AUTHOR_uk,dataartikel.author)
            pindah.putExtra(DetailIndoNewsActivity.DESK_uk,dataartikel.description)
            pindah.putExtra(DetailIndoNewsActivity.CONTENT_uk,dataartikel.content)
            it.context.startActivity(pindah)
        }


    }

    override fun getItemCount() = listdatabusiness.size

    class ViewHolder(var binding: ItemRecyclerNewsIndoBinding) :
        RecyclerView.ViewHolder(binding.root)
}