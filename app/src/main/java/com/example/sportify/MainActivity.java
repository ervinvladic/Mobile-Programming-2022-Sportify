package com.example.sportify;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        private EditText nameInput, surnameInput, usernameInput, passwordInput, emailInput;
        private Button registerButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.action_bar_layout_register);
            nameInput = findViewById(R.id.name_input);
            surnameInput = findViewById(R.id.surname_input);
            usernameInput = findViewById(R.id.username_input);
            passwordInput = findViewById(R.id.password_input);
            emailInput = findViewById(R.id.email_input);
            registerButton = findViewById(R.id.register_button);

            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Users user = new Users();
                    user.setName(nameInput.getText().toString());
                    user.setSurname(surnameInput.getText().toString());
                    user.setUsername(usernameInput.getText().toString());
                    user.setPassword(passwordInput.getText().toString());
                    user.setEmail(emailInput.getText().toString());
                    try{
                    if (validateInput(user)) {
                        if(passwordInput.getText().toString().trim().length()<6){
                            Toast.makeText(getApplicationContext(), "Password needs to have at least 6 characters!", Toast.LENGTH_SHORT).show();
                        }else{
                            SportifyDatabase sportifyDatabase = SportifyDatabase.getInstance(getApplicationContext());
                            UserDao userDao = sportifyDatabase.userDao();
                            userDao.addUser(user);

                            Toast.makeText(getApplicationContext(), "User registered!", Toast.LENGTH_SHORT).show();
                            openhomeactivity();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Username is already in use!", Toast.LENGTH_LONG).show();
                }

                }


            });

        }

        private boolean validateInput(Users user) {
            if (user.getName().isEmpty() || user.getSurname().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
                return false;
            }
            return true;
        }
    public void onhaveaccount(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void openhomeactivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("user", usernameInput.getText().toString());
        startActivity(intent);
    }
    }
