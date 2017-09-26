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
    private Context context;
    private ArrayList<String> list = new ArrayList<String>();
    private LayoutInflater inflter;


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
        return i;
    }

    public List<String> getData(){
        return list;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }





    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflter.inflate(R.layout.activity_list_view, viewGroup, false);

            holder = new ViewHolder();
            holder.btnDelete = (Button) convertView.findViewById(R.id.button2);
            holder.textView = (TextView) convertView.findViewById(R.id.textview);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(list.get(position));


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Button a = (Button) v.findViewById(R.id.button2);
                list.remove(position);
                notifyDataSetChanged();


            }
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
        Button btnDelete;
    }
}