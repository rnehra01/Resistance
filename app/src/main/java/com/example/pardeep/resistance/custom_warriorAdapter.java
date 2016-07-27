package com.example.pardeep.resistance;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.*;
import android.widget.*;

public class custom_warriorAdapter extends ArrayAdapter<String> {

    String[] names;
    String[] alliances;
    String [] gender;
    Context c;


    public custom_warriorAdapter(Context context, String [] names,String []alliances,String [] gender) {
        super(context, R.layout.custom_warrior_row,names);

        this.names=names;
        this.alliances=alliances;
        this.gender=gender;
        this.c=context;
    }

    public class ViewHolder{
        TextView warName_list;
        TextView warAlliance_list;
        TextView counter;
        TextView Gen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater Inflater=LayoutInflater.from(getContext());
        View cutomView=Inflater.inflate(R.layout.custom_warrior_row, parent, false);

        final ViewHolder holder=new ViewHolder();


        holder.warName_list=(TextView)cutomView.findViewById(R.id.warName_list);
        holder.warAlliance_list=(TextView)cutomView.findViewById(R.id.warAlliance_list);
        holder.Gen=(TextView)cutomView.findViewById(R.id.Gen);
        holder.counter=(TextView)cutomView.findViewById(R.id.counter);

        holder.warAlliance_list.setText(alliances[position]);
        holder.warName_list.setText(names[position]);
        holder.Gen.setText(gender[position]);
        holder.counter.setText((position+1)+"");
        if (alliances[position].equals("LIGHT")){
            cutomView.setBackgroundColor(Color.rgb(54,60,255));
        }
        else {
            cutomView.setBackgroundColor(Color.rgb(207,14,17));
        }




        return cutomView;
    }
}

