package com.example.movieapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

public class ActivityDetails extends AppCompatActivity {

    public static final String TAG = "DetailsActivity";
    public List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        getIncomingIntent();

        String mName = getIntent().getStringExtra("name");
        setTitle(mName);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

       }

    private void getIncomingIntent() {
        if   (getIntent().hasExtra("name") && getIntent().hasExtra("director") && getIntent().hasExtra("img") &&
                getIntent().hasExtra("description") );
        {
            String mName = getIntent().getStringExtra("name");
            String mDirector = getIntent().getStringExtra("director");
            String mImage = getIntent().getStringExtra("img");
            String mDescription = getIntent().getStringExtra("description");

            setImage(mName, mDirector, mImage, mDescription);
        }
    }

    private void  setImage(String mName, String mDirector, String mImage, String mDescription){

        ImageView imgDetails = findViewById(R.id.details_img);
        Glide.with(this)
                .asBitmap()
                .load(mImage)
                .into(imgDetails);
        TextView nameDetails = findViewById(R.id.details_name);
        nameDetails.setText(mName);
        TextView directorDetails = findViewById(R.id.details_director);
        directorDetails.setText(mDirector);
        TextView descriptionDetails = findViewById(R.id.details_description);
        descriptionDetails.setText(mDescription);
    }
}

