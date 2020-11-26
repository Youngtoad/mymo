package com.example.desktop.mymo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        MyApplication.prefs.setString("email", "test@ajou.ac.kr")
        MyApplication.prefs.setString("name", "Youngtoad")

        //어댑터 설정
        var data:MutableList<Memo> = setData()
        var adapter = MemoAdapter()
        adapter.memoData = data
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.baseline_menu_white_24dp)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
    }

    fun setData(): MutableList<Memo>{   //List형식의 데이터를 만드는 함수
        var data:MutableList<Memo> = mutableListOf()
        for(num in 1..10){
            var title = "${num}번째 타이틀"
            var memodata = Memo(num, title)
            data.add(memodata)  //for문으로 생성된 데이터를 list에 add
        }
        return data //다 만들어진 후 return
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            android.R.id.home->{
                val tv_nav_em = findViewById<TextView>(R.id.nav_email)
                val tv_nav_name = findViewById<TextView>(R.id.nav_name)

                tv_nav_em.setText(MyApplication.prefs.getString("email", "no email"))
                tv_nav_name.text = MyApplication.prefs.getString("name", "no name")

                drawerLayout.openDrawer(GravityCompat.START)
            }
            R.id.menu_search->{
                Snackbar.make(toolbar,"Search Menu pressed",Snackbar.LENGTH_SHORT).show()
            }
            R.id.menu_account->{
                Snackbar.make(toolbar,"Account Menu pressed",Snackbar.LENGTH_SHORT).show()
            }
            R.id.menu_logout->{
                Snackbar.make(toolbar,"Logout Menu pressed",Snackbar.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.list_memo->Snackbar.make(toolbar,"메모 목록",Snackbar.LENGTH_SHORT).show()
            R.id.star->Snackbar.make(toolbar,"즐겨찾기",Snackbar.LENGTH_SHORT).show()
            R.id.trash->Snackbar.make(toolbar,"휴지통",Snackbar.LENGTH_SHORT).show()
            R.id.setting->Snackbar.make(toolbar,"설정",Snackbar.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers()
        }else{
            super.onBackPressed()
        }
    }

}