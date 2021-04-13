package com.lemur.profrate;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class add2 extends AppCompatActivity {

    public static final String PREFIX_KEY = "com.lemur.profrate.PREFIX_KEY";
    public static final String NUMBER_KEY = "com.lemur.profrate.NUMBER_KEY";
    public static final String NAME_KEY = "com.lemur.profrate.NAME_KEY";
    public static final String YEAR_KEY = "com.lemur.profrate.YEAR_KEY";
    public static final String SEMESTER_KEY = "com.lemur.profrate.SEMESTER_KEY";
    public static final String ONLINE_KEY = "com.lemur.profrate.ONLINE_KEY";

    public static final String FIRST_KEY = "com.lemur.profrate.FIRST_KEY";
    public static final String LAST_KEY = "com.lemur.profrate.LAST_KEY";
    public static final String RATING_KEY = "com.lemur.profrate.RATING_KEY";
    public static final String DESCRIPTION_KEY = "com.lemur.profrate.DESCRIPTION_KEY";

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextScreen();
            }
        });


    }

    public void openNextScreen() {

        Intent intent = getIntent();
        String prefix = intent.getStringExtra(add.PREFIX_KEY);
        int number = intent.getIntExtra(add.NUMBER_KEY, 0);
        String name = intent.getStringExtra(add.NAME_KEY);
        int year = intent.getIntExtra(add.YEAR_KEY, 0);
        String semester = intent.getStringExtra(add.SEMESTER_KEY);
        boolean online = intent.getBooleanExtra(add.ONLINE_KEY, false);
        EditText firstName = findViewById(R.id.profFirst);
        String first = firstName.getText().toString();
        EditText lastName = findViewById(R.id.profLast);
        String last = lastName.getText().toString();
        EditText genScore = findViewById(R.id.rating);
        EditText explanation = findViewById(R.id.des);
        String description = explanation.getText().toString();

        if(firstName.length() == 0 || lastName.length() == 0 || genScore.length() == 0 || explanation.length() == 0)
            Toast.makeText(add2.this, "Enter a value for all fields", Toast.LENGTH_LONG).show();
        else {

            int rating = Integer.parseInt(genScore.getText().toString());
            Intent nextPage = new Intent(this, add3.class);

            nextPage.putExtra(PREFIX_KEY, prefix);
            nextPage.putExtra(NUMBER_KEY, number);
            nextPage.putExtra(NAME_KEY, name);
            nextPage.putExtra(YEAR_KEY, year);
            nextPage.putExtra(SEMESTER_KEY, semester);
            nextPage.putExtra(ONLINE_KEY, online);

            nextPage.putExtra(FIRST_KEY, first);
            nextPage.putExtra(LAST_KEY, last);
            nextPage.putExtra(RATING_KEY, rating);
            nextPage.putExtra(DESCRIPTION_KEY, description);

            startActivity(nextPage);
        }
    }
    

}
