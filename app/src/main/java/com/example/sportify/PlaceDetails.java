package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class PlaceDetails extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    private TextView description;
    private TextView price;
    private TextView court;
    private TextView date;
    private TextView time;
    private Button resButton;
    private TextView location;
    private String name;
    private String str;
    int hour1,minute1;
    private static final String CHANNEL_ID ="channel" ;
    DatePickerDialog.OnDateSetListener setListener;
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
        resButton=findViewById(R.id.button2);
        location = findViewById(R.id.see_location);
        Bundle extras = getIntent().getExtras();
        name=extras.getString(HomeActivity.EXTRA_TITLE);
        str=extras.getString("user");
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel(CHANNEL_ID,"notification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        resButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaceDetails.this, HomeActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(PlaceDetails.this);
                stackBuilder.addNextIntentWithParentStack(intent);
                PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(PlaceDetails.this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.logocourt)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                if(date.getText().toString().isEmpty() || time.getText().toString().isEmpty()){
                    builder.setContentTitle("Reservation failed!");
                    builder.setContentText("Your court reservation was not completed. Please select valid date and time and try again!");
                }else{
                    builder.setContentTitle(name);
                    builder.setContentText("Your court reservation was successful. Enjoy your game!");
                }
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(PlaceDetails.this);
                managerCompat.notify(0,builder.build());
                intent.putExtra("user",str);
                startActivity(intent);


            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(PlaceDetails.this, R.style.TimePicker,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {
                        hour1 = hour;
                        minute1 = minute;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,hour1,minute1);
                        time.setText(DateFormat.format( "hh:mm aa",calendar));

                    }
                },12,0,false
                );
                timePickerDialog.updateTime(hour1,minute1);
                timePickerDialog.show();
            }
        });


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(PlaceDetails.this, R.style.DatePicker,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date1 = day+"/"+month+"/"+year;
                        date.setText(date1);
                    }
                },year,month,day);
                datePickerDialog.show();
            }

        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });


        if(extras != null){
            setTitle(extras.getString(HomeActivity.EXTRA_TITLE));
            imageView.setImageResource(extras.getInt(HomeActivity.EXTRA_IMAGE));
            title.setText(extras.getString(HomeActivity.EXTRA_TITLE));
            description.setText(extras.getString(HomeActivity.EXTRA_DESCRIPTION));
            price.setText(extras.getString(HomeActivity.EXTRA_PRICE));
        }
    }

}