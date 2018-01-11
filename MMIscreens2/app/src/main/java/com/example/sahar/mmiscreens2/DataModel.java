package com.example.sahar.mmiscreens2;

/**
 * Created by sahar on 11/1/18.
 */

public class DataModel {
    String title;
    String [] spinner;


    public String getTitle(){
        return title;
    }

    public void setTitle(String name){
        this.title=name;
    }

    public String[] getSpinner(){
        return spinner;
    }

    public void setSpinner(String[] options){
        this.spinner=options;
    }
}

