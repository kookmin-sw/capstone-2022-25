package com.example.holyseat.scene.write_result_3

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.holyseat.R
import java.text.SimpleDateFormat
import java.util.*

class Write_result_3 : AppCompatActivity() {

    private lateinit var btn_date : Button
    private lateinit var txt_date : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_result3)

        btn_date = findViewById(R.id.calender_button)
        txt_date = findViewById(R.id.calender_text)

        val cal = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            cal.set(Calendar.YEAR,year)
            cal.set(Calendar.MONTH,month)
            cal.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLable(cal)
        }
        btn_date.setOnClickListener{
            DatePickerDialog(this,datePicker, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show()
        }

    }
    private fun updateLable(cal: Calendar){
        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat,Locale.KOREA)
        txt_date.setText(sdf.format(cal.time))
    }
}