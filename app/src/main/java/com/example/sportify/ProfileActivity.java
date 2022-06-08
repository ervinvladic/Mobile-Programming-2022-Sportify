package com.example.sportify;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {
    private TextView nameShow, surnameShow, usernameShow, emailShow;
    private Users user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nameShow = findViewById(R.id.name_show);
        surnameShow = findViewById(R.id.surname_show);
        usernameShow = findViewById(R.id.username_show);
        emailShow = findViewById(R.id.email_show);

        user = (Users) getIntent().getSerializableExtra("Users");
        Bundle extras = getIntent().getExtras();
        if(user != null){
            long id = extras.getLong(MainActivity.EXTRA_TODO_ID);
            Users user = SportifyDatabase.getInstance(this).userDao().getUserById(id);
            nameShow.setText(user.getName());
            surnameShow.setText(user.getSurname());
            usernameShow.setText(user.getUsername());
            emailShow.setText(user.getEmail());
        }
    }
    }



