package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var login :Button = findViewById(R.id.button)

        var editEmail :EditText =findViewById(R.id.editEmail)
        var editPassword :EditText = findViewById(R.id.editPassword)

        login.setOnClickListener{
            if(editEmail.text.isNullOrBlank() && editPassword.text.isNullOrBlank())
            {
                Toast.makeText(this,"Please fill in the details" , Toast.LENGTH_SHORT).show()
            }

            else
            {
             Toast.makeText(this,"${editEmail.text} is login", Toast.LENGTH_SHORT).show()
            }
        }
    }
}