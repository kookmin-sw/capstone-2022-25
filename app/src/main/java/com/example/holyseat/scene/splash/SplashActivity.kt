package com.example.holyseat.scene.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.holyseat.R
import com.example.holyseat.scene.main.MainActivity
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lifecycleScope.launchWhenStarted {
            delay(1500)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}