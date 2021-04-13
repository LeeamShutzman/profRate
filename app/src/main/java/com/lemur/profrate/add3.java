package com.lemur.profrate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.lemur.profrate.add.NAME_KEY;
import static com.lemur.profrate.add.NUMBER_KEY;
import static com.lemur.profrate.add.ONLINE_KEY;
import static com.lemur.profrate.add.SEMESTER_KEY;
import static com.lemur.profrate.add.YEAR_KEY;
import static com.lemur.profrate.add2.DESCRIPTION_KEY;
import static com.lemur.profrate.add2.FIRST_KEY;
import static com.lemur.profrate.add2.LAST_KEY;
import static com.lemur.profrate.add2.PREFIX_KEY;
import static com.lemur.profrate.add2.RATING_KEY;

public class add3 extends AppCompatActivity {

    Button submit;

    public static final String FAIR_KEY = "com.lemur.profrate.FAIR_KEY";
    public static final String HW_KEY = "com.lemur.profrate.HW_KEY";
    public static final String PRES_KEY = "com.lemur.profrate.PRES_KEY";
    public static final String PAP_KEY = "com.lemur.profrate.PAP_KEY";
    public static final String READ_KEY = "com.lemur.profrate.READ_KEY";
    public static final String GROUP_KEY = "com.lemur.profrate.GROUP_KEY";
    public static final String ETR_KEY = "com.lemur.profrate.ETR_KEY";
    public static final String DEAD_KEY = "com.lemur.profrate.DEAD_KEY";
    public static final String REPEAT_KEY = "com.lemur.profrate.REPEAT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add3);

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubmit();
            }
        });
    }

    public void openSubmit()
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

        EditText fairg = findViewById(R.id.fairEntry);
        EditText Ahw = findViewById(R.id.hwEntry);
        EditText Apres = findViewById(R.id.presEntry);
        EditText Apap = findViewById(R.id.paperEntry);
        EditText Aread = findViewById(R.id.readingEntry);
        EditText Agroup = findViewById(R.id.teamEntry);
        EditText ietr = findViewById(R.id.etrEntry);
        EditText idead = findViewById(R.id.deadEntry);
        CheckBox wrepeat = findViewById(R.id.checkBox);

        if(fairg.length() == 0 || Ahw.length() == 0 || Apres.length() == 0 || Apap.length() == 0 ||
            Aread.length() == 0 || Agroup.length() == 0 || ietr.length() == 0 || idead.length() == 0)
            Toast.makeText(add3.this, "Enter a value for all fields", Toast.LENGTH_LONG).show();
        else {
            int fair = Integer.parseInt(fairg.getText().toString());
            int hw = Integer.parseInt(Ahw.getText().toString());
            int pres = Integer.parseInt(Apres.getText().toString());
            int pap = Integer.parseInt(Apap.getText().toString());
            int read = Integer.parseInt(Aread.getText().toString());
            int group = Integer.parseInt(Agroup.getText().toString());
            int etr = Integer.parseInt(ietr.getText().toString());
            int dead = Integer.parseInt(idead.getText().toString());
            boolean repeat = wrepeat.isChecked();

            if ((fair >= 11) || (fair <= 0) ||
                    (hw >= 11) || (hw <= 0) ||
                    (pres >= 11) || (pres <= 0) ||
                    (pap >= 11) || (pap <= 0) ||
                    (read >= 11) || (read <= 0) ||
                    (group >= 11) || (group <= 0) ||
                    (etr >= 11) || (etr <= 0) ||
                    (dead >= 11) || (dead <= 0))
                Toast.makeText(add3.this, "All numbers must be between 1 and 10", Toast.LENGTH_LONG).show();
            else {
                Intent submit = new Intent(this, submit.class);

                submit.putExtra(PREFIX_KEY, prefix);
                submit.putExtra(NUMBER_KEY, number);
                submit.putExtra(NAME_KEY, name);
                submit.putExtra(YEAR_KEY, year);
                submit.putExtra(SEMESTER_KEY, semester);
                submit.putExtra(ONLINE_KEY, online);

                submit.putExtra(FIRST_KEY, profFirst);
                submit.putExtra(LAST_KEY, profLast);
                submit.putExtra(RATING_KEY, rating);
                submit.putExtra(DESCRIPTION_KEY, description);

                submit.putExtra(FAIR_KEY, fair);
                submit.putExtra(HW_KEY, hw);
                submit.putExtra(PRES_KEY, pres);
                submit.putExtra(PAP_KEY, pap);
                submit.putExtra(READ_KEY, read);
                submit.putExtra(GROUP_KEY, group);
                submit.putExtra(ETR_KEY, etr);
                submit.putExtra(DEAD_KEY, dead);
                submit.putExtra(REPEAT_KEY, repeat);

                startActivity(submit);
            }
        }

    }
}
