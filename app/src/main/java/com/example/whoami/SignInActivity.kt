package com.example.whoami

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {
    private lateinit var sendId: ActivityResultLauncher<Intent>
    //이것도 순서 따라서 달라지는 걸까...?


//    fun callToId(intent: Intent) {
//        val btn_call = findViewById<Button>(R.id.btn_login)
//        //btn_call.setOnClickListener {
//
//            val strId = id.text.toString()
//            intent.putExtra("Id", strId) //값 전달 시도..
//            //일단 이렇게 해도 되는건지 모르겠지만... 해보기......
//            startActivity(intent)
    //        //}
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var id = findViewById<EditText>(R.id.putid)
        var password = findViewById<EditText>(R.id.putPW)


        val btn_call = findViewById<Button>(R.id.btn_login)
        btn_call.setOnClickListener {
            onButtonsignin(id, password)
        }

        val btn_signup = findViewById<Button>(R.id.button2)
        btn_signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            sendId.launch(intent)
        }

        //런처값 여기 넣어주기

        //이제 새 액티비티에서 데이터 보내기...?

        //sendId : 런처 처리
        sendId = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            //이제 사인인으로 돌아갈 때 결과 값을 받아 올 수 있는 코드
            if (result.resultCode == RESULT_OK) {

                val sendId = result.data?.getStringExtra("sendId") ?: ""
                val sendPW = result.data?.getStringExtra("sendPW") ?: ""

                id.setText(sendId)
                password.setText(sendPW)
            }
        }
    }

    private fun onButtonsignin(id: EditText, password: EditText) {

        //var id = findViewById<EditText>(R.id.putid)
        //var password = findViewById<EditText>(R.id.putPW)

        val toStrid = id.text.toString()
        val toStrPW = password.text.toString()

        if (toStrid.isEmpty() or toStrPW.isEmpty()) {
            Toast.makeText(this, "아이디/비밀번호를 확인해주세요~", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", toStrid)
            startActivity(intent)
            // home으로 이동이 되어야 하는데 이동이 안된다..... 찾아보기... /홈 이동 성공~
            // 이번에는 값 넘기는게 안된다.../어쨌든 성공~~...
            // 오, 앱이 꺼지다. 고양이 켜~
        }
    }
}
//화면 비율이 전체로 들어가도록 변경하기
