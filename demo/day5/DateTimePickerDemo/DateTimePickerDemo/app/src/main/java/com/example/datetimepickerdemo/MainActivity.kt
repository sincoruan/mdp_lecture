package com.example.datetimepickerdemo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() , View.OnClickListener{
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      bt1.setOnClickListener(this)
      bt2.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
      when(v?.id){
          R.id.bt1 -> {
              val c = Calendar.getInstance()
              val mYear = c.get(Calendar.YEAR)
              val  mMonth = c.get(Calendar.MONTH)
              val  mDay = c.get(Calendar.DAY_OF_MONTH)
              val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                  // Display Selected date in TextView
                  tv1.text = "$dayOfMonth  $monthOfYear  $year"

              }, mYear, mMonth, mDay)

                dpd.show()
          }
          R.id.bt2 -> {
              val cal = Calendar.getInstance()
              val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                  // Selected hour and minutes set into the TextView
                  cal.set(Calendar.HOUR_OF_DAY, hour)
                  cal.set(Calendar.MINUTE, minute)
                  tv2.text = SimpleDateFormat("HH:mm").format(cal.time)
              }
              TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

          }
        }
    }
}
