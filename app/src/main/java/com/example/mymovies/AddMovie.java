package com.example.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMovie extends AppCompatActivity {

    EditText etTitle, etYear, etGenre, etRated, etTheatre, etDescription, etRating, etWatch_on;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        etTitle = findViewById(R.id.editTextAddTitle);
        etYear = findViewById(R.id.editTextAddYear);
        etGenre = findViewById(R.id.editTextAddGenre);
        etRated = findViewById(R.id.editTextAddRated);
        etTheatre = findViewById(R.id.editTextAddTheatre);
        etDescription = findViewById(R.id.editTextAddDescription);
        etRating = findViewById(R.id.editTextRating);
        etWatch_on = findViewById(R.id.editTextWatch_on);
        btnAdd = findViewById(R.id.buttonAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String year = etYear.getText().toString();
                String genre = etGenre.getText().toString();
                String rated = etRated.getText().toString();
                String theatre = etTheatre.getText().toString();
                String description = etDescription.getText().toString();
                String rating = etRating.getText().toString();
                String watch_on = etWatch_on.getText().toString();

                Intent intent = new Intent(AddMovie.this,MainActivity.class);
                intent.putExtra("title1", title);
                intent.putExtra("year1", year);
                intent.putExtra("genre1",genre);
                intent.putExtra("rated1", rated);
                intent.putExtra("theatre1", theatre);
                intent.putExtra("description1", description);
                intent.putExtra("rating1", rating);
                intent.putExtra("watch_on1", watch_on);
                startActivity(intent);
                finish();


            }
        });
    }
}
