package com.example.sahar.mmiscreens2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sahar on 11/1/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<DataModel> title; //title array
    Context context;

    public DataAdapter(Context context,ArrayList<DataModel> title){
        this.title=title;
        this.context=context; //initializing context
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        DataModel dataModel=title.get(i);
        viewHolder.tv_title.setText(dataModel.getTitle()); //viewHolder for title


        List<String> stringList = new ArrayList<String>(Arrays.asList(dataModel.getSpinner())); //converting String to ArrayList
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context,R.layout.spinner_color, stringList);
        viewHolder.spinner.setAdapter(dataAdapter); //viewHolder for spinner


        //for setting different gradient color for each cardView
        switch (dataModel.getTitle()){
            case "Make":
                viewHolder.linearLayout.setBackground(context.getResources().getDrawable(R.drawable.gradient1));
                break;

            case "Model":
                viewHolder.linearLayout.setBackground(context.getResources().getDrawable(R.drawable.gradient2));
                break;

            case "Color":
                viewHolder.linearLayout.setBackground(context.getResources().getDrawable(R.drawable.gradient3));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout linearLayout;
        private TextView tv_title;
        private Spinner spinner;

        public ViewHolder(View view){  //setting title,spinner,linearLayout to the ViewHolder
            super(view);
            linearLayout=(LinearLayout)view.findViewById(R.id.linear_layout);
            tv_title=(TextView)view.findViewById(R.id.title);
            spinner=(Spinner)view.findViewById(R.id.spinnerView);


        }
    }
}
