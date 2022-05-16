package com.example.holyseat.scene.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.holyseat.R
import com.example.holyseat.scene.useralarm.UserAlarmActivity
import com.example.holyseat.scene.write_result_1.Write_result_1
import com.example.holyseat.scene.write_result_3.Write_result_3
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, Write_result_3::class.java)
        startActivity(intent)
    }
}