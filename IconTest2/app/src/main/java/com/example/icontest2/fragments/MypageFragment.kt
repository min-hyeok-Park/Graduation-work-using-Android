package com.example.icontest2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.icontest2.databinding.FragmentHomeBinding
import com.example.icontest2.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {
    private var mbinding : FragmentMypageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMypageBinding.inflate(inflater, container, false)
        mbinding = binding
        return mbinding?.root
    }

    override fun onDestroyView() {
        mbinding = null
        super.onDestroyView()
    }
}