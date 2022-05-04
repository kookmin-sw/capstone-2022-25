package com.example.holyseat.scene.searchresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.holyseat.R

class SearchResultActivity : AppCompatActivity() {

    private lateinit var musicalView: RecyclerView
    private lateinit var musicalList: ArrayList<SearchResult>
    private lateinit var musicalAdapter: SearchResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchresult_main)
        musicalView = findViewById(R.id.musical_content)
        musicalView.setHasFixedSize(true)
        musicalView.layoutManager = GridLayoutManager(this, 2)

        musicalList = ArrayList()
        musicalList.add(SearchResult("샤 롯데 시어터", "2018.11.13 ~ 2019.05.19"))
        musicalList.add(SearchResult("샤 롯데 시어터", "2018.11.13 ~ 2019.05.19"))
        musicalList.add(SearchResult("샤 롯데 시어터", "2018.11.13 ~ 2019.05.19"))
        musicalList.add(SearchResult("샤 롯데 시어터", "2018.11.13 ~ 2019.05.19"))
        musicalList.add(SearchResult("샤 롯데 시어터", "2018.11.13 ~ 2019.05.19"))
        musicalList.add(SearchResult("샤 롯데 시어터", "2018.11.13 ~ 2019.05.19"))
        musicalList.add(SearchResult("샤 롯데 시어터", "2018.11.13 ~ 2019.05.19"))
        musicalList.add(SearchResult("샤 롯데 시어터", "2018.11.13 ~ 2019.05.19"))

        musicalAdapter = SearchResultAdapter(musicalList)
        musicalView.adapter = musicalAdapter

    }
}