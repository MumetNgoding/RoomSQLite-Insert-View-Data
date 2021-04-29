package com.room.roomsqlite.ui.activity.kelas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.room.roomsqlite.R
import com.room.roomsqlite.model.Kelas
import com.room.roomsqlite.room.MyDatabase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_tambah_kelas.*
import java.util.*

class TambahKelasActivity : AppCompatActivity() {
    lateinit var myDb : MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_kelas)

                myDb = MyDatabase.getInstance(this)!!

        btn_simpan.setOnClickListener {
                if (edt_kode.text.toString().isEmpty()) {
                    edt_kode.error = "Kolom Kode Tidak Boleh Kosong"
                    edt_kode.requestFocus()
                }else if( edt_nama2.text.toString().isEmpty()) {
                    edt_nama2.error = "Kolom Nama Kelas Tidak Boleh Kosong"
                    edt_nama2.requestFocus()
                }else {
                val  kelas = Kelas()
                    kelas.kodekelas = edt_kode.text.toString()
                    kelas.name = edt_nama2.text.toString()
                    simpan(kelas)
                }

        }
    }
    private fun simpan(data : Kelas){
            CompositeDisposable().add(Observable.fromCallable { myDb.daoKelas().insert(data) }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
           toast("Data Berhasil Tersimpan")
           onBackPressed()
       }


   )
}
    private fun toast(string: String){
        Toast.makeText( this, string, Toast.LENGTH_SHORT).show()
    }
}

