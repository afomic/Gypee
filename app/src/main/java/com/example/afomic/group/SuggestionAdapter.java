package com.example.afomic.group;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by afomic on 03-Jun-16.
 */
public class SuggestionAdapter extends ArrayAdapter{
    ArrayList<ModelCourse> courses=null;
    public SuggestionAdapter(Context context, int resource,ArrayList<ModelCourse> result) {
        super(context, resource);
        courses=result;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public ModelCourse getItem(int position) {
        return courses.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModelCourse course=getItem(position);
        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.search_row,parent,false);
            ViewHolder holder=new ViewHolder();
            holder.searchName=(TextView)convertView.findViewById(R.id.search_name);
            holder.searchName.setText(course.name);
            convertView.setTag(holder);
        }
        else {
            ViewHolder holder=(ViewHolder) convertView.getTag();

        }

        return convertView;
    }

    public class ViewHolder{
        TextView searchName;
    }

}
