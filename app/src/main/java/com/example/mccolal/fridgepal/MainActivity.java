package com.example.mccolal.fridgepal;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView simpleGrid;
    Button addEntry;
    Button viewEntry;
    EditText entryName;

    List<String> animalList = new ArrayList<String>();
    ArrayList<String> results = new ArrayList<String>();
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        simpleGrid = (GridView) findViewById(R.id.simpleGridView);
        addEntry = (Button) findViewById(R.id.addEntry);
        viewEntry = (Button) findViewById(R.id.viewEntry);
        entryName = (EditText) findViewById(R.id.entryAddition);

        addEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAddName(v);
            }
        });

        viewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRetrieveStudents(v);
            }
        });







        customAdapter = new CustomAdapter(getApplicationContext(), results);
        simpleGrid.setAdapter(customAdapter);







    }


    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(ContentProv.NAME, ((EditText) findViewById(R.id.entryAddition)).getText().toString());


        Uri uri = getContentResolver().insert(
                ContentProv.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        results.clear();
        String URL = "content://com.example.mccolal.fridgepal.ContentProv";

        Uri fridges = Uri.parse(URL);
        Cursor c = managedQuery(fridges, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                results.add(c.getString(c.getColumnIndex( ContentProv.NAME)));
                //Toast.makeText(this,c.getString(c.getColumnIndex(ContentProv._ID)) + ", " +  c.getString(c.getColumnIndex( ContentProv.NAME)),Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
        customAdapter.notifyDataSetChanged();
    }

}
