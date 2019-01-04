package com.rungnueng.com.kotlincalendar.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rungnueng.com.kotlincalendar.Fragments.CourseFragment
import com.rungnueng.com.kotlincalendar.R

class CourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        initInstance(savedInstanceState)
    }

    private fun initInstance(savedInstanceState: Bundle?) {

        //Add Fragment
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, CourseFragment.newInstance(), "rageComicList")
                .commit()
        }
    }
}
