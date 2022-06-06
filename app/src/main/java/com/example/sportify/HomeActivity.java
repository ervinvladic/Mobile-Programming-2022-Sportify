package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE = "EXTRA_IMAGE";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION";
    public static final String EXTRA_PRICE = "EXTRA_PRICE";
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        listView = findViewById(R.id.list_view_container);
        PlacesAdapter placesAdapter = new PlacesAdapter(getPlaces(),this);
        listView.setAdapter(placesAdapter);
        listView.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Place place = (Place) parent.getItemAtPosition(position);
            Intent intent = new Intent(HomeActivity.this,PlaceDetails.class);
            intent.putExtra(EXTRA_IMAGE,place.getImageResId());
            intent.putExtra(EXTRA_TITLE, place.getTitle());
            intent.putExtra(EXTRA_DESCRIPTION, place.getDescription());
            intent.putExtra(EXTRA_PRICE, place.getPrice());
            startActivity(intent);
        }
    };


    private List<Place> getPlaces(){
        List<Place> placesList=new ArrayList<>();
        placesList.add(new Place(1,R.drawable.fudbal,"Bentbasa","Football fields","20€"));
        placesList.add(new Place(2,R.drawable.tenis,"Una","Tennis courts","25€"));
        placesList.add(new Place(3,R.drawable.teren,"Vistafon","Football fields","20€"));
        return placesList;
    }
    public void onlogout(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}

