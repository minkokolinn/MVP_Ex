package com.example.user.mvp2.mvp.data.model;

import com.example.user.mvp2.networks.ApiService;
import com.example.user.mvp2.utils.AppConstant;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseModel {
    protected ApiService api;

    BaseModel(){
        initializedApi();
    }

    private void initializedApi(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api=retrofit.create(ApiService.class);
    }
}
