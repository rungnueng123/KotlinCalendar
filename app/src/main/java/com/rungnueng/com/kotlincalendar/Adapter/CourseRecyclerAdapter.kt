package com.rungnueng.com.kotlincalendar.Adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rungnueng.com.kotlincalendar.Model.CourseListItem
import com.rungnueng.com.kotlincalendar.R
import kotlinx.android.synthetic.main.course_list_items.view.*

class CourseRecyclerAdapter(private val courses: ArrayList<CourseListItem>) :
    RecyclerView.Adapter<CourseRecyclerAdapter.CoursesHolder>() {

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: CourseRecyclerAdapter.CoursesHolder, position: Int) {
        val itemCourses = courses[position]
        holder.bindCourses(itemCourses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseRecyclerAdapter.CoursesHolder {
        val inflatedView = LayoutInflater.from(parent?.context).inflate(R.layout.course_list_items, parent, false)
        return CoursesHolder(inflatedView)
    }

    class CoursesHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var courses: CourseListItem? = null

        init {
            v.setOnClickListener { this }
        }

        override fun onClick(v: View?) {
            Log.d("RecyclerView", "CLICK!")
        }

        fun bindCourses(courses: CourseListItem) {
            this.courses = courses
            view.txt_course_name.text = courses.CourseName
            view.txt_course_date.text = courses.Date.toString()
        }
    }

}