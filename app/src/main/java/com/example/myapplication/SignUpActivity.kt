package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonSignUp.setOnClickListener{
            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val confirmPass = binding.editTextConfirmPassword.text.toString()

            if(name.isEmpty() && email.isEmpty() && password.isEmpty() && confirmPass.isEmpty())
            {
                Toast.makeText(this,"Every field is required",Toast.LENGTH_SHORT).show()
            }

            else if(name.isEmpty())
            {
                Toast.makeText(this,"Name is required.",Toast.LENGTH_SHORT).show()
            }

            else if(email.isEmpty())
            {
                Toast.makeText(this,"Email is required.",Toast.LENGTH_SHORT).show()
            }

            else if(password.isEmpty())
            {
                Toast.makeText(this,"Password is required.", Toast.LENGTH_SHORT).show()
            }

            else if(confirmPass.isEmpty())
            {
                Toast.makeText(this,"Confirm Password is required.",Toast.LENGTH_SHORT).show()
            }

            else if(password.length < 8)
            {
                Toast.makeText(this,"Password should at least 8 characters.",Toast.LENGTH_SHORT).show()
            }

            else
            {
                if(password != confirmPass)
                {
                    Toast.makeText(this,"Password is not matching.",Toast.LENGTH_SHORT).show()
                }

                else
                {
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    if(it.isSuccessful)
                    {
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }

                    else
                    {
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                    }
                }
                }
            }

        }

        binding.textViewToLogin.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}