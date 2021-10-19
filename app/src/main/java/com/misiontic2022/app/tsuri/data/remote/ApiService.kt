package com.misiontic2022.app.tsuri.data.remote;

import com.misiontic2022.app.tsuri.Poi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/diegoprieto-alt/poi-sites/sites")
    fun requestSites(): Call<List<Poi>>
}
