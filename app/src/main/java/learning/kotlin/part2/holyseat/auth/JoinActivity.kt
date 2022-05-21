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
import learning.kotlin.part2.holyseat.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityJoinBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this,R.layout.activity_join)

        binding.joinBtn.setOnClickListener {

            var isGoToJoin = true // 다 만족하는 플래그 생성

            val email = binding.emailArea.text.toString()
            val password1 = binding.passwordArea1.text.toString()
            val password2 = binding.passwordArea2.text.toString()

            // 해당 값이 비어있는지 확인
            if(email.isEmpty()){
                Toast.makeText(this,"이메일을 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(password1.isEmpty()){
                Toast.makeText(this,"패스워드를 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(password2.isEmpty()){
                Toast.makeText(this,"패스워드를 다시 한번 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            // password1 과 password2 가 같은지 확인
            if(!password1.equals(password2)){
                Toast.makeText(this,"비밀번호를 똑같이 입력해주세요.",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            // 비밀번호가 6자리 이상인지 확인
            if(password1.length < 6){
                Toast.makeText(this,"비밀번호를 6자리 이상으로 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            // 회원가입 조건을 다 만족했다면 가입 실행
            if(isGoToJoin) {

                auth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this,"성공", Toast.LENGTH_LONG).show()

                            val intent = Intent(this,MainActivity::class.java)

                            // 로그인 되면 뒤로가기를 눌러도 다시 회원가입 창이 나오지 않도록 기존 액티비티를 다 날려버리는 작업
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                            startActivity(intent)

                        } else {
                            Toast.makeText(this,"실패",Toast.LENGTH_LONG).show()
                        }
                    }
            }

        }


    }
}