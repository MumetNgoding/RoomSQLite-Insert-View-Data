package com.room.roomsqlite.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.room.roomsqlite.model.Kelas

@Dao
interface DaoKelas {
    @Insert(onConflict = REPLACE)
    fun insert(data : Kelas)

    @Delete
    fun delete(data: Kelas)

    @Update
    fun update(data: Kelas): Int

    @Query( "SELECT * FROM kelas ORDER BY id ASC")
    fun getALL() : List<Kelas>

    @Query( "SELECT * FROM kelas WHERE id = :id LIMIT 1")
    fun getById(id: Int): Kelas

    @Query( "DELETE FROM kelas")
    fun deleteAll(): Int
}