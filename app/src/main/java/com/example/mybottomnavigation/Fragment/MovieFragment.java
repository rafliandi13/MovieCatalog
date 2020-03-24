package com.example.mybottomnavigation.Fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybottomnavigation.Adapter.MovieAdapter;
import com.example.mybottomnavigation.POJO.Movie;
import com.example.mybottomnavigation.R;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class MovieFragment extends Fragment {
    private RecyclerView rvMovie;
    private ArrayList<Movie> list =new ArrayList<>();
    public MovieFragment(){

    }
    public  View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle){

        View view = layoutInflater.inflate(R.layout.fragment_movie,viewGroup,false);
        rvMovie = view.findViewById(R.id.rv_movie);
        list.addAll(getListMovie());
        rvMovie.setHasFixedSize(true);
        showRecyclerList();
        return view;
    }
    public void showRecyclerList(){
        rvMovie.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(this.getContext());
        movieAdapter.setListMovies(list);
        rvMovie.setAdapter(movieAdapter);
    }

    public ArrayList<Movie> getListMovie(){
        String[] dataName = getResources().getStringArray(R.array.data_title);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_image);
        String[] dataGenre = getResources().getStringArray(R.array.data_genre);
        String[] dataDuration = getResources().getStringArray(R.array.data_duration);
        String[] dataDirector = getResources().getStringArray(R.array.data_director);
        ArrayList<Movie> listmovie = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            Movie movie = new Movie();
            movie.setName(dataName[i]);
            movie.setImage(dataPhoto.getResourceId(i,-1));
            movie.setDescription(dataDescription[i]);
            movie.setGendre(dataGenre[i]);
            movie.setDuration(dataDuration[i]);
            movie.setDirector(dataDirector[i]);
            listmovie.add(movie);
        }
        return listmovie;
    }
}
