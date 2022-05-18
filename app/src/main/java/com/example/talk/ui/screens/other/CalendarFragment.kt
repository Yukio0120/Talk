package com.example.talk.ui.screens.other

import android.widget.CalendarView
import android.widget.TextView
import com.example.talk.R
import com.example.talk.ui.screens.base.BFrag
import com.example.talk.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_calendar.*


class CalendarFragment : BFrag(R.layout.fragment_calendar) {
    private lateinit var calendarView: CalendarView
    private lateinit var dateView: TextView

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = getString(R.string.navbar_calendar)
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