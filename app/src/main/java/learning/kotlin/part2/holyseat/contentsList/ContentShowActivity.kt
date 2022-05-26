package learning.kotlin.part2.holyseat.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ProgressBar
import android.widget.Toast
import learning.kotlin.part2.holyseat.R

class ContentShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_show)

        val getUrl = intent.getStringExtra("url",)
//        Toast.makeText(this,"예매 페이지 이동",Toast.LENGTH_LONG).show()

        val webView : WebView = findViewById(R.id.webView)
        webView.loadUrl(getUrl.toString())

    }
}