package com.example.desktop.mymo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Memo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao
}
