package com.room.roomsqlite.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.room.roomsqlite.R
import com.room.roomsqlite.ui.activity.siswa.TambahSiswaActivity

class SiswaFragment : Fragment() {
    lateinit var btnTambahSiswa : Button
    lateinit var tvStatus : TextView
    lateinit var rvSiswa : RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_siswa, container, false)
        init(root)
        mainButton()
        return root
    }

    private fun mainButton(){
        btnTambahSiswa.setOnClickListener {
            startActivity(Intent(requireActivity(), TambahSiswaActivity::class.java))
        }
    }

    private fun init(view: View){
        btnTambahSiswa = view.findViewById(R.id.btn_tambahsiswa)
        tvStatus = view.findViewById(R.id.tv_status)
        rvSiswa = view.findViewById(R.id.rv_siswa)
    }
}