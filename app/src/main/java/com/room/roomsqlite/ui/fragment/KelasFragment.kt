package com.room.roomsqlite.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.room.roomsqlite.R
import com.room.roomsqlite.adapter.AdapterKelas
import com.room.roomsqlite.model.Kelas
import com.room.roomsqlite.room.MyDatabase
import com.room.roomsqlite.ui.activity.kelas.TambahKelasActivity

class KelasFragment : Fragment() {
    lateinit var myDb: MyDatabase
    lateinit var btnTambahKelas : Button
    lateinit var tvStatus : TextView
    lateinit var rvKelas : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_kelas, container, false)
        init(root)
        myDb = MyDatabase.getInstance(requireActivity())!!
        displayKelas()
        mainButton()
        return root
    }

    private fun mainButton(){
        btnTambahKelas.setOnClickListener {
            startActivity(Intent(requireActivity(), TambahKelasActivity::class.java))
        }
    }

    private fun displayKelas() {
        val listKelas = myDb.daoKelas().getALL()
        if (listKelas.isEmpty()){
            tvStatus.visibility = View.VISIBLE
        }else{
            tvStatus.visibility = View.GONE
        }
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvKelas.adapter =
            AdapterKelas(listKelas as ArrayList<Kelas>)
        rvKelas.layoutManager = layoutManager
    }

    private fun init(view: View){
        btnTambahKelas = view.findViewById(R.id.btn_tambahkelas)
        tvStatus = view.findViewById(R.id.tv_status)
        rvKelas = view.findViewById(R.id.rv_kelas)
    }

    override fun onResume() {
        displayKelas()
        super.onResume()

    }
}