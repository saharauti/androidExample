package com.example.sahar.mmiscreenprofiledetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SwitchCompat switch_btn;
    private ArrayList arrayList;
    private DataAdapter dataAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        switch_btn = (SwitchCompat) findViewById(R.id.switch_btn);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);//displaying data items in scrollable list
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<DataModel> arrayList=new ArrayList<DataModel>();


        String[] label = getResources().getStringArray(R.array.label);
        String[] details = getResources().getStringArray(R.array.details);

        int i = 0;
        for (String name : label) {
            DataModel dataprovider = new DataModel(name,details[i]);
            arrayList.add(dataprovider);
            i++;
        }

        dataAdapter = new DataAdapter(this,arrayList); //creating object of the class DataAdapter

        recyclerView.setAdapter(dataAdapter);
    }
}