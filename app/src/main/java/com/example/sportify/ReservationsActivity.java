package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ReservationsActivity extends AppCompatActivity {

    private ListView listView;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        listView = findViewById(R.id.reservations_container);

        str = getIntent().getStringExtra("user");
        setUpAdapter();
    }
    public void setUpAdapter(){
        List<Reservation> resList = SportifyDatabase.getInstance(this).reservationDao().getAllByUsername(str);
        ReservationsAdapter reservationsAdapter = new ReservationsAdapter(resList,this);
        listView.setAdapter(reservationsAdapter);
    }
}