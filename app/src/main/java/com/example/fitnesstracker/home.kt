package com.example.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnesstracker.databinding.ActivityHomeBinding

class home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intentBMI = Intent(this,BMI::class.java)
        val intentTimer = Intent(this,Timer::class.java)
        val intentWorkout = Intent(this,Workout::class.java)
        val intentSettings = Intent(this,Settings::class.java)
        val intentFood = Intent(this,Food::class.java)
        val intentSW = Intent(this,SW::class.java)
        val intentauthentication = Intent(this,authentication::class.java)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logout.setOnClickListener {
            //startActivity(intentauthentication)
            logout()
        }
        binding.imageView4.setOnClickListener {
            startActivity(intentBMI)
        }
        binding.imageView5.setOnClickListener {
            startActivity(intentFood)
        }
        binding.imageView6.setOnClickListener {
            startActivity(intentWorkout)
        }
        binding.imageView7.setOnClickListener {
            startActivity(intentSW)
        }
        binding.imageView8.setOnClickListener {
            startActivity(intentTimer)
        }
        binding.imageView10.setOnClickListener {
            startActivity(intentSettings)
        }
    }
    private fun logout() {
        // Add any necessary logout logic here

        // For example, if you want to go back to the login screen:
        val intent = Intent(this, authentication::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}