package com.example.user.mvp2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.user.mvp2.adapters.PostAdapter;
import com.example.user.mvp2.mvp.data.vo.Post;
import com.example.user.mvp2.mvp.presenter.PostPresenter;
import com.example.user.mvp2.mvp.presenter.PostPresenterImpl;
import com.example.user.mvp2.mvp.view.PostView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PostView {
    RecyclerView rv;
    ProgressDialog pd;
    PostPresenter pp;
    LinearLayout llNoInternet;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv_post_am);
        llNoInternet=findViewById(R.id.ll_noInternet);
        btn=findViewById(R.id.btn_retry_am);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        pd=new ProgressDialog(this);
        pd.setTitle("Loading....");
        pp=new PostPresenterImpl(this,this);
        pp.onload();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pp.onload();
            }
        });
    }

    @Override
    public void diplayPost(List<Post> posts) {
        PostAdapter adapter=new PostAdapter(MainActivity.this,posts);
        rv.setAdapter(adapter);
    }

    @Override
    public void displayError(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        if(pd.isShowing()){
            pd.dismiss();
        }
    }

    @Override
    public void displayInternet() {
        llNoInternet.setVisibility(View.GONE);
        rv.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayNoInternet() {
        llNoInternet.setVisibility(View.VISIBLE);
        rv.setVisibility(View.GONE);
    }
}
