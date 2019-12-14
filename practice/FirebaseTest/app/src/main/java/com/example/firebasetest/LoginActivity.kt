package com.example.firebasetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    var fireAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener{
            var email = username.text.toString()
            var pass = password.text.toString()

            fireAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(OnCompleteListener {
                task ->
                if(task.isSuccessful)
                    Toast.makeText(this,"login successfully!",Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this,"Error: ${task.exception?.message}",Toast.LENGTH_LONG).show()
            })
        }
        toregister.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }


}
