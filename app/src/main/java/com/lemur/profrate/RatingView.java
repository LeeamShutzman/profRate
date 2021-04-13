package com.lemur.profrate;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RatingView extends AppCompatActivity {

    TextView className;
    TextView profName;
    TextView classNum;
    TextView classDescription;
    TextView deadlines;
    TextView etr;
    TextView fair;
    TextView group;
    TextView hw;
    TextView online;
    TextView pap;
    TextView pres;
    TextView rat;
    TextView read;
    TextView repeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_view);

        Intent intent = getIntent();
        Ratings rating = intent.getParcelableExtra("rating");

        className = findViewById(R.id.className);
        profName = findViewById(R.id.profName);
        classNum = findViewById(R.id.classNumber);
        classDescription = findViewById(R.id.classDescription);

        deadlines = findViewById(R.id.deadNum);
        etr = findViewById(R.id.etrNum);
        fair = findViewById(R.id.fairNum);
        group = findViewById(R.id.groupNum);
        hw = findViewById(R.id.hwNum);
        online = findViewById(R.id.onlineNum);
        pap = findViewById(R.id.papNum);
        pres = findViewById(R.id.presNum);
        rat = findViewById(R.id.ratingNum);
        read = findViewById(R.id.readNum);
        repeat = findViewById(R.id.repeatY_N);

        className.setText(rating.getClassName());
        profName.setText("Professor Name: " + rating.getProfFirst() + " " + rating.getProfLast());
        classNum.setText(rating.getClassPrefix() + " " + rating.getClassNum() + " " + rating.getSemester() + " " + rating.getYear());
        classDescription.setText("Description: "+  rating.getDescription());

        deadlines.setText(String.valueOf(rating.getDeadlines()));
        etr.setText(String.valueOf(rating.getEtr()));
        fair.setText(String.valueOf(rating.getFair()));
        group.setText(String.valueOf(rating.getGroup()));
        hw.setText(String.valueOf(rating.getHw()));

        if(rating.getOnline())
            online.setText("Online");
        else
            online.setText("In person");

        pap.setText(String.valueOf(rating.getPap()));
        pres.setText(String.valueOf(rating.getPres()));
        rat.setText(String.valueOf(rating.getRating()));

        if(rating.getRepeat())
        {
            repeat.setText("Yes");
            repeat.setTextColor(Color.parseColor("#2E7D32"));
        }
        else
        {
            repeat.setText("No");
           repeat.setTextColor(Color.parseColor("#C62828"));
        }


    }


}
