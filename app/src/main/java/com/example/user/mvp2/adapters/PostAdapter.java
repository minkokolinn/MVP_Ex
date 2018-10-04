package com.example.user.mvp2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.mvp2.R;
import com.example.user.mvp2.mvp.data.vo.Post;

import org.w3c.dom.Text;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder>{
    Context ctxt;
    List<Post> posts;

    public PostAdapter(Context ctxt, List<Post> posts) {
        this.ctxt = ctxt;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(ctxt);
        View v=li.inflate(R.layout.sample_view,parent,false);
        PostHolder ph=new PostHolder(v);
        return ph;
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        Post p=posts.get(position);
        holder.tvTitle.setText(p.getTitle());
        holder.tvContent.setText(p.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvContent;
        public PostHolder(View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tv_title_svp);
            tvContent=itemView.findViewById(R.id.tv_content_svp);
        }
    }
}
