package com.example.holyseat.scene.searchresult

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.holyseat.R

class SearchResultAdapter(private val musicalList:ArrayList<SearchResult>)
    :RecyclerView.Adapter<SearchResultAdapter.MusicalViewHolder>(){

    class MusicalViewHolder(musicalView: View) : RecyclerView.ViewHolder(musicalView) {
        val theater = musicalView.findViewById<TextView>(R.id.theater)
        val date = musicalView.findViewById<TextView>(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicalViewHolder {
        val musical_view = LayoutInflater.from(parent.context).inflate(R.layout.searchresult_recyclerview, parent, false)
        return MusicalViewHolder(musical_view)
    }

    override fun onBindViewHolder(holder: MusicalViewHolder, position: Int) {
        val musical = musicalList[position]
        holder.theater.text = musical.theater
        holder.date.text = musical.date
    }

    override fun getItemCount(): Int {
        return musicalList.size
    }
}