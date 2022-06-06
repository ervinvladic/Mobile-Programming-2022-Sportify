package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetails extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    private TextView description;
    private TextView price;
    private TextView court;
    private EditText date;
    private EditText time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        imageView = findViewById(R.id.place_image);
        title = findViewById(R.id.place_title);
        description = findViewById(R.id.place_description);
        price=findViewById(R.id.place_price);
        court = findViewById(R.id.place_title);
        date=findViewById(R.id.date_input);
        time=findViewById(R.id.time_input);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            setTitle(extras.getString(HomeActivity.EXTRA_TITLE));
            imageView.setImageResource(extras.getInt(HomeActivity.EXTRA_IMAGE));
            title.setText(extras.getString(HomeActivity.EXTRA_TITLE));
            description.setText(extras.getString(HomeActivity.EXTRA_DESCRIPTION));
            price.setText(extras.getString(HomeActivity.EXTRA_PRICE));
        }
    }

}