package com.example.mybottomnavigation.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybottomnavigation.POJO.TVShow;
import com.example.mybottomnavigation.R;

public class TVShowDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tv_title,sinposis,tv_duration,tv_director,tv_genre;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);
        tv_title = findViewById(R.id.tv_title_detail_tvshow);
        sinposis = findViewById(R.id.tv_sinopsis);
        imageView = findViewById(R.id.iv_detail_tvshow);
        tv_genre = findViewById(R.id.tv_genre_tvshow);
        tv_duration = findViewById(R.id.tv_duration_tvshow);
        tv_director = findViewById(R.id.tv_director_tvshow);

        TVShow tvShow = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tv_title.setText(tvShow.getName());
        sinposis.setText(tvShow.getDescription());
        imageView.setImageResource(tvShow.getImage());
        tv_genre.setText(tvShow.getGendre());
        tv_duration.setText(tvShow.getDuration());
        tv_director.setText(tvShow.getDirector());
    }
}
