package com.lemur.profrate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.lemur.profrate.add.NAME_KEY;
import static com.lemur.profrate.add.NUMBER_KEY;
import static com.lemur.profrate.add.ONLINE_KEY;
import static com.lemur.profrate.add.SEMESTER_KEY;
import static com.lemur.profrate.add.YEAR_KEY;
import static com.lemur.profrate.add3.DEAD_KEY;
import static com.lemur.profrate.add3.ETR_KEY;
import static com.lemur.profrate.add3.FAIR_KEY;
import static com.lemur.profrate.add3.GROUP_KEY;
import static com.lemur.profrate.add3.HW_KEY;
import static com.lemur.profrate.add3.PAP_KEY;
import static com.lemur.profrate.add3.PRES_KEY;
import static com.lemur.profrate.add3.READ_KEY;
import static com.lemur.profrate.add3.REPEAT_KEY;

public class submit extends AppCompatActivity {

    Button back;
    FirebaseDatabase database;
    DatabaseReference ref;
    DatabaseReference amount;
    Ratings newRating;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        back = findViewById(R.id.returnButton);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Ratings");
        amount = database.getReference("amount");
        newRating = new Ratings();


        amount.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                num = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFunction();
            }
        });
    }

    private void getValues()
    {
        Intent intent1 = getIntent();
        String prefix = intent1.getStringExtra(add.PREFIX_KEY);
        int number = intent1.getIntExtra(NUMBER_KEY, 0);
        String name = intent1.getStringExtra(NAME_KEY);
        int year = intent1.getIntExtra(YEAR_KEY, 0);
        String semester = intent1.getStringExtra(SEMESTER_KEY);
        boolean online = intent1.getBooleanExtra(ONLINE_KEY, false);

        String profFirst = intent1.getStringExtra(add.FIRST_KEY);
        String profLast = intent1.getStringExtra(add.LAST_KEY);
        int rating = intent1.getIntExtra(add.RATING_KEY, 0);
        String description = intent1.getStringExtra(add.DESCRIPTION_KEY);

        int fair = intent1.getIntExtra(FAIR_KEY, 0);
        int hw = intent1.getIntExtra(HW_KEY, 0);
        int pres = intent1.getIntExtra(PRES_KEY, 0);
        int pap = intent1.getIntExtra(PAP_KEY, 0);
        int read = intent1.getIntExtra(READ_KEY, 0);
        int group = intent1.getIntExtra(GROUP_KEY, 0);
        int etr = intent1.getIntExtra(ETR_KEY, 0);
        int dead = intent1.getIntExtra(DEAD_KEY, 0);
        boolean repeat = intent1.getBooleanExtra(REPEAT_KEY, false);

        newRating.setClassName(name);
        newRating.setClassNum(number);
        newRating.setClassPrefix(prefix);
        newRating.setDeadlines(dead);
        newRating.setDescription(description);
        newRating.setEtr(etr);
        newRating.setFair(fair);
        newRating.setGroup(group);
        newRating.setHw(hw);
        newRating.setOnline(online);
        newRating.setPap(pap);
        newRating.setPres(pres);
        newRating.setProfFirst(profFirst);
        newRating.setProfLast(profLast);
        newRating.setRating(rating);
        newRating.setRead(read);
        newRating.setRepeat(repeat);
        newRating.setSemester(semester);
        newRating.setYear(year);


    }

    public void submitFunction()
    {
        num++;

        amount.setValue(num);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValues();

                String rateId = ref.push().getKey();
                ref.child(rateId).setValue(newRating);
                Toast.makeText(submit.this, "Rating submitted", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Intent intent = new Intent(this, selection.class);
        startActivity(intent);

    }

}
