package com.example.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovie;
    CustomAdapter caMovie;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovie);
        alMovie = new ArrayList<>();



        Movie item1 = new Movie("The Avengers", "2012", "pg13", "Action | Sci-Fi", stringToCalendar("15/11/2014"),"Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army",4);
        Movie item2 = new Movie("Planes", "2013", "pg", "Animation | Comedy",  stringToCalendar("15/5/2015"),"Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",2);

        alMovie.add(item1);
        alMovie.add(item2);

        caMovie = new CustomAdapter(this, R.layout.row, alMovie);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                for (int i = 0; i<alMovie.size(); i++) {
                    if (position == i) {
                        intent.putExtra("title", alMovie.get(i).getTitle());
                        intent.putExtra("year", alMovie.get(i).getYear());
                        intent.putExtra("rated", alMovie.get(i).getRated());
                        intent.putExtra("genre", alMovie.get(i).getGenre());
                        intent.putExtra("watched_on", alMovie.get(i).calendarToString());
                        intent.putExtra("theatre", alMovie.get(i).getIn_theatre());
                        intent.putExtra("description", alMovie.get(i).getDescription());
                        intent.putExtra("rating",alMovie.get(i).getRating());

                    }
                }
                startActivity(intent);

            }
        });

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        for(int i = 0; i<alMovie.size();i++) {
            if (alMovie.get(i).getTitle().equals(title))
                alMovie.remove(i);
        }

        String title1 = intentReceived.getStringExtra("title1");
        String year1 = intentReceived.getStringExtra("year1");
        String genre1 = intentReceived.getStringExtra("genre1");
        String rating1 = intentReceived.getStringExtra("rating1");
        String rated1 = intentReceived.getStringExtra("rated1");
        String theatre1 = intentReceived.getStringExtra("theatre1");
        String description1 = intentReceived.getStringExtra("description1");
        String watch_on1 = intentReceived.getStringExtra("watch_on1");

        if(rating1!=null){
            int rating2 = Integer.valueOf(rating1);
            Movie item3 = new Movie(title1, year1, rated1, genre1,stringToCalendar(watch_on1), theatre1, description1,rating2);
            alMovie.add(item3);
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.Add) {
            Intent intent = new Intent(MainActivity.this,AddMovie.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Calendar stringToCalendar(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;

        try {
            date = formatter.parse(strDate);
        }catch (Exception e){

        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal;
    }

}

