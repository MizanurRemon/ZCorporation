package com.example.zcorporation.View.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zcorporation.R
import com.example.zcorporation.databinding.ActivityMainBinding
import com.example.zcorporation.databinding.ActivityMainBinding.inflate
import com.example.zcorporation.databinding.FragmentMoviesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_movies.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_movies : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //return inflater.inflate(R.layout.fragment_movies, container, false)
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        return binding.root
    }

}