package com.felipe.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
    }

    private void init() {
        this.listView = findViewById(R.id.listViewId);

        populateListView();
    }

    private void populateListView() {
        List<String> stringList = generateRandomStringArrayList(25);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                stringList
        );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        listView.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<String> generateRandomStringArrayList(int size) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789 ";
        List<String> randomStrings = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String randomText = "";

            for (int j = 0; j < new Random().nextInt(characters.length()); j++) {
                randomText += characters.charAt(new Random().nextInt(characters.length()));
            }

            randomStrings.add(randomText);
        }

        return randomStrings;
    }

}
