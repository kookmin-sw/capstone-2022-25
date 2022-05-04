package com.example.holyseat.scene.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.TextView
import com.example.holyseat.R
import org.koin.android.ext.android.inject
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.title).text = "hello__@@"
        findViewById<TextView>(R.id.title).text = "hello__####"
    }
}