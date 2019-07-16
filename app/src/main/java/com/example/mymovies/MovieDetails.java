package com.example.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    ImageView ivMovie;
    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvDescription;
    TextView tvWatched_on;
    TextView tvTheatre;
    RatingBar rbRating;
    Button btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);


        ivMovie = findViewById(R.id.imageViewMovie);
        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        tvGenre = findViewById(R.id.textViewGenre);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatched_on = findViewById(R.id.textViewWatch_on);
        tvTheatre = findViewById(R.id.textViewTheatre);
        rbRating = findViewById(R.id.ratingBar);
        btnDelete = findViewById(R.id.buttonDelete);

        Intent intentReceived = getIntent();
        final String title = intentReceived.getStringExtra("title");
        Log.i("title",title);
        String year = intentReceived.getStringExtra("year");
        String genre = intentReceived.getStringExtra("genre");
        String rated = intentReceived.getStringExtra("rated");
        String description = intentReceived.getStringExtra("description");
        String watched_on = intentReceived.getStringExtra("watched_on");
        String theatre = intentReceived.getStringExtra("theatre");
        int rating = intentReceived.getIntExtra("rating",0);

        tvTitle.setText(title);
        tvYear.setText(year);
        tvGenre.setText(genre);
        tvDescription.setText(description);
        tvWatched_on.setText("Watch on: " + watched_on);
        tvTheatre.setText("In theatre:" + theatre);

        if (rated.equals("g")){
            ivMovie.setImageResource(R.drawable.rating_g);
        }
        else if(rated.equals("pg")){
            ivMovie.setImageResource(R.drawable.rating_pg);
        }
        else if(rated.equals("pg13")){
            ivMovie.setImageResource(R.drawable.rating_pg13);
        }
        else if(rated.equals("nc16")){
            ivMovie.setImageResource(R.drawable.rating_nc16);
        }
        else if(rated.equals("m18")){
            ivMovie.setImageResource(R.drawable.rating_m18);
        }
        else {
            ivMovie.setImageResource(R.drawable.rating_r21);
        }

        rbRating.setRating(rating);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetails.this,MainActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

    }

}
