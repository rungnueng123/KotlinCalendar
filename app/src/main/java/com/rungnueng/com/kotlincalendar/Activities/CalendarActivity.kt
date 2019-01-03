package com.rungnueng.com.kotlincalendar.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rungnueng.com.kotlincalendar.Fragments.CalendarFragment
import com.rungnueng.com.kotlincalendar.R

class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        initInstance(savedInstanceState)
    }

    private fun initInstance(savedInstanceState: Bundle?) {

        //Add Fragment
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, CalendarFragment.newInstance(), "rageComicList")
                .commit()
        }
    }
}
