package com.example.holyseat.scene.recentreview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.holyseat.R
import com.bumptech.glide.Glide

class RecentReviewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecentReviewAdapter.ViewHolder>() {
    var datas = mutableListOf<RecentReviewData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recent_review, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imgUserImg: ImageView = itemView.findViewById(R.id.user_img)
        private val txtUserName: TextView = itemView.findViewById(R.id.user_name)
        private val txtSeatInfo: TextView = itemView.findViewById(R.id.seat_info)
        private val txtUserReview: TextView = itemView.findViewById(R.id.user_review)
        private val imgPosterImg: ImageView = itemView.findViewById(R.id.poster_img)

        fun bind(item: RecentReviewData) {

            txtUserName.text = item.userName
            txtSeatInfo.text = item.seatInfo
            txtUserReview.text = item.reviewContent
            Glide.with(itemView).load(item.userImg).into(imgUserImg)
            Glide.with(itemView).load(item.posterImg).into(imgPosterImg)

        }
    }


}
