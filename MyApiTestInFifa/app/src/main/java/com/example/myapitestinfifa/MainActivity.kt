package com.example.myapitestinfifa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapitestinfifa.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder().baseUrl("https://api.nexon.co.kr/fifaonline4/v1.0/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(RetrofitService::class.java)

        binding.btn.setOnClickListener {
            val nickname : String = binding.edt.text.toString()

            service.getUserInfo("피파4 토큰 사용할 것","${nickname}")?.enqueue(object : Callback<FifaApi> {
                override fun onResponse(call: Call<FifaApi>, response: Response<FifaApi>) {
                    if(response.isSuccessful){
                        // 정상적으로 통신이 성고된 경우
                        var result: FifaApi? = response.body()
                        Log.d("YMC", "onResponse 성공: " + result?.toString())
                        binding.infoTv.text = result?.toString()
                        binding.ACIDTv.text = result?.accessId
                        binding.levelTv.text = result?.level.toString()
                        binding.nicknameTv.text = result?.nickname
                    }else{
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        binding.infoTv.text = "실패"
                        Log.d("YMC", "onResponse 실패")
                    }
                }

                override fun onFailure(call: Call<FifaApi>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("YMC", "onFailure 에러: " + t.message.toString())
                }
            })
        }



    }
}