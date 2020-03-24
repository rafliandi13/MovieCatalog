package com.example.mybottomnavigation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mybottomnavigation.Detail.MovieDetail;
import com.example.mybottomnavigation.Fragment.MovieFragment;
import com.example.mybottomnavigation.POJO.Movie;
import com.example.mybottomnavigation.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder>{
    private ArrayList<Movie> listMovies;
    private Context context;
    public ArrayList<Movie> getListMovies() {
        return listMovies;
    }
    public void setListMovies(ArrayList<Movie> listMovies) {
        this.listMovies = listMovies;
    }
    public MovieAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
            Movie movie = listMovies.get(position);

            Glide.with(holder.itemView.getContext())
                .load(movie.getImage())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.image);
        holder.tvTitle.setText(movie.getName());
        holder.tvDescription.setText(movie.getDescription());
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }



    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView image;
            TextView tvTitle,tvDescription;
            public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_movie);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_des);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Movie movie = getListMovies().get(position);
            movie.setName(movie.getName());
            Intent moveWithObjectIntent = new Intent(view.getContext(), MovieDetail.class);
            moveWithObjectIntent.putExtra(MovieDetail.EXTRA_MOVIE, movie);
            context.startActivity(moveWithObjectIntent);
        }
    }
}
