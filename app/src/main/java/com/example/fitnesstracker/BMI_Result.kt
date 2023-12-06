package com.example.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnesstracker.databinding.ActivityBmiResultBinding

class BMI_Result : AppCompatActivity() {

    private lateinit var binding: ActivityBmiResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBmiResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmi = intent.getStringExtra("bmi")?.slice(0..3)
        binding.BMITextView.text="$bmi"

        val bmiFL = bmi?.toFloat()
        if (bmiFL != null) {
            when {
                bmiFL < 18.5 -> blue()
                bmiFL in 18.5..24.9  -> green()
                bmiFL in 25.0..29.9  -> yellow()
                bmiFL in 30.0..34.9  -> lightOrange()
                bmiFL in 35.0..39.9  -> orange()
                bmiFL > 40 -> red()
            }
        }
        val homeIntent = Intent(this,home::class.java)

        binding.textView20.setOnClickListener {
            startActivity(homeIntent)

        }
    }
    private fun blue(){
        binding.ResultCardView.setCardBackgroundColor(resources.getColor(R.color.blue))
        binding.cardview.setCardBackgroundColor(resources.getColor(R.color.blue))
        binding.BMITextView.setTextColor(resources.getColor(R.color.blue))
        binding.Result.text = "You're UnderWeight"
    }
    private fun green(){
        binding.ResultCardView.setCardBackgroundColor(resources.getColor(R.color.green))
        binding.cardview.setCardBackgroundColor(resources.getColor(R.color.green))
        binding.BMITextView.setTextColor(resources.getColor(R.color.green))
        binding.Result.text = "You're in Healthy weight"
    }
    private fun yellow(){
        binding.ResultCardView.setCardBackgroundColor(resources.getColor(R.color.yellow))
        binding.cardview.setCardBackgroundColor(resources.getColor(R.color.yellow))
        binding.BMITextView.setTextColor(resources.getColor(R.color.yellow))
        binding.Result.text = "You're Overweight"
    }
    private fun lightOrange(){
        binding.ResultCardView.setCardBackgroundColor(resources.getColor(R.color.lightOrange))
        binding.cardview.setCardBackgroundColor(resources.getColor(R.color.lightOrange))
        binding.BMITextView.setTextColor(resources.getColor(R.color.lightOrange))
        binding.Result.text = "You're Obese type I"
    }
    private fun orange(){
        binding.ResultCardView.setCardBackgroundColor(resources.getColor(R.color.orange))
        binding.cardview.setCardBackgroundColor(resources.getColor(R.color.orange))
        binding.BMITextView.setTextColor(resources.getColor(R.color.orange))
        binding.Result.text = "You're Obese type II"
    }
    private fun red(){
        binding.ResultCardView.setCardBackgroundColor(resources.getColor(R.color.red))
        binding.cardview.setCardBackgroundColor(resources.getColor(R.color.red))
        binding.BMITextView.setTextColor(resources.getColor(R.color.red))
        binding.Result.text = "You're Obese type III"
    }
}