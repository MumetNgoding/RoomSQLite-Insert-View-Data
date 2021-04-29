package com.room.roomsqlite.ui.activity.kelas

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

class EditKelasActivity : AppCompatActivity() {

    lateinit var myDb: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_kelas)

        myDb = MyDatabase.getInstance(this)!!
        val idKelas = intent.getStringExtra("idKelas")!!.toString()

        val kelas : Kelas
        val id : Int = Integer.valueOf(idKelas)
        kelas = myDb.daoKelas().getById(id)

        edt_kode.setText(kelas.kodekelas)
        edt_nama2.setText(kelas.name)
        btn_simpan.setOnClickListener{
            if (edt_nama2.text.toString().isEmpty()){
                edt_nama2.error = "Kolom nama harus diisi!!"
                edt_nama2.requestFocus()
            } else {
                kelas.kodekelas = edt_kode.text.toString()
                kelas.name = edt_nama2.text.toString()
                updateKelas(kelas)
            }
        }
    }
    fun updateKelas(data: Kelas){
        CompositeDisposable()
            .add(Observable.fromCallable { myDb.daoKelas().update(data) }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    toast("data kelas berhasil di edit")
                    onBackPressed()
                }
            )
    }

    private fun toast(string: String){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }
}