package learning.kotlin.part2.holyseat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import learning.kotlin.part2.holyseat.auth.IntroActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 4초 후에 Splash 화면에서 IntroActivity로 전환
        Handler().postDelayed({
            startActivity(Intent(this, IntroActivity::class.java))
            finish()
        },2000)
    }
}