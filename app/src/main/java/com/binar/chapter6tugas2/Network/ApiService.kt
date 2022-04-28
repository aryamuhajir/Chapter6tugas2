package com.binar.chapter6tugas2.Network

import com.binar.chapter6tugas2.Model.GetAllFilmResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("apifilm.php")
    fun getAllFilm(): Call<List<GetAllFilmResponseItem>>

}