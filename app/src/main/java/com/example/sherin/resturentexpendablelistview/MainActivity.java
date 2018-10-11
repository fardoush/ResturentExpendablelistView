package com.example.sherin.resturentexpendablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

  // ImageView imageView01;
    private ExpandableListView expandableListView;
    private List<String> parent = new ArrayList<>();
    private Map<String, List<String>> child = new HashMap<>();
    private Expandable_ListView expandable_listView;
    int lastPosition = -1;

    /*private int[] pictures = {R.drawable.one, R.drawable.two,
            R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six,
            R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten,
            R.drawable.eleven, R.drawable.twelve, R.drawable.thirteen, R.drawable.fourteen,
            R.drawable.fifteen, R.drawable.sixteen, R.drawable.seventeen, R.drawable.eighteen,
            R.drawable.nineteen, R.drawable.twenty};*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        preparedData();
        addListener();
    }

    private void addListener() {



        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {


                if (lastPosition!=-1 && lastPosition!=groupPosition){

                    expandableListView.collapseGroup(lastPosition);

                }

                lastPosition = groupPosition;

            }
        });

    }

    private void preparedData() {
        String[] parent_poet = getResources().getStringArray(R.array.foodName);
        String[] child_details = getResources().getStringArray(R.array.child_food);

        Log.i("parent", Arrays.toString(parent_poet));

        for (int i = 0; i < parent_poet.length; i++) {
            // adding parent data
            parent.add(parent_poet[i]);
            List<String> childd = new ArrayList<>();
            childd.add(child_details[i]);
            child.put(parent.get(i), childd);
        }

        expandable_listView = new Expandable_ListView(this, parent, child);//pic
        expandableListView.setAdapter(expandable_listView);
        //   imageView01.setImageResource(pictures[lastPosition]);


    }

    private void initView() {

        expandableListView = findViewById(R.id.exLvId);
      //  imageView01 = findViewById(R.id.parent_indicator);
        // ExpandableListView adapter = new ExpandableListView(this,pictures);
        //expandable_listView.setAdapter(adapter);

    }
}