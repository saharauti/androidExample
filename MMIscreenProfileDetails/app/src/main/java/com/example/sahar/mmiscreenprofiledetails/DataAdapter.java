package com.example.sahar.mmiscreenprofiledetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by sahar on 22/1/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<DataModel> arrayList; //title array
    Context context;

    public DataAdapter(Context context, ArrayList<DataModel> arrayList){
        this.arrayList=arrayList;
        this.context=context; //initializing context
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_activity,parent,false);
        final ViewHolder recyclerViewHolder=new ViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        DataModel dataModel=arrayList.get(position);
        viewHolder.tv_label.setText(dataModel.getLabel()); //viewHolder for title
        viewHolder.et_details.setText(dataModel.getDetails());
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_label;
        private EditText et_details;
        private LinearLayout linearLayout;

public ViewHolder(View view){  //setting title,spinner,linearLayout to the ViewHolder
            super(view);

            linearLayout=(LinearLayout)view.findViewById(R.id.linear_layout);
            tv_label=(TextView)view.findViewById(R.id.labels);
            et_details=(EditText) view.findViewById(R.id.details);
        }
    }
}