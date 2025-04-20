package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityFullScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class FullScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(6000)
            startActivity(Intent(this@FullScreenActivity, MainActivity::class.java))
            finish()
        }


    }


}