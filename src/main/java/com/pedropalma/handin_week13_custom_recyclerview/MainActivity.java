package com.pedropalma.handin_week13_custom_recyclerview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ArrayList notes = new ArrayList<>();

    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call method to populate list
        populateList();
        //call method to set recycler view properties
        buildRecyclerView();
        //handle Floating action button
        FloatingActionButton fab = findViewById(R.id.btnAddNote);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailsActivity.class));
                finish();
            }
        });
    }

    //populate list with dummy data
    public void populateList(){
        notes = new ArrayList<>();

        notes.add(new Note("","Title1", "Description1"));
        notes.add(new Note("","Title2", "Description2"));
        notes.add(new Note("","Title3", "Description3"));
        notes.add(new Note("","Title4", "Description4"));
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new NoteAdapter(notes);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position) {
                //when clicked it will start a new activity to update notes
                   // addNote(position);
            }
            @Override
            public void onDeleteClick(int position) {
                //when delete icon is clicked it will remove note item
                notes.remove(position);
                adapter.notifyItemRemoved(position);

            }
        });
    }

    //add new note to list

    }

