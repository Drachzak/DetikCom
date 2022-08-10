package com.dzak.detikcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.dzak.detikcom.activity.DetailUsActivityActivity
import com.dzak.detikcom.databinding.ActivityNewsUsBinding
import com.dzak.detikcom.databinding.ItemRecyclerNewsIndoBinding
import com.dzak.detikcom.model.ArticlesItem

class AdapterNewsUS : RecyclerView.Adapter<AdapterNewsUS.ViewHolder>() {

    private var listnewsUS : ArrayList<ArticlesItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataNewsUs(newsambildata : List<ArticlesItem>){
        listnewsUS.clear()
        listnewsUS.addAll(newsambildata)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val bindingitemnewsus = ItemRecyclerNewsIndoBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(bindingitemnewsus)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikelus = listnewsUS[position]
        holder.binding.txtTittle.text = dataartikelus.title
        holder.binding.txtAuthor.text = dataartikelus.author
        holder.binding.txtPublishat.text = dataartikelus.publishedAt
        holder.binding.imgNewsindo.load(dataartikelus.urlToImage){
            scale(Scale.FILL)

            holder.itemView.setOnClickListener {
                val pindah = Intent(it.context,DetailUsActivityActivity::class.java)
                pindah.putExtra(DetailUsActivityActivity.TITTLE_US,dataartikelus.title)
                pindah.putExtra(DetailUsActivityActivity.PUBLISHET_US,dataartikelus.publishedAt)
                pindah.putExtra(DetailUsActivityActivity.IMG_US,dataartikelus.urlToImage)
                pindah.putExtra(DetailUsActivityActivity.AUTHOR_US,dataartikelus.author)
                pindah.putExtra(DetailUsActivityActivity.DESK_US,dataartikelus.description)
                pindah.putExtra(DetailUsActivityActivity.CONTENT_US,dataartikelus.content)
                it.context.startActivity(pindah)
            }
        }
    }

    override fun getItemCount() = listnewsUS.size

    class ViewHolder(var binding: ItemRecyclerNewsIndoBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    }

