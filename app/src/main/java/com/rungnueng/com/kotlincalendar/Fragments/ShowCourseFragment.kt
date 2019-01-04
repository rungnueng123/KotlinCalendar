package com.rungnueng.com.kotlincalendar.Fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.rungnueng.com.kotlincalendar.Adapter.CourseRecyclerAdapter
import com.rungnueng.com.kotlincalendar.Model.CourseListItem
import com.rungnueng.com.kotlincalendar.R

class ShowCourseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_show_course, container, false)
        initInstance(rootView, savedInstanceState)
        return rootView
    }

    private fun initInstance(rootView: View?, savedInstanceState: Bundle?) {

        val recyclerView: RecyclerView = rootView?.findViewById(R.id.recyclerView)!!
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)

        val courses = ArrayList<CourseListItem>()
        courses.add(CourseListItem(1,"course","03/01/2018"))
        val adapter = CourseRecyclerAdapter(courses)
        recyclerView.adapter = adapter

        loadData()

    }

    private fun loadData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    companion object {
        fun newInstance(): ShowCourseFragment {
            return ShowCourseFragment()
        }
    }
}
