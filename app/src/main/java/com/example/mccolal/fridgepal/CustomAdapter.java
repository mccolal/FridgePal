package com.example.mccolal.fridgepal;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    private ArrayList<String> list = new ArrayList<String>();
    LayoutInflater inflter;


    public CustomAdapter(Context applicationContext, ArrayList<String> listReceived) {
        this.context = applicationContext;

        this.list = listReceived;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    public List<String> getData(){
        return list;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }



    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list_view, null);

        TextView item = (TextView) view.findViewById(R.id.textview);
        item.setText(list.get(position));

        Button btn1 = (Button)view.findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task

                notifyDataSetChanged();
            }
        });


        return view;
    }
}