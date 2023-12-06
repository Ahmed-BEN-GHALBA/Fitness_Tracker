package com.example.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fitnesstracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, authentication::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            try {
                startActivity(intent)
            } catch (e: android.content.ActivityNotFoundException) {
                Toast.makeText(this, "Activity not found", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show()
            }
        }

    }
}