package com.example.savestatedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var mTextViewCount: TextView? = null
    private var mCount: Int = 0
    lateinit var buttonDecrement: Button
    lateinit var buttonIncrement: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextViewCount = findViewById(R.id.text_view_count)
        buttonDecrement = findViewById(R.id.button_decrement)
        buttonIncrement = findViewById(R.id.button_increment)
        buttonDecrement.setOnClickListener{  decrement()}
        buttonIncrement.setOnClickListener{increment()}

        // You can Restore the state value either onCreate() or override onRestoreInstanceState(Bundle mySavedState) after onStart()
      /*  if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count")
            mTextViewCount?.text = mCount.toString()
        }*/
    }

    private fun increment() {
        mCount++;
        mTextViewCount?.text  = mCount.toString()
    }

    private fun decrement() {
        mCount--;
        mTextViewCount?.text  = mCount.toString()
    }
   override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count")
            mTextViewCount?.text = mCount.toString()
            Toast.makeText(this,"OnReStoreInstanceState:"+"\n"+"mCount = " + mCount,Toast.LENGTH_LONG ).show()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", mCount)
        Toast.makeText(this,"onSaveInstanceState:"+"\n"+"mCount = " + mCount,Toast.LENGTH_LONG ).show()
    }
}
