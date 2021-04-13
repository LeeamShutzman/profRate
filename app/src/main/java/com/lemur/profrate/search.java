package com.lemur.profrate;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class search extends AppCompatActivity implements ratingAdapter.OnItemClickListener{

    private SearchView search_View;
    private RecyclerView recycler_View;
    ArrayList<Ratings> myRatings;
    DatabaseReference ratingsDatabase;
    ArrayList<Ratings> ratings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ratingsDatabase = FirebaseDatabase.getInstance().getReference("Ratings");
        search_View = findViewById(R.id.searchView);
        recycler_View = findViewById(R.id.recyclerView);

        recycler_View.setHasFixedSize(true);
        recycler_View.setLayoutManager(new LinearLayoutManager(this));

        if(ratingsDatabase != null)
        {
            ratingsDatabase.addValueEventListener(new ValueEventListener()
            {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                {

                    if(dataSnapshot.exists())
                    {
                        ratings = new ArrayList<>();

                        for(DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            ratings.add(ds.getValue(Ratings.class));
                        }

                        ratingAdapter adapter = new ratingAdapter(ratings, search.this);

                        recycler_View.setAdapter(adapter);

                        myRatings = ratings;
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError)
                {
                    Toast.makeText(search.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }

            });

        }

    }

    @Override
    protected void onStart()
    {
        super.onStart();

        if(search_View != null)
        {
            search_View.setOnQueryTextListener(new SearchView.OnQueryTextListener()
            {
                @Override
                public boolean onQueryTextSubmit(String query)
                {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText)
                {
                    fireBaseSearch(newText);
                    return true;
                }

            });

        }

        search_View.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                search_View.setIconified(false);
            }

        });

    }

    private void fireBaseSearch(String str)
    {
        myRatings = new ArrayList<>();
        for(Ratings object : ratings)
        {

            if((object.getProfFirst().toLowerCase() + " " + object.getProfLast().toLowerCase()).contains(str.toLowerCase()) ||
                object.getClassName().toLowerCase().contains(str.toLowerCase()) ||
               (object.getClassPrefix() + " " + object.getClassNum()).toLowerCase().contains(str.toLowerCase()))
            {
                myRatings.add(object);
            }

        }

        ratingAdapter adapter = new ratingAdapter(myRatings, this);

        recycler_View.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position)
    {
        Intent intent = new Intent(this, RatingView.class);

        intent.putExtra("rating", myRatings.get(position));
        startActivity(intent);
    }

}


