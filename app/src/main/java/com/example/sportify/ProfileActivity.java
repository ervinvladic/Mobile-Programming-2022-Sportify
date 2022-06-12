package com.example.sportify;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity {
    private Users user;
    private EditText name;
    private EditText surname;
    private EditText username;
    private EditText password;
    private EditText email;
    private String oldstr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        name = findViewById(R.id.name_input_profile);
        surname = findViewById(R.id.surname_input_profile);
        username = findViewById(R.id.username_input_profile);
        password = findViewById(R.id.password_input_profile);
        email = findViewById(R.id.email_input_profile);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            String str = extras.getString("user");
            user = SportifyDatabase.getInstance(this).userDao().loginUser(str);

            name.setText(user.getName());
            surname.setText(user.getSurname());
            username.setText(user.getUsername());
            password.setText(user.getPassword());
            email.setText(user.getEmail());
            oldstr = username.getText().toString();
        }
    }
    public void onSave(View view){
        try {
            user.setName(name.getText().toString());
            user.setSurname(surname.getText().toString());
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            user.setEmail(email.getText().toString());
            SportifyDatabase.getInstance(this).userDao().updateUser(user);
            if(password.getText().toString().trim().length()<6) {
                Toast.makeText(getApplicationContext(), "Password needs to have at least 6 characters!", Toast.LENGTH_SHORT).show();
            }else{

            Toast.makeText(this, "User information updated!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("user", username.getText().toString());
            startActivity(intent);
            }

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Username or email is already in use!", Toast.LENGTH_LONG).show();
        }

    }
    public void onCancel(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("user",oldstr);
        startActivity(intent);
    }

}
