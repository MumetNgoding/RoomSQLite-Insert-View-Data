package com.room.roomsqlite.ui.activity.siswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.room.roomsqlite.R
import kotlinx.android.synthetic.main.activity_tambah_siswa.*

class TambahSiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_siswa)

        btn_simpan.setOnClickListener {
            if (edt_kode.text.toString().isEmpty()) {
                edt_kode.error = "Kolom Kode Tidak Boleh Kosong"
                edt_kode.requestFocus()
            }else if( edt_nama.text.toString().isEmpty()) {
                edt_nama.error = "Kolom Nama Siswa Tidak Boleh Kosong"
                edt_nama.requestFocus()
            }else {
                toast("Data Berhasil Tersimpan")
                onBackPressed()
            }

        }
    }

    private fun toast(string: String){
        Toast.makeText( this, string, Toast.LENGTH_SHORT).show()
    }
}