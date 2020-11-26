package com.example.desktop.mymo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @PrimaryKey val mid: Int,
    @ColumnInfo(name = "title") val title: String?
)
