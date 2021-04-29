package com.room.roomsqlite.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.room.roomsqlite.model.Kelas
import java.security.AccessControlContext

@Database(entities = [Kelas::class], version = 1)
abstract class  MyDatabase : RoomDatabase() {
    abstract fun daoKelas(): DaoKelas

    companion object {

        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase?{
if (INSTANCE == null) {
    synchronized(MyDatabase::class) {

        INSTANCE = Room.databaseBuilder(
        context.applicationContext,
        MyDatabase::class.java, "databaseCRUD"

         ).allowMainThreadQueries().build()
        }
        }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}