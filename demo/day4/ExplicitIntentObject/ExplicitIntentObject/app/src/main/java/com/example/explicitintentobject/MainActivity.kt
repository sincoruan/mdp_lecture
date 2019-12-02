package com.example.explicitintentobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun submit(view: View) {
        var fn = fname.text
        var ln = lname.text
        var mail = email.text
      //  Toast.makeText(this,mail.toString(),Toast.LENGTH_LONG).show()
        val account = UserAccount(fn.toString(), ln.toString(), mail.toString())
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra("user", account)
        startActivity(intent)
    }
}
