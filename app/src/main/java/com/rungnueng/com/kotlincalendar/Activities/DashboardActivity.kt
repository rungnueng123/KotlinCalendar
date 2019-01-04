package com.rungnueng.com.kotlincalendar.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.rungnueng.com.kotlincalendar.Fragments.ShowCourseFragment
import com.rungnueng.com.kotlincalendar.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        initInstance(savedInstanceState)
    }

    private fun initInstance(savedInstanceState: Bundle?) {
        //Add Fragment
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, ShowCourseFragment.newInstance(), "rageComicList")
                .commit()
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_add -> {
                val intent = Intent(this, CalendarActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
