package com.example.user.mvp2.mvp.presenter;

import com.example.user.mvp2.mvp.data.vo.Post;

import java.util.List;

public interface PostPresenter {
    void displayPostToView(List<Post>posts);
    void displayErroToView(String str);
    void onload();
    void displayloadingToView();
    void hideloadingToView();
}
