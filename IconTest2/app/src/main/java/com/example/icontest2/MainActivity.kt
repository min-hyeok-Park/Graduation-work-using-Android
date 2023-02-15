package com.example.icontest2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.icontest2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    init {
        instance = this
    }
    companion object{
        private var instance: MainActivity? = null
        fun getInstance(): MainActivity?{
            return instance
        }
    }

    private lateinit var binding : ActivityMainBinding

    private val lists = listOf(
        ListDTO("푸드트럭1", false),
        ListDTO("푸드트럭2", false),
        ListDTO("푸드트럭3", false),
        ListDTO("푸드트럭4", false),
        ListDTO("푸드트럭5", false),
        ListDTO("푸드트럭6", false),
        ListDTO("푸드트럭7", false),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainHomeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.mainSearchBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        binding.mainMapBtn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        binding.mainMyPageBtn.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        binding.mainLocationBtn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        binding.parentTv.setOnClickListener {
            if (binding.layoutExpand1.visibility == View.VISIBLE) {
                binding.layoutExpand1.visibility = View.GONE
                binding.parentTv.setImageResource(R.drawable.baseline_expand_more_24)
            } else {
                binding.layoutExpand1.visibility = View.VISIBLE
                binding.parentTv.setImageResource(R.drawable.baseline_expand_less_24)
            }
        }

        initViews()

        // val listBtn = findViewById<Button>(R.id.list_btn)


    }

    private fun initViews() {
        binding.todoList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.todoList.adapter = ListAdapter(lists)
    }

    fun move(){
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
    }
}