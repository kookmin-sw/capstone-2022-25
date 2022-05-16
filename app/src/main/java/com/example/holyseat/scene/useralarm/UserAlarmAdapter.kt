package com.example.holyseat.scene.useralarm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.holyseat.R


class UserAlarmAdapter(private val alarmList:ArrayList<UserAlarm>)
    :RecyclerView.Adapter<UserAlarmAdapter.AlarmViewHolder>(){

    class AlarmViewHolder(alarmView: View) : RecyclerView.ViewHolder(alarmView) {
        val icon: ImageView = alarmView.findViewById(R.id.icon)
        val name: TextView = alarmView.findViewById(R.id.name)
        val textalarm: TextView = alarmView.findViewById(R.id.text_alarm)
        val poster: ImageView = alarmView.findViewById(R.id.poster)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val alarm_View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return AlarmViewHolder(alarm_View)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        val alarm = alarmList[position]
        holder.name.text = alarm.name
        holder.textalarm.text = alarm.text_alarm
        holder.icon.setImageResource(alarm.icon)
        holder.poster.setImageResource(alarm.poster)
    }

    override fun getItemCount(): Int {
        return alarmList.size
    }
}