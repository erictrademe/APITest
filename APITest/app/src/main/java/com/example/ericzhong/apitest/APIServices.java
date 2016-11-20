package com.example.ericzhong.apitest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Eric Zhong on 2016/11/20.
 */

public interface APIServices {

    @GET("cities")
    Call<List<CityDto>> getCities();
}
