package com.example.intentsdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSendMessageExplicit(view: View) {
        var input = smsg.text.toString()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("message",input);
        startActivity(intent);
    }
    fun onSendMessageImplicit(view: View) {
        var input = smsg.text.toString()
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, input)
        startActivity(intent)
    }
    fun whatsapp(view: View) {
        // To open Third Party app Whatsapp directly
        val i = packageManager.getLaunchIntentForPackage("com.whatsapp")
        startActivity(i)
    }
    fun dial(view: View) {
        val i = Intent()
        i.action = Intent.ACTION_DIAL
        val et2 = tel.text.toString()
        i.data = Uri.parse("tel:" + et2)
        startActivity(i)
    }
}
