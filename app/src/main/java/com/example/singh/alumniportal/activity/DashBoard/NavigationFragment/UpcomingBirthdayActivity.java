package com.example.singh.alumniportal.activity.DashBoard.NavigationFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.singh.alumniportal.BirthdayAdaptor;
import com.example.singh.alumniportal.Model.Birthday;
import com.example.singh.alumniportal.R;

import java.util.ArrayList;
import java.util.List;

public class UpcomingBirthdayActivity extends AppCompatActivity {
    List<Birthday> birthdayList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_birthday);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        birthdayList = new ArrayList<>();


        //adding some items to our list
        birthdayList.add(
                new Birthday(
                        1,
                        "Ramanuj Verma",
                        "2013",
                        "Electrical",
                        "01/01/2020",
                        R.drawable.collegelogo));

        birthdayList.add(
                new Birthday(
                        1,
                        "Chandan Bhati",
                        "2013",
                        "Electrical",
                        "01/01/2020",
                        R.drawable.collegelogo));

        birthdayList.add(
                new Birthday(
                        1,
                        "Pradeep",
                        "2015",
                        "Electrical",
                        "01/01/2020",
                        R.drawable.collegelogo));

        //creating recyclerview adapter
        BirthdayAdaptor adapter = new BirthdayAdaptor(this, birthdayList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}