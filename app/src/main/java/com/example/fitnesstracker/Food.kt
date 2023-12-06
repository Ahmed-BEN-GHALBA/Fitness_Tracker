package com.example.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnesstracker.databinding.ActivityFoodBinding

class Food : AppCompatActivity() {

    private lateinit var binding: ActivityFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this,home::class.java)

        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView13.setOnClickListener {
            startActivity(intent)
        }
    }
}