package com.example.zcorporation.API

import com.example.zcorporation.Model.Movie_response
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("discover/movie")
    fun getMovies(@Query("api_key") api_key: String): Call<Movie_response>



}