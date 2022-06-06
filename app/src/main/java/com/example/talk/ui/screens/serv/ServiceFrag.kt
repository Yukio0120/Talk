package com.example.talk.ui.screens.serv

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.text.format.DateFormat
import android.view.View
import android.widget.*
import com.example.talk.R
import com.example.talk.ui.screens.base.BFrag
import com.example.talk.utilits.APP_ACTIVITY
import com.example.talk.utilits.showToast
import kotlinx.android.synthetic.main.fragment_service.*
import java.util.*


class ServiceFrag : BFrag(R.layout.fragment_service), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    private var hour: Int = 0
    private var minute: Int = 0
    private var myDay = 0
    private var myMonth: Int = 0
    private var myYear: Int = 0
    private var myHour: Int = 0
    private var myMinute: Int = 0

    private var day = 0
    private var month: Int = 0
    private var year: Int = 0


    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = getString(R.string.service_call)
        initSpinner()
        initBtn()
        btnSendServ.setOnClickListener {
            showToast("Отправлено")
        }
    }

    private fun initBtn(){
        btnPick.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            day = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(APP_ACTIVITY, this, year, month, day)
            datePickerDialog.show()
        }
    }


    @SuppressLint("SetTextI18n")
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        myHour = hourOfDay
        myMinute = minute
        currentDateTime.text = "Date: " + myDay + "/" + myMonth + "/" + myYear + " || " + myHour + ":"  + myMinute
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = day
        myYear = year
        myMonth = month
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(
            APP_ACTIVITY, this, hour, minute,
            DateFormat.is24HourFormat(APP_ACTIVITY)
        )
        timePickerDialog.show()
    }


    private fun initSpinner() {
        val itemServ = resources.getStringArray(R.array.Service)

        // access the spinner
        val spinner = view?.findViewById<Spinner>(R.id.service_user_choice)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                APP_ACTIVITY,
                R.layout.smpl_spinner_item, itemServ)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                        APP_ACTIVITY
                        itemServ[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    showToast(message = "Nothing selected")
                }
            }
        }

    }

}



