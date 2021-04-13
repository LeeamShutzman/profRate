package com.lemur.profrate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class selection extends AppCompatActivity {

    Button addRate;
    Button search;
    Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        addRate = findViewById(R.id.addRate);
        search = findViewById(R.id.search);
        logOut = findViewById(R.id.logOut);

        addRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdd();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearch();
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLogOut();
            }
        });

    }

    public void openAdd()
    {
        Intent intent = new Intent(this, add.class);
        startActivity(intent);
    }

    public void openSearch()
    {
        Intent intent = new Intent(this, search.class);
        startActivity(intent);
    }

    public void iLogOut()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onBackPressed()
    {
        Toast.makeText(selection.this, "Can't go back", Toast.LENGTH_LONG).show();
    }
}
