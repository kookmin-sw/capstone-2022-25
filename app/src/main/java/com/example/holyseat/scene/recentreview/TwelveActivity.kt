package com.example.holyseat.scene.recentreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.holyseat.R
import com.example.holyseat.databinding.ActivityTwelveBinding

class TwelveActivity : AppCompatActivity() {
    lateinit var recentreviewAdapter: RecentReviewAdapter
    val datas = mutableListOf<RecentReviewData>()
    private lateinit var binding: ActivityTwelveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwelveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
    }
    private fun initRecycler() {
        recentreviewAdapter = RecentReviewAdapter(this)
        binding.recentReviewList.adapter = recentreviewAdapter



        datas.apply {
            add(RecentReviewData(userImg = R.drawable.holyseatlogo, userName = "choisony", seatInfo = "1층 A구역 1열 B석",reviewContent="재미있었습니다! 너무 좋았어요!",posterImg=R.drawable.poster1))
            add(RecentReviewData(userImg = R.drawable.holyseatlogo, userName = "xyz-r", seatInfo = "1층 A구역 1열 B석",reviewContent="재미있었습니다! 너무 좋았어요!",posterImg=R.drawable.poster2))
            add(RecentReviewData(userImg = R.drawable.holyseatlogo, userName = "nakwon", seatInfo = "1층 A구역 1열 B석",reviewContent="재미있었습니다! 너무 좋았어요!",posterImg=R.drawable.poster3))
            add(RecentReviewData(userImg = R.drawable.holyseatlogo, userName = "letzgorats", seatInfo = "1층 A구역 1열 B석",reviewContent="재미있었습니다! 너무 좋았어요!",posterImg=R.drawable.poster4))
            add(RecentReviewData(userImg = R.drawable.holyseatlogo, userName = "python", seatInfo = "1층 A구역 1열 B석",reviewContent="재미있었습니다! 너무 좋았어요!",posterImg=R.drawable.poster1))
            add(RecentReviewData(userImg = R.drawable.holyseatlogo, userName = "python", seatInfo = "1층 A구역 1열 B석",reviewContent="재미있었습니다! 너무 좋았어요!",posterImg=R.drawable.poster1))
            add(RecentReviewData(userImg = R.drawable.holyseatlogo, userName = "python", seatInfo = "1층 A구역 1열 B석",reviewContent="재미있었습니다! 너무 좋았어요!",posterImg=R.drawable.poster1))
            add(RecentReviewData(userImg = R.drawable.holyseatlogo, userName = "python", seatInfo = "1층 A구역 1열 B석",reviewContent="재미있었습니다! 너무 좋았어요!",posterImg=R.drawable.poster1))

            recentreviewAdapter.datas = datas
            recentreviewAdapter.notifyDataSetChanged()

        }
    }
}