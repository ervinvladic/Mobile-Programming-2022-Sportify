package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText Username, Password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        setContentView(R.layout.activity_login);
        Username = findViewById(R.id.username_login);
        Password = findViewById(R.id.password_login);
        login= findViewById(R.id.login_button);
    }
    public void onregister(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void login(View view){
        try {
            Users user = SportifyDatabase.getInstance(this).sportifyDao().loginUser(Username.getText().toString());
            if(user.getPassword().equals(Password.getText().toString())){
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("user", Username.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid password!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "This user doesn't exist!", Toast.LENGTH_SHORT).show();
        }
    }


}