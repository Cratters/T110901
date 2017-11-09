package com.example.auser.t110901;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by auser on 2017/11/9.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    ZooInfo[] zooInfo;
    String[] str;
    public boolean[] b;

    public MyAdapter(Context context, ZooInfo[] zooInfo)
    {
        this.context = context;
        this.zooInfo = zooInfo;
        b = new boolean[zooInfo.length];
    }
    @Override
    public int getCount() {
        return zooInfo.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d("GEIVEW", "position:" + position);
        ViewHolder holder;
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.myitem, null);
            holder = new ViewHolder();
            holder.tv = convertView.findViewById(R.id.textView);
            holder.tv2 = convertView.findViewById(R.id.textView2);
            holder.btn = convertView.findViewById(R.id.button);
            holder.cb = convertView.findViewById(R.id.checkBox);
            holder.iv = convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //final String msg = str[position];

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        });

        holder.cb.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
            {
                b[position] = isChecked;
            }
        });
        holder.cb.setChecked(b[position]);
        holder.tv.setText(zooInfo[position].E_Name);
        holder.tv2.setText(zooInfo[position].E_Info);
        Picasso.with(context).load(zooInfo[position].E_Pic_URL).into(holder.iv);
        return convertView;
    }
    static class ViewHolder
    {
        TextView tv;
        TextView tv2;
        Button btn;
        CheckBox cb;
        ImageView iv;
    }
}
