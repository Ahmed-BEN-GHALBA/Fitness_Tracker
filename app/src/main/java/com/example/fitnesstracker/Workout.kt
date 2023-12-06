package com.example.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnesstracker.databinding.ActivityWorkoutBinding

class Workout : AppCompatActivity() {

    private lateinit var binding: ActivityWorkoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this,home::class.java)

        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView13.setOnClickListener {
            startActivity(intent)
        }
    }
}