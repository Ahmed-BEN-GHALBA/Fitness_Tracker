package com.example.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnesstracker.databinding.ActivitySwBinding

class SW : AppCompatActivity() {

    private lateinit var binding: ActivitySwBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this,home::class.java)

        binding = ActivitySwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView13.setOnClickListener {
            startActivity(intent)
        }
    }
}