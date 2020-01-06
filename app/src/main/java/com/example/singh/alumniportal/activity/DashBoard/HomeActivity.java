package com.example.singh.alumniportal.activity.DashBoard;
import android.content.Intent;
import android.os.Bundle;

import com.example.singh.alumniportal.R;
import com.example.singh.alumniportal.ViewPagerAdapter;
import com.example.singh.alumniportal.activity.DashBoard.NavigationFragment.CreateEventActivity;
//import com.example.singh.alumniportal.activity.DashBoard.NavigationFragment.EventActivity;
import com.example.singh.alumniportal.activity.DashBoard.NavigationFragment.FindFriendActivity;
import com.example.singh.alumniportal.activity.DashBoard.NavigationFragment.GalleryActivity;
import com.example.singh.alumniportal.activity.DashBoard.NavigationFragment.OwnProfileActivity;
import com.example.singh.alumniportal.activity.DashBoard.NavigationFragment.PostJobActivity;
import com.example.singh.alumniportal.activity.DashBoard.NavigationFragment.SearchJobActivity;
import com.example.singh.alumniportal.activity.DashBoard.NavigationFragment.UpcomingBirthdayActivity;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager;
    LinearLayout layoutprofile,layoutfriend,layoutpostjob,layoutsearchjob,layoutbirthday,layoutevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        layoutprofile=(LinearLayout)findViewById(R.id.layout_own_profile);
        layoutfriend=(LinearLayout)findViewById(R.id.layout_find_friend);
        layoutpostjob=(LinearLayout)findViewById(R.id.layout_post_job);
        layoutsearchjob=(LinearLayout)findViewById(R.id.layout_search_job);
        layoutevent=(LinearLayout)findViewById(R.id.layout_event);
        layoutbirthday=(LinearLayout)findViewById(R.id.layout_birthday);

        layoutprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(HomeActivity.this, OwnProfileActivity.class);
                startActivity(profile);
            }
        });
        layoutfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent friend = new Intent(HomeActivity.this, FindFriendActivity.class);
                startActivity(friend);
            }
        });
        layoutpostjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent postjob = new Intent(HomeActivity.this, PostJobActivity.class);
                startActivity(postjob);
            }
        });
        layoutsearchjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchjob = new Intent(HomeActivity.this, SearchJobActivity.class);
                startActivity(searchjob);
            }
        });
//        layoutevent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent event = new Intent(HomeActivity.this, EventActivity.class);
//                startActivity(event);
//            }
//        });
        layoutbirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent birthday = new Intent(HomeActivity.this, UpcomingBirthdayActivity.class);
                startActivity(birthday);
            }
        });


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_own_profile) {
            Intent ownprofile = new Intent(HomeActivity.this, OwnProfileActivity.class);
            startActivity(ownprofile);
        } else if (id == R.id.nav_find_friend) {
            Intent findfriend = new Intent(HomeActivity.this, FindFriendActivity.class);
            startActivity(findfriend);

        } else if (id == R.id.nav_gallery) {
            Intent gallery = new Intent(HomeActivity.this, GalleryActivity.class);
            startActivity(gallery);
        } else if (id == R.id.nav_post_job) {

        } else if (id == R.id.nav_search_job) {

        } else if (id == R.id.nav_send_gift) {

        } else if (id == R.id.nav_events) {
//            Intent events = new Intent(HomeActivity.this, EventActivity.class);
//            startActivity(events);

        } else if (id == R.id.nav_upcoming_birthday) {
            Intent upcomingbirthday = new Intent(HomeActivity.this, UpcomingBirthdayActivity.class);
            startActivity(upcomingbirthday);

        } else if (id == R.id.nav_create_events) {
            Intent createevents = new Intent(HomeActivity.this, CreateEventActivity.class);
            startActivity(createevents);


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
