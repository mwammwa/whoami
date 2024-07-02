package com.example.whoami

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    private val imageArray = arrayOf(
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
    )
    //when을 쓰는 방안도 존재, 나중에 끝내고 천천히 확인해보기

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home) //액티비티 매칭
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val strData = intent.getStringExtra("id") //문자열 받기
        val editText = findViewById<TextView>(R.id.outputId) //가면을 벗고 지금 공개합니다!
        editText.text = strData // 여기에다가 텍스트로 이 문자열을 주세요 인 것 같은데...

        val imageView = findViewById<ImageView>(R.id.imageView5)
        setRandomImage(imageView)
    }

    fun onClickednNew(v: View) {
        Toast.makeText(this, "코딩 뉴비를 발견하였습니다!", Toast.LENGTH_SHORT).show()
    }

    fun onClickEnd(v: View) {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
    //종료 확인~

    private fun setRandomImage(imageView: ImageView) {
        val randomIndex = (imageArray.indices).random()
        val randomImageResourceimage = imageArray[randomIndex]
        imageView.setImageResource(randomImageResourceimage)
    }
}

fun main () {
    val a = mutableListOf<String>("사과","배","포도","레몬")

    for (item in a) {
        println("$item")
    }
}

//아이디 불러오기 해결~~~~~~

// 배경 - 말풍선 창과 설명창 분리(일단 말풍선 끝) / 전체적으로 아래로 당기기(나름 완..)