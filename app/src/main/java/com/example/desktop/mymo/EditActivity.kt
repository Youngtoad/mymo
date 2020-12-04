package com.example.desktop.mymo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar

class EditActivity : AppCompatActivity() {
    var memoDb : MemoDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setSupportActionBar(toolbar)

        val et_title = findViewById<EditText>(R.id.edit_title)
        val et_contents = findViewById<EditText>(R.id.edit_contents)

        var mid = intent.getIntExtra("mid", 0)

        if(mid != 0){
            Snackbar.make(toolbar,"${mid}", Snackbar.LENGTH_SHORT).show()
            val oldMemo = memoDb?.memoDao()?.get(mid)
            et_title.setText(oldMemo?.title)
            et_contents.setText(oldMemo?.contents)
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        memoDb = MemoDatabase.getInstance(this)
        when(item!!.itemId){
            android.R.id.home-> onBackPressed()
            R.id.menu_store -> {
                val addRunnable = Runnable {
                    val newMemo = Memo()
                    newMemo.title = edit_title.text.toString()
                    newMemo.contents = edit_contents.text.toString()
                    memoDb?.memoDao()?.insert(newMemo)
                }

                val addThread = Thread(addRunnable)
                addThread.start()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
                Snackbar.make(toolbar,"저장되었습니다!", Snackbar.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}