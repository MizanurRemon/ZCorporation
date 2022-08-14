package com.example.zcorporation.View.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zcorporation.API.ApiService
import com.example.zcorporation.API.RetrofitHelper
import com.example.zcorporation.Adapter.Movie_adapter
import com.example.zcorporation.Model.Movie_response
import com.example.zcorporation.Utils.Constants
import com.example.zcorporation.databinding.FragmentMoviesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fragment_movies : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    //private lateinit var apiService: ApiService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //return inflater.inflate(R.layout.fragment_movies, container, false)
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        init_view(binding);

        //Toast.makeText(context, Constants().API_KEY, Toast.LENGTH_SHORT).show()
        get_data(Constants().API_KEY)

        return binding.root
    }

    private fun get_data(apiKey: String) {

        val request = RetrofitHelper.buildService(ApiService::class.java)
        val call = request.getMovies(apiKey)

        call.enqueue(object : Callback<Movie_response> {
            override fun onResponse(
                call: Call<Movie_response>,
                response: Response<Movie_response>
            ) {
                if (response.isSuccessful) {
                    binding.itemView.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(activity, 1)
                        adapter = Movie_adapter(response.body()!!.results)
                    }
                }
            }

            override fun onFailure(call: Call<Movie_response>, t: Throwable) {
                //Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("errrorxxx", "${t.message}");
            }
        })

    }

    private fun init_view(binding: FragmentMoviesBinding) {
        //apiService = RetrofitHelper


    }

}