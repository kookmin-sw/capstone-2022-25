package com.example.holyseat.scene.useralarm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.holyseat.R

class UserAlarmActivity : AppCompatActivity() {
    private lateinit var alarmView: RecyclerView
    private lateinit var alarmList: ArrayList<UserAlarm>
    private lateinit var alarmAdapter: UserAlarmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_alarm)
        alarmView = findViewById(R.id.re)
        alarmView.setHasFixedSize(true)
        alarmView.layoutManager = GridLayoutManager(this, 1)

        alarmList = ArrayList()
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))
        alarmList.add(UserAlarm(R.drawable.heart,"choison","님이 회원님의 글을 좋아합니다.",R.drawable.almond))


        alarmAdapter = UserAlarmAdapter(alarmList)
        alarmView.adapter = alarmAdapter
    }

}