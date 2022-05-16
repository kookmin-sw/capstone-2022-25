package com.example.holyseat.scene.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.TextView
import com.example.holyseat.R
import com.example.holyseat.scene.recentreview.TwelveActivity
import org.koin.android.ext.android.inject
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, TwelveActivity::class.java)
        startActivity(intent)
    }
}