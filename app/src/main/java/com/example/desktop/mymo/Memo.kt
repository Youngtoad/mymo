package com.example.desktop.mymo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Memo")
data class Memo(
    @PrimaryKey(autoGenerate = true) val mid: Int,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "contents") var contents: String?,
    @ColumnInfo(name = "star") var star: Boolean
){
    constructor(): this(0,"", "",false)
}
