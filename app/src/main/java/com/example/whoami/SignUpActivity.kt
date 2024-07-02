package com.example.whoami

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {

    var putName: EditText? = null
    var putId: EditText? = null
    var putPW: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        putName = findViewById<EditText>(R.id.name)
        putId = findViewById<EditText>(R.id.id)
        putPW = findViewById<EditText>(R.id.password)

        //회원가입 완료 버튼 선언하기
        var btn_Signup = findViewById<Button>(R.id.button4)
        btn_Signup.setOnClickListener { onButtonHome() }
    }

    //누르면 조건에 따라 달라지게 , 성공!! 히히
    private fun onButtonHome() {
        val tostrPN = putName?.text.toString()
        val tostrPI = putId?.text.toString()
        val tostrPP = putPW?.text.toString()

        if (tostrPN.isEmpty() or tostrPI.isEmpty() or tostrPP.isEmpty()) {
            Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this, "회원가입 성공!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SignInActivity::class.java)
            intent.putExtra("sendId",tostrPI)
            intent.putExtra("sendPW",tostrPP)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}

