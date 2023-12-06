package com.example.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fitnesstracker.databinding.ActivitySignUpBinding


class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var db: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MyDatabase(this)

        binding.textView12.setOnClickListener {
            val intent = Intent(this, authentication::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val username = binding.editTextUsernameinput.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Check if username and password are not empty
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Insert the user into the database
                if (db.insertUser(username, password)) {
                    // Signup successful, you can redirect the user to the login page or any other page
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}