package com.example.mybottomnavigation.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybottomnavigation.POJO.Movie;
import com.example.mybottomnavigation.R;

public class MovieDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tv_title,sinposis,tv_duration,tv_director,tv_genre;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        tv_title = findViewById(R.id.tv_title_detail);
        sinposis = findViewById(R.id.tv_sinopsis);
        imageView = findViewById(R.id.iv_detail);
        tv_genre = findViewById(R.id.tv_genre);
        tv_duration = findViewById(R.id.tv_duration);
        tv_director = findViewById(R.id.tv_director);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tv_title.setText(movie.getName());
        sinposis.setText(movie.getDescription());
        imageView.setImageResource(movie.getImage());
        tv_genre.setText(movie.getGendre());
        tv_duration.setText(movie.getDuration());
        tv_director.setText(movie.getDirector());
    }
}
