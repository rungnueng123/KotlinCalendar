package com.rungnueng.com.kotlincalendar.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.rungnueng.com.kotlincalendar.R
import com.rungnueng.com.kotlincalendar.Singleton.VolleySingleton
import kotlinx.android.synthetic.main.fragment_course.*
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class CourseFragment : Fragment() {

    private lateinit var calendar: Calendar
    var edtCourse: EditText? = null
    //IPv4 ของเครื่องเรา
//    private val addUrl: String = "http://192.168.99.1/KotlinCalendarPHP/AddCourse.php"
    //IPv4 ของ internet
    private val addUrl: String = "http://10.10.30.92/KotlinCalendarPHP/AddCourse.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_course, container, false)
        initInstances(rootView, savedInstanceState)
        return rootView
    }

    private fun initInstances(rootView: View?, savedInstanceState: Bundle?) {

        calendar = Calendar.getInstance()
        edtCourse = rootView?.findViewById(R.id.edt_course)
        val btnAdd: Button? = rootView?.findViewById(R.id.button_get)

        // Set a click listener for get date button widget
        btnAdd?.setOnClickListener {
            // Get the date picker widget selected date
            val selectedDate = formatDate(date_picker.year, date_picker.month, date_picker.dayOfMonth)
            // Display the date picker selected formatted date
            text_view.text = "Selected Date : $selectedDate" + edtCourse?.text

            addCourse()
        }

    }

    private fun addCourse() {
        val courseName = edtCourse?.text.toString()
        val selectedDate = formatDate(date_picker.year, date_picker.month, date_picker.dayOfMonth)
        val stringRequest = object : StringRequest(Request.Method.POST, addUrl, Response.Listener<String> { response ->
            try {
                val obj = JSONObject(response)
                Toast.makeText(context, obj.getString("message"), Toast.LENGTH_LONG).show()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        },
            object : Response.ErrorListener {
                override fun onErrorResponse(volleyError: VolleyError) {
                    Toast.makeText(context, volleyError.message, Toast.LENGTH_LONG).show()
                }
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params.put("CourseName", courseName)
                params.put("Date", selectedDate)
                return params
            }
        }
        VolleySingleton.instance?.addToRequestQueue(stringRequest)

//        Toast.makeText(activity,courseName+" "+selectedDate,Toast.LENGTH_LONG).show()

    }

    // Custom method to format date
    @SuppressLint("SimpleDateFormat")
    private fun formatDate(year: Int, month: Int, day: Int): String {
        // Create a Date variable/object with user chosen date
        calendar.set(year, month, day, 0, 0, 0)
        val chosenDate = calendar.time

        // Format the date picker selected date
//        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        val df = SimpleDateFormat("yyy/MM/dd")
        return df.format(chosenDate)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(): CourseFragment {
            return CourseFragment()
        }
    }
}
