package com.lemur.profrate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class add extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        next = findViewById(R.id.button);

        final String[] array_sem = new String[]{"Fall", "Spring", "Summer", "Fall 1", "Fall 2", "Spring 1", "Spring 2", "Semester Taken"};

        Spinner spin = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter_sem = new ArrayAdapter<String>(this.getApplicationContext(), R.layout.spnr_layout, array_sem)
        {
            @Override
            public int getCount()
            {

                return array_sem.length-1;
            }

        };

        adapter_sem.setDropDownViewResource(R.layout.spnr_drop_layout);
        spin.setAdapter(adapter_sem);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                if (position == array_sem.length-1) {
                    ((TextView) view).setTextColor(Color.GRAY);
                }
                else {
                    ((TextView) view).setTextColor(Color.BLACK);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }

        });

        spin.setSelection(array_sem.length-1);

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openNextScreen();
            }

        });

    }

    public void openNextScreen()
    {
        EditText pref = findViewById(R.id.prefix);
        String prefix = pref.getText().toString();
        EditText num = findViewById(R.id.number);

        EditText nam = findViewById(R.id.name);
        String name = nam.getText().toString();
        EditText yr = findViewById(R.id.year);

        Spinner spin = findViewById(R.id.spinner);
        String semi = spin.getSelectedItem().toString();


        Switch switch1 = findViewById(R.id.switch1);
        boolean online = switch1.isChecked();

        if(pref.length() == 0 || num.length() == 0 || nam.length() == 0 || yr.length() == 0 ||
           semi == "Semester Taken")
        {
            Toast.makeText(add.this, "Enter a value for all fields", Toast.LENGTH_LONG).show();
        }
        else
        {

            int number = Integer.parseInt(num.getText().toString());
            int year = Integer.parseInt(yr.getText().toString());

            Intent nextPage = new Intent(this, add2.class);

            nextPage.putExtra(PREFIX_KEY, prefix);
            nextPage.putExtra(NUMBER_KEY, number);
            nextPage.putExtra(NAME_KEY, name);
            nextPage.putExtra(YEAR_KEY, year);
            nextPage.putExtra(SEMESTER_KEY, semi);
            nextPage.putExtra(ONLINE_KEY, online);

            startActivity(nextPage);
        }

    }

}
