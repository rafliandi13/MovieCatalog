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
import com.example.mybottomnavigation.Adapter.TVShowAdapter;
import com.example.mybottomnavigation.POJO.Movie;
import com.example.mybottomnavigation.POJO.TVShow;
import com.example.mybottomnavigation.R;

import java.util.ArrayList;


public class TVShowFragment extends Fragment {
    private RecyclerView rvTvshow;
    private ArrayList<TVShow> list =new ArrayList<>();
    public TVShowFragment(){

    }
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle){

        View view = layoutInflater.inflate(R.layout.fragment_tvshow,viewGroup,false);
        rvTvshow = view.findViewById(R.id.rv_tvshow);
        list.addAll(getListTVShow());
        rvTvshow.setHasFixedSize(true);
        showRecyclerList();
        return view;
    }
    public void showRecyclerList(){
        rvTvshow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        TVShowAdapter tvShowAdapter = new TVShowAdapter(this.getContext());
        tvShowAdapter.setListTvshow(list);
        rvTvshow.setAdapter(tvShowAdapter);
    }
    public ArrayList<TVShow> getListTVShow(){
        String[] dataName = getResources().getStringArray(R.array.data_title_tvshow);
        String[] dataDescription = getResources().getStringArray(R.array.data_description_tvshow);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_image_tvshow);
        String[] dataGenre = getResources().getStringArray(R.array.data_genre_tbshow);
        String[] dataDuration = getResources().getStringArray(R.array.data_duration_tvshow);
        String[] dataDirector = getResources().getStringArray(R.array.data_director_tvshow);
        ArrayList<TVShow> TvShow = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            TVShow tvShow = new TVShow();
            tvShow.setName(dataName[i]);
            tvShow.setImage(dataPhoto.getResourceId(i,-1));
            tvShow.setDescription(dataDescription[i]);
            tvShow.setGendre(dataGenre[i]);
            tvShow.setDuration(dataDuration[i]);
            tvShow.setDirector(dataDirector[i]);
            TvShow.add(tvShow);
        }
        return TvShow;
    }
}
