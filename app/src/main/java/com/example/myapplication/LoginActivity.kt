package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the edit text
        var editEmail = binding.editTextEmail.text.toString()
        var editPassword = binding.editTextPassword.text.toString()


        // function
        binding.buttonLogin.setOnClickListener{
            if(editEmail.isEmpty() && editPassword.isEmpty())
            {
                Toast.makeText(this,"Please fill in the details" , Toast.LENGTH_SHORT).show()
            }

            else
            {
                val email = editEmail.toString();
                val password = editPassword.toString();

            }
        }

        binding.textViewToSignUp.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }


    }
}