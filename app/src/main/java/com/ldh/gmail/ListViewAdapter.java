package com.ldh.gmail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<String> {
    ArrayList<String> list;
    Context context;
    int a = 0;

    public ListViewAdapter(Context context,ArrayList<String> title_items)
    {
        super(context,R.layout.list_row,title_items);
        this.context = context;
        list = title_items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row,null);
            TextView textView_content;
            textView_content = convertView.findViewById(R.id.textView_content);
            TextView textView_title;
            textView_title = convertView.findViewById(R.id.textView_title);
            String [] str = list.get(position).split("Title:");
            textView_title.setText(str[0]);
            String [] s = str[1].split("Content:");
            textView_content.setText(s[0]);
            ImageView imageView_star;
            imageView_star = (ImageView) convertView.findViewById(R.id.imageView_star);
            imageView_star.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    a = a+1;
                    if (a%2==1) {
                        imageView_star.setImageResource(R.drawable.ic_star_gold);
                    }
                    else
                    {
                        imageView_star.setImageResource(R.drawable.ic_baseline_star_border);
                    }
                }
            });

            // set text cho textView_date
            TextView textView_date ;
            textView_date = convertView.findViewById(R.id.textView_date);
            textView_date.setText(27-position+" thg "+"11");
        }
        return convertView;
    }
}
