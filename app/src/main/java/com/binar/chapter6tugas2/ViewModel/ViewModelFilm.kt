package com.binar.chapter6tugas2.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.chapter6tugas2.Model.GetAllFilmResponseItem
import com.binar.chapter6tugas2.Network.APIClient
import retrofit2.Call
import retrofit2.Response

class ViewModelFilm : ViewModel() {

    lateinit var liveDataFilm : MutableLiveData<List<GetAllFilmResponseItem>>

    init {
        liveDataFilm = MutableLiveData()
    }

    fun getLiveFilmObserver() : MutableLiveData<List<GetAllFilmResponseItem>> {
        return liveDataFilm
    }
    fun makeApiFilm(){
        APIClient.instance.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<GetAllFilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataFilm.postValue(response.body())
                    }else{
                        liveDataFilm.postValue(null)
                    }

                }

                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    liveDataFilm.postValue(null)


                }

            })
    }



}