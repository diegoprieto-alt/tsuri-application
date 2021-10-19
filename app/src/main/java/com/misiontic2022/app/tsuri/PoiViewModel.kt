package com.misiontic2022.app.tsuri

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misiontic2022.app.tsuri.data.remote.RetrofitFactory
import com.misiontic2022.app.tsuri.Poi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PoiViewModel : ViewModel(){
    private var apiService = RetrofitFactory.apiService()
    private var pois = MutableLiveData<List<Poi>>()
    var poisLiveData: LiveData<List<Poi>> = pois

    init{
        getPois()
    }
    fun getPois() {
        val call = apiService.requestSites()
        call.enqueue(object : Callback<List<Poi>?> {
            override fun onResponse(call: Call<List<Poi>?>, response: Response<List<Poi>?>) {
                pois.value = response.body()
            }

            override fun onFailure(call: Call<List<Poi>?>, t: Throwable) {
                // todo deal with the failed network request
            }
        })
    }

    fun deletePois() {
        pois.value = emptyList()
    }
}


