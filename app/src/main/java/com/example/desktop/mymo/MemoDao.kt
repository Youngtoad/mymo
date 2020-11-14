package com.example.desktop.mymo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDao {
    @Query("SELECT * FROM memo")
    fun getAll(): List<Memo>

    @Query("SELECT * FROM memo WHERE mid IN (:memoIds)")
    fun loadAllByIds(memoIds: IntArray): List<Memo>

    @Query("SELECT * FROM memo WHERE title LIKE :t AND " +
            "contents LIKE :ct")
    fun findByName(t: String, ct: String): Memo

    @Insert
    fun insertAll(vararg memos: Memo)

    @Delete
    fun delete(memo: Memo)
}
