package com.example.mybottomnavigation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mybottomnavigation.Detail.MovieDetail;
import com.example.mybottomnavigation.Detail.TVShowDetail;
import com.example.mybottomnavigation.POJO.Movie;
import com.example.mybottomnavigation.POJO.TVShow;
import com.example.mybottomnavigation.R;

import java.util.ArrayList;


public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.ListViewHolder> {
    private ArrayList<TVShow> listTvshow;
    private Context context;
    public ArrayList<TVShow> getListTvshow() {
        return listTvshow;
    }

    public void setListTvshow(ArrayList<TVShow> listTvshow) {
        this.listTvshow = listTvshow;
    }
    public TVShowAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tvshow,parent,false);
        return new TVShowAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        TVShow tvShow = listTvshow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getImage())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.image);
        holder.tvTitle.setText(tvShow.getName());
        holder.tvDescription.setText(tvShow.getDescription());
    }

    @Override
    public int getItemCount() {
        return listTvshow.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView image;
        TextView tvTitle,tvDescription;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_tvshow);
            tvTitle = itemView.findViewById(R.id.tv_title_tvshow);
            tvDescription = itemView.findViewById(R.id.tv_des_tvshow);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            TVShow tvShow = getListTvshow().get(position);

            tvShow.setName(tvShow.getName());

            Intent moveWithObjectIntent = new Intent(view.getContext(), TVShowDetail.class);
            moveWithObjectIntent.putExtra(TVShowDetail.EXTRA_MOVIE, tvShow);
            context.startActivity(moveWithObjectIntent);
        }
    }
}
