package com.example.baterinaexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    MaterialToolbar toolbar;
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String message;
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            message= null;
        } else {
            message= extras.getString("MESSAGE");
        }
        Log.i("Message",message);


        toolbar = findViewById(R.id.toolbar);

        frameLayout = findViewById(R.id.main_frameLayout);
        drawerlayout = findViewById(R.id.drawerLayout);
        navigationview = findViewById(R.id.navigation);

        navigationview.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,
                    new HomeFragment()).commit();navigationview.setCheckedItem(R.id.nav_home);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerlayout.isDrawerOpen(GravityCompat.START)){
            drawerlayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,
                        new HomeFragment()).commit();
                break;

            case R.id.nav_announcement:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,
                        new AnnouncementFragment()).commit();
                break;

            case R.id.nav_schedule:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,
                        new ScheduleFragment()).commit();
                break;

            case R.id.account_general:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,
                        new GeneralFragment()).commit();
                break;

            case R.id.account_changePassword:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,
                        new ChangePasswordFragment()).commit();
                break;
            case R.id.account_logout:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("MESSAGE","hello");
                startActivity(intent);
                break;
        }
        return true;
    }
}