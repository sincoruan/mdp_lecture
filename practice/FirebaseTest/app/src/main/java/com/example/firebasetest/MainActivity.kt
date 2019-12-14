package com.example.firebasetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var fireAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register.setOnClickListener{
            var email = emailText.text.toString()
            var pass = passText.toString()

            fireAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this,
                OnCompleteListener<AuthResult>(){
                    task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"register successfully!",Toast.LENGTH_LONG).show()
                        var intent = Intent(this,LoginActivity::class.java)
                        startActivity(intent)

                    }
                    else
                        Toast.makeText(this,"Error: ${task.exception?.message}",Toast.LENGTH_LONG).show()

                } )
        }
        tologin.setOnClickListener{
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
