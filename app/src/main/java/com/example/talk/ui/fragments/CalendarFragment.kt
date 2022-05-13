package com.example.talk.ui.fragments

import android.content.Intent
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import com.example.talk.R
import com.example.talk.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.util.*


class CalendarFragment : BaseFragment(R.layout.fragment_calendar) {
    private lateinit var calendarView: CalendarView
    private lateinit var dateView: TextView

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Календарь"
        initCalendar()
    }

    private fun initCalendar() {
        calendarView = calender
        dateView = data_view_calendar
        calendarView.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
           val date = dayOfMonth.toString() + "−" + (month + 1) + "−" + year
           dateView.text = date
       })
    }

}