package com.room.roomsqlite.ui.activity.siswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.room.roomsqlite.R
import com.room.roomsqlite.model.Kelas
import com.room.roomsqlite.room.MyDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_tambah_kelas.*
import kotlinx.android.synthetic.main.activity_tambah_siswa.*
import kotlinx.android.synthetic.main.activity_tambah_siswa.btn_simpan
import kotlinx.android.synthetic.main.activity_tambah_siswa.edt_kode
import kotlinx.android.synthetic.main.activity_tambah_siswa.edt_nama

class TambahSiswaActivity : AppCompatActivity() {
    lateinit var myDb : MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_siswa)

        myDb = MyDatabase.getInstance(this)!!

        btn_simpan.setOnClickListener {
            if (edt_kode.text.toString().isEmpty()) {
                edt_kode.error = "Kolom Kode Tidak Boleh Kosong"
                edt_kode.requestFocus()
            }else if( edt_nama.text.toString().isEmpty()) {
                edt_nama.error = "Kolom Nama Siswa Tidak Boleh Kosong"
                edt_nama.requestFocus()
            }else {
                val kelas = Kelas()
                kelas.name = edt_nama.toString()
                simpan(kelas)
            }
        }
    }

    private fun simpan(data: Kelas) {
        CompositeDisposable().add(Observable.fromCallable { myDb.daoKelas().insert(data) }
                .subscribeOn(Schedulers.computation())
                .observeOn((AndroidSchedulers.mainThread()))
                .subscribe{
                    toast("Data kelas berhasil disimpan")
                    onBackPressed()
                }
        )
    }

    private fun toast(string: String){
        Toast.makeText( this, string, Toast.LENGTH_SHORT).show()
    }
}