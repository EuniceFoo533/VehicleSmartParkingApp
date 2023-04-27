package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Set the button
        var login :Button = findViewById(R.id.buttonLogin)
        // Set the edit text
        var editEmail :EditText =findViewById(R.id.editTextEmail)
        var editPassword :EditText = findViewById(R.id.editTextPassword)



        // function
        login.setOnClickListener{
            if(editEmail.text.isNullOrBlank() && editPassword.text.isNullOrBlank())
            {
                Toast.makeText(this,"Please fill in the details" , Toast.LENGTH_SHORT).show()
            }

            else
            {
                val email = editEmail.toString();
                val password = editPassword.toString();


            }
        }
    }
}