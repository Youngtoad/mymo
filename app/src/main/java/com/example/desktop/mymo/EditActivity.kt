package com.example.desktop.mymo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayShowTitleEnabled(false)
        }
    }
}