package com.example.myframgmentapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.text.DateFormat
import java.util.*

class HomeFragment : Fragment() {
    var datetime = Calendar.getInstance() // get the Current Date and Time
    var df = DateFormat.getDateTimeInstance() // use the Date Time format of Month,DD,YYYY HH:mm:SS
    lateinit var bt1 : Button
    lateinit var bt2 : Button

    // TimePickerDialog Listener Implementation to set the Picked Time
    var t:TimePickerDialog.OnTimeSetListener =
        TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            datetime.set(Calendar.HOUR_OF_DAY, hourOfDay)
            datetime.set(Calendar.MINUTE, minute)
            updateLabel()
        }
    // DatePickerDialog Listener Implementation to set the Picked Date
      var d:DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            datetime.set(Calendar.YEAR, year)
            datetime.set(Calendar.MONTH, month)
            datetime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel()
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val view = inflater!!.inflate(R.layout.fragment_home, container, false)
         bt1 = view.findViewById(R.id.bt1) as Button
        bt2 = view.findViewById(R.id.bt2) as Button
        // Implementing Button Listener for Date Picker
       bt1.setOnClickListener {
            updateDate() // Call to set the Date from DataPicker
        }
        // Implementing Button Listener for Time Picker
        bt2.setOnClickListener {
            updateTime() // Call to set the Time from TimePicker
        }
        updateLabel() // Calling this method to set the Data and Time in TextView

        // Inflate the layout for this fragment
        return view
    }

    // Method helps to set the Date and Time in TextView
    private fun updateLabel() {
        tv1?.text = df.format(datetime.time)
    }
    /* Creating object for DatePickerDialog by passing current activity, object of DatePickerDialog, YYYY,Month,Day.
   * Then call the show method to display the DatePickerDialog*/
    private fun updateDate() {
        DatePickerDialog(activity, d, datetime.get(Calendar.YEAR), datetime.get(Calendar.MONTH), datetime.get(Calendar.DAY_OF_MONTH)).show()
    }
    /* Creating object for TimePickerDialog by passing current activity, object of TimePickerDialog, HH,mm,boolean.
   Here boolean is24HourView as true or false
   Then call the show method to display the DatePickerDialog*/
    private fun updateTime() {
        TimePickerDialog(activity, t, datetime.get(Calendar.HOUR_OF_DAY), datetime.get(Calendar.MINUTE), true).show()
    }
}
