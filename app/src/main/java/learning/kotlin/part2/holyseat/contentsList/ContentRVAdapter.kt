package learning.kotlin.part2.holyseat.contentsList

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import learning.kotlin.part2.holyseat.R
import learning.kotlin.part2.holyseat.utils.FBAuth
import learning.kotlin.part2.holyseat.utils.FBRef

class ContentRVAdapter(val context : Context,
                       val items : ArrayList<ContentModel>,
                       val keyList : ArrayList<String>,
                       val bookmarkIdList : MutableList<String>)
    : RecyclerView.Adapter<ContentRVAdapter.Viewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item,parent,false)


        return Viewholder(v)
    }

    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {
        holder.bindItems(items[position], keyList[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: ContentModel,key:String) {

            itemView.setOnClickListener{
                Toast.makeText(context,item.title, Toast.LENGTH_LONG).show()
                val intent = Intent(context,ContentShowActivity::class.java)
                intent.putExtra("url",item.webUrl)
                itemView.context.startActivity(intent)
            }

            val contentTitle : TextView =  itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea : ImageView = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)

            // 북마크를 가지고 있다면,
            if(bookmarkIdList.contains(key)){
                bookmarkArea.setImageResource(R.drawable.bookmark_color)
            }
            // 북마크를 가지고 있지 않다면,
            else{
                bookmarkArea.setImageResource(R.drawable.bookmark)
            }

            bookmarkArea.setOnClickListener {
                Log.d("ContentRVAdapter", FBAuth.getUid())
//                Toast.makeText(context, key, Toast.LENGTH_LONG).show()


                if(bookmarkIdList.contains(key)){
                    // 북마크가 있을 때 삭제
                        // bookmarkIdList.remove(key)

                    FBRef.bookmarkRef
                        .child(FBAuth.getUid())
                        .child(key)
                        .removeValue()
                }
                else{
                    //북마크가 없을 때
                    FBRef.bookmarkRef
                        .child(FBAuth.getUid())
                        .child(key)
                        .setValue(BookmarkModel(true))


                }


            }


            contentTitle.text = item.title
            Glide.with(context).load(item.imageUrl).into(imageViewArea)
        }

    }


}

