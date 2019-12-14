package com.example.finaltest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_share_preference.*

class SharePreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_preference)

        var sharepref = getSharedPreferences("mypre", Context.MODE_PRIVATE)

        store.setOnClickListener {
            var spf = sharepref.edit()
            spf.putString("user",inputuser.text.toString())
            spf.putString("pass",inputpass.text.toString())
            spf.apply()
        }
        display.setOnClickListener {
            disuser.text=sharepref.getString("user","nulll")
            dispass.text=sharepref.getString("pass","nulll")
        }
    }
}
