package learning.kotlin.part2.holyseat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import learning.kotlin.part2.holyseat.auth.IntroActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        if(auth.currentUser?.uid == null){
            Handler().postDelayed({
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            },2000)
        }

        else{
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },2000)
        }

    }



        // 2초 후에 Splash 화면에서 IntroActivity로 전환

}