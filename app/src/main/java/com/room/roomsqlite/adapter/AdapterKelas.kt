package com.room.roomsqlite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.room.roomsqlite.R
import com.room.roomsqlite.model.Kelas
import kotlinx.android.synthetic.main.item_kelas.view.*


class AdapterKelas( var data: ArrayList<Kelas>, var listener: Listeners) : RecyclerView.Adapter<AdapterKelas.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val btnEdit = view.findViewById<TextView>(R.id.btn_edit)
        val btnHapus = view.findViewById<TextView>(R.id.btn_hapus)
        val layout = view.findViewById<LinearLayout>(R.id.layout)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_kelas,parent, false)
        return  Holder(view)
    }
    override fun getItemCount(): Int{
        return data.size

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.tvNama.text = a.name

        holder.layout.setOnClickListener {

        }
        holder.btnEdit.setOnClickListener {
            listener.onEditClicked(a)
        }
        holder.btnHapus.setOnClickListener {
            listener.onDeleteClicked(a)
        }
    }

    interface Listeners {
        fun onDeleteClicked(kelas: Kelas)
        fun onEditClicked(kelas: Kelas)
    }
}