package com.example.moresmart_pc006.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static  final String TAG = "MainActivity";

    private ListView lv = null;

    private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<String>();

        for( int i = 0; i < 50; i++ )
            data.add("我是数据：" + i);

        lv =(ListView) findViewById(R.id.LV);
        MyAdapter myAdapter = new MyAdapter();
        lv.setAdapter( myAdapter );

    }


    private class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {

            Log.d(TAG, "getCount");
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            Log.d(TAG,"getView");
            TextView textView = null;
            if(view == null)
            {
                 textView = new TextView(MainActivity.this);
            }
            else
            {
                textView = (TextView) view;
            }

            textView.setText((String)getItem(i));

            return textView;

        }
    }

}