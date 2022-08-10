package com.dzak.detikcom.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzak.detikcom.databinding.ItemRecyclerProvinsiCovidBinding
import com.dzak.detikcom.model.DataItem

class AdapterProvinsiCovid : RecyclerView.Adapter<AdapterProvinsiCovid.ViewHolder>() {
    private var listprovinsi: ArrayList<DataItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataProv(provambildata : List<DataItem>){
        listprovinsi.clear()
        listprovinsi.addAll(provambildata)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bindingitemprovinsi = ItemRecyclerProvinsiCovidBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(bindingitemprovinsi)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listdata = listprovinsi[position]
        holder.binding.txtKotaprov.text = listdata.provinsi
        holder.binding.txtJumlahpositifprov.text = listdata.kasusPosi
        holder.binding.txtJumlahsembuhprov.text = listdata.kasusSemb
        holder.binding.txtJumlahmatiprov.text = listdata.kasusMeni
    }

    override fun getItemCount() = listprovinsi.size

    class ViewHolder(var binding: ItemRecyclerProvinsiCovidBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}
