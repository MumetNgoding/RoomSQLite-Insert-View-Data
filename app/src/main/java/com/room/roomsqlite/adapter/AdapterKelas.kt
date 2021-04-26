package com.room.roomsqlite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.room.roomsqlite.R
import com.room.roomsqlite.model.Kelas

class AdapterKelas(var data: ArrayList<Kelas>) : RecyclerView.Adapter<AdapterKelas.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_kelas,parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int{
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.tvNama.text = a.name
    }
}