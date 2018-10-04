package com.example.user.mvp2.networks;

import com.example.user.mvp2.mvp.data.vo.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts")
    Call<List<Post>> getPost();
}
