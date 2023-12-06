package com.example.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fitnesstracker.databinding.ActivityBmiBinding

class BMI : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, BMI_Result::class.java)

        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.MetricRadioButton.setOnClickListener {
            binding.HeightInput.hint = "Enter Your Height in Centimeters !"
            binding.WeightInput.hint = "Enter Your Weight in Kilograms !"
        }

        binding.ImperialRadioButton.setOnClickListener {
            binding.HeightInput.hint = "Enter Your Height in Inches !"
            binding.WeightInput.hint = "Enter Your Weight in Pounds !"
        }

        binding.CalculateButton.setOnClickListener {
            val heightInput = binding.HeightInput.text.toString()
            val weightInput = binding.WeightInput.text.toString()

            if ((heightInput.isNotEmpty() && weightInput.isNotEmpty()) && (metricIsCheked() || imperialIsCheked())) {
                var height = (heightInput?.toFloat())!!
                val weight = (weightInput?.toFloat())!!

                if ((height > 0) && (weight > 0)) {
                    if (metricIsCheked()) {
                        if ((height < 280) && (weight < 500)) {
                            height /= 100
                            val bmi = weight!! / (height?.times(height))!!
                            intent.putExtra("bmi", bmi.toString())
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this,
                                "Enter a valid value !                                  < 500 kg And < 280 cm",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else if (imperialIsCheked()) {
                        if ((height < 100) && (weight < 1100)) {
                            val bmi = (weight!! / (height?.times(height))!!) * 703
                            intent.putExtra("bmi", bmi.toString())
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this,
                                "Enter a valid value !                                  < 1100 lbs And < 100 in",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Please enter  values greater than 0 ! ",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "Please fill in all the fields And Choose a measurement system ! ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }


    private fun metricIsCheked(): Boolean {
        return binding.MetricRadioButton.isChecked
    }

    private fun imperialIsCheked(): Boolean {
        return binding.ImperialRadioButton.isChecked
    }

}