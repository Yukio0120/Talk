package com.example.talk.ui.screens.other

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import com.example.talk.R
import com.example.talk.ui.screens.base.BFrag
import com.example.talk.utilits.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.util.*


class CalendarFragment : BFrag(R.layout.fragment_calendar) {
    private lateinit var calendarView: CalendarView
    private lateinit var dateView: TextView

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = getString(R.string.navbar_calendar)
        initCal()
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

    private fun initCal() {
        val add = view?.findViewById<Button>(R.id.add_event)
        add?.setOnClickListener {
            val calendarEvent: Calendar = Calendar.getInstance()
            val intent = Intent(Intent.ACTION_EDIT)
            intent.type = "vnd.android.cursor.item/event"
            intent.putExtra("beginTime", calendarEvent.timeInMillis)
            intent.putExtra("allDay", true)
            intent.putExtra("rule", "FREQ=YEARLY")
            intent.putExtra("endTime", calendarEvent.timeInMillis + 60 * 60 * 1000)
            intent.putExtra("title", "Calendar Event")
            startActivity(intent)
        }
    }

}