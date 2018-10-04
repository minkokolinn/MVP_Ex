package com.example.user.mvp2.mvp.view;

import com.example.user.mvp2.mvp.data.vo.Post;

import java.util.List;

public interface PostView {
    void diplayPost(List<Post>posts);
    void displayError(String str);
    void displayLoading();
    void hideLoading();
    void displayInternet();
    void displayNoInternet();
}
