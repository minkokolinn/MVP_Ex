package com.example.user.mvp2.mvp.data.model;

import com.example.user.mvp2.mvp.data.vo.Post;
import com.example.user.mvp2.mvp.presenter.PostPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostModel extends BaseModel{
    private PostModel(){
        super();
    }
    private static PostModel Ins;

    public static PostModel getIns(){
        if (Ins==null){
            Ins=new PostModel();
        }
        return Ins;
    }

    public void getPost(final PostPresenter presenter){
        presenter.displayloadingToView();
        api.getPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                presenter.hideloadingToView();
                if(response.isSuccessful()){
                    presenter.displayPostToView(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                presenter.hideloadingToView();
            }
        });
    }
}
