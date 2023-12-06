package com.example.fitnesstracker

import android.os.Bundle
import android.widget.SeekBar
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnesstracker.databinding.ActivityTimerBinding

class Timer : AppCompatActivity() {

    private lateinit var binding: ActivityTimerBinding
    private var countdownTimer: CountDownTimer? = null
    private var isTimerRunning = false
    private var remainingTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val seekBar = binding.seekBar
        val timerTextView = binding.timerTextView
        val imageButton = binding.imageButton3
        val resetButton = binding.imageButton4

        timerTextView.text = "00:00"

        // Set the initial state of the play button
        imageButton.setImageResource(if (seekBar.progress > 0) R.drawable.pause else R.drawable.play)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Update the timerTextView with the current value of the SeekBar
                timerTextView.text = "%02d:%02d".format(progress / 60, progress % 60)

                // Set click listener based on current SeekBar progress
                imageButton.setOnClickListener(getClickListener(progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        imageButton.setOnClickListener {
            if (seekBar.progress > 0) {
                if (!isTimerRunning) {
                    startCountdown(if (remainingTime == 0L) seekBar.progress * 1000L else remainingTime)
                    imageButton.setImageResource(R.drawable.pause)
                } else {
                    stopCountdown()
                    imageButton.setImageResource(R.drawable.play)
                }
            }
            // If SeekBar value is 0, do nothing
        }

        resetButton.setOnClickListener {
            // Reset the countdown to zero
            stopCountdown()
            timerTextView.text = "00:00"
            seekBar.progress = 0
            imageButton.setImageResource(R.drawable.play)
            remainingTime = 0
        }
    }

    private fun getClickListener(progress: Int): android.view.View.OnClickListener? {
        // Return a click listener if progress is greater than 0, otherwise, return null
        return if (progress > 0) {
            android.view.View.OnClickListener {
                if (!isTimerRunning) {
                    startCountdown(if (remainingTime == 0L) progress * 1000L else remainingTime)
                    binding.imageButton3.setImageResource(R.drawable.pause)
                } else {
                    stopCountdown()
                    binding.imageButton3.setImageResource(R.drawable.play)
                }
            }
        } else {
            null
        }
    }

    private fun startCountdown(millisInFuture: Long) {
        countdownTimer = object : CountDownTimer(millisInFuture, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
                val secondsRemaining = millisUntilFinished / 1000
                binding.timerTextView.text = "%02d:%02d".format(
                    secondsRemaining / 60,
                    secondsRemaining % 60
                )
            }

            override fun onFinish() {
                binding.timerTextView.text = "00:00"
                isTimerRunning = false
                binding.imageButton3.setImageResource(R.drawable.play)
                remainingTime = 0
            }
        }

        countdownTimer?.start()
        isTimerRunning = true
    }

    private fun stopCountdown() {
        countdownTimer?.cancel()
        isTimerRunning = false
    }
}