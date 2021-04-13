package com.lemur.profrate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button enter;
    EditText password;
    String passwordAttempt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = findViewById(R.id.code);
        enter = findViewById(R.id.enter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //password test
                passwordAttempt = password.getText().toString();
                if(passwordAttempt.equals("cool")) {
                    openNextScreen();
                }
            }
        });



    }
    public void openNextScreen()
    {
        Intent nextPage = new Intent(this, selection.class);
        startActivity(nextPage);
    }

    public void onBackPressed()
    {
        Toast.makeText(MainActivity.this, "Can't go back", Toast.LENGTH_LONG).show();
    }
}
