package com.example.sahar.mmiscreens2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private ArrayList title;
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        title = new ArrayList<>();

        String[] make = getResources().getStringArray(R.array.make);//getting make array from arrays.xml file
        String[] model = getResources().getStringArray(R.array.model);//getting model array from arrays.xml file
        String[] color = getResources().getStringArray(R.array.color);//getting color array from arrays.xml file

        DataModel dataModel= new DataModel();
        dataModel.setTitle("Make"); //setting title as MAKE
        dataModel.setSpinner(make); //setting spinner to String[] make
        title.add(dataModel);//adding data to title Array

        dataModel= new DataModel();
        dataModel.setTitle("Model");//setting title as MODEL
        dataModel.setSpinner(model);//setting spinner to String[] model
        title.add(dataModel);//adding data to title Array

        dataModel= new DataModel();
        dataModel.setTitle("Color");//setting title as COLOR
        dataModel.setSpinner(color);//setting spinner to String[] color
        title.add(dataModel);//adding data to title Array

        dataAdapter = new DataAdapter(this,title); //creating object of the class DataAdapter

        recyclerView.setAdapter(dataAdapter);//setting recyclerView to the dataAdapter
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Your code here for item selected
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}
