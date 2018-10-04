package com.example.user.mvp2.mvp.presenter;

import android.content.Context;

import com.example.user.mvp2.mvp.data.model.PostModel;
import com.example.user.mvp2.mvp.data.vo.Post;
import com.example.user.mvp2.mvp.view.PostView;
import com.example.user.mvp2.utils.AppUtils;

import java.util.List;

public class PostPresenterImpl implements PostPresenter{
    PostView pv;
    Context ctxt;

    public PostPresenterImpl(PostView pv,Context ctxt) {
        this.pv = pv;
        this.ctxt=ctxt;
    }

    @Override
    public void displayPostToView(List<Post> posts) {
        pv.diplayPost(posts);
    }

    @Override
    public void displayErroToView(String str) {
        pv.displayError(str);
    }

    @Override
    public void onload() {
        if(AppUtils.isInternet(ctxt)){
            pv.displayInternet();
            PostModel.getIns().getPost(this);
        }else {
            pv.displayNoInternet();
        }


    }

    @Override
    public void displayloadingToView() {
        pv.displayLoading();
    }

    @Override
    public void hideloadingToView() {
        pv.hideLoading();
    }
}
