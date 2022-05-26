package learning.kotlin.part2.holyseat.contentsList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import learning.kotlin.part2.holyseat.R
import learning.kotlin.part2.holyseat.utils.FBAuth
import learning.kotlin.part2.holyseat.utils.FBRef

class ContentsListActivity : AppCompatActivity() {

    lateinit var myRef : DatabaseReference

    val bookmarkIdList = mutableListOf<String>()

    lateinit var rvAdapter : ContentRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_list)

        val items = ArrayList<ContentModel>()
        val itemKeyList = ArrayList<String>()
        rvAdapter = ContentRVAdapter(baseContext, items, itemKeyList, bookmarkIdList)

        // Write a message to the database
        val database = Firebase.database

        val category = intent.getStringExtra("category")


        if(category == "category1"){
            myRef = database.getReference("contents")

        }else if (category == "category2"){
            myRef = database.getReference("contents2")
        }

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for(dataModel in dataSnapshot.children){
                    Log.d("ContentListActivity",dataModel.toString())
                    Log.d("ContentListActivity",dataModel.key.toString())
                    val item = dataModel.getValue(ContentModel::class.java)
                    items.add(item!!)
                    itemKeyList.add(dataModel.key.toString())
                }
                rvAdapter.notifyDataSetChanged() // 어댑터를 새롭게 refresh(동기화)

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentsListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)


        val rv : RecyclerView = findViewById(R.id.rv)


        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(this,2)


        getBookmarkData()


    }
    private fun getBookmarkData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                // 누적되는 북마크를 방지하기 위해 초기화
                bookmarkIdList.clear()

                for(dataModel in dataSnapshot.children){
                    bookmarkIdList.add(dataModel.key.toString())
                }
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.bookmarkRef.child(FBAuth.getUid()).addValueEventListener(postListener)

    }

}