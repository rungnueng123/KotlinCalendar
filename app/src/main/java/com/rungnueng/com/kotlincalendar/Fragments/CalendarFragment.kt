package com.rungnueng.com.kotlincalendar.Fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import com.rungnueng.com.kotlincalendar.R

class CalendarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_calendar, container, false)
        initInstances(rootView, savedInstanceState)
        return rootView
    }

    private fun initInstances(rootView: View?, savedInstanceState: Bundle?) {

        //Add Course
        val AddCourse: Button? = rootView?.findViewById(R.id.add_course)
        AddCourse?.setOnClickListener {
            Toast.makeText(activity,"aaaa",Toast.LENGTH_LONG).show()
        }

        //Click Calendar
        val calendarView: CalendarView? = rootView?.findViewById(R.id.calendarView)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val msg = "Selected date is " + dayOfMonth + "/" + (month + 1) + "/" + year
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()

        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(): CalendarFragment {
            return CalendarFragment()
        }
    }
}
