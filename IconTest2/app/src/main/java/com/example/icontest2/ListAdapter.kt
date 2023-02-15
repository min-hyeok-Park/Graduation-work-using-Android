package com.example.icontest2

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.icontest2.databinding.ItemListBinding

class ListAdapter(private val lists: List<ListDTO>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    companion object {
        private const val TAG = "TodoAdapter_고기"
    }

    // ViewHolder 생성하는 함수, 최소 생성 횟수만큼만 호출됨 (계속 호출 X)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        Log.d(TAG, "onCreateViewHolder: ")
        val binding =  ItemListBinding.inflate(
            LayoutInflater.from(parent.context), // layoutInflater 를 넘기기위해 함수 사용, ViewGroup 는 View 를 상속하고 View 는 이미 Context 를 가지고 있음
            parent, // 부모(리싸이클러뷰 = 뷰그룹)
            false   // 리싸이클러뷰가 attach 하도록 해야함 (우리가 하면 안됨)
        )
        return ListViewHolder(binding).also { holder ->
            binding.completedCheckBox.setOnCheckedChangeListener { _, isChecked ->
                lists.getOrNull(holder.adapterPosition)?.completed = isChecked
            }
        }
    }

    // 만들어진 ViewHolder에 데이터를 바인딩하는 함수
    // position = 리스트 상에서 몇번째인지 의미
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: $position")
        holder.bind(lists[position])

    }

    override fun getItemCount(): Int = lists.size

    class ListViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val mainActivity = MainActivity.getInstance()

        init {
            binding.listBtn.setOnClickListener {
                mainActivity?.move()
            }
        }

        fun bind(todo: ListDTO) {
            binding.todoTitleText.text = todo.title
            binding.completedCheckBox.isChecked = todo.completed
        }
    }
}