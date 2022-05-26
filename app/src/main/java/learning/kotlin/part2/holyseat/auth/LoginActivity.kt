package learning.kotlin.part2.holyseat.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import learning.kotlin.part2.holyseat.MainActivity
import learning.kotlin.part2.holyseat.R
import learning.kotlin.part2.holyseat.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        binding.loginBtn.setOnClickListener {

            val email = binding.emailArea.text.toString()
            val password = binding.passwordArea.text.toString()


            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val intent = Intent(this, MainActivity::class.java)
                        // 로그인 되면 뒤로가기를 눌러도 다시 회원가입 창이 나오지 않도록 기존 액티비티를 다 날려버리는 작업
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)

                        Toast.makeText(this,"로그인 성공",Toast.LENGTH_LONG).show()

                    } else {
                        Toast.makeText(this,"로그인 실패",Toast.LENGTH_LONG).show()
                    }
                }


        }

    }
}