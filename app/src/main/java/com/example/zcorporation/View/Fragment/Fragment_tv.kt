package com.example.zcorporation.View.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zcorporation.R
import com.example.zcorporation.databinding.FragmentMoviesBinding
import com.example.zcorporation.databinding.FragmentTvBinding


class Fragment_tv : Fragment() {

    private lateinit var binding: FragmentTvBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvBinding.inflate(inflater, container, false)

        return binding.root
    }


}