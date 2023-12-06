package com.example.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fitnesstracker.databinding.ActivityAuthenticationBinding

class authentication : AppCompatActivity() {

    private lateinit var binding: ActivityAuthenticationBinding
    private lateinit var db: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val intent = Intent(this,home::class.java)

        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MyDatabase(this)

        binding.textView12.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val username = binding.editTextUsernameinput.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()){
                if (db.authenticateUser(username, password)) {
                    // Authentication successful, start the home activity
                    val intent = Intent(this, home::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Authentication failed, show a message to the user
                    Toast.makeText(this, "User_Name or Password is incorrect !", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Please enter all fields !", Toast.LENGTH_SHORT).show()
            }


        }
    }
}









