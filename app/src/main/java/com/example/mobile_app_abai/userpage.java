package com.example.mobile_app_abai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class userpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_profile:
                        return true;

                    case R.id.nav_rating:
                        startActivity(new Intent(getApplicationContext(), Ratingpage.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_book:
                        startActivity(new Intent(getApplicationContext(), Bookspage.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Mainpage.class ));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_test:
                        startActivity(new Intent(getApplicationContext(), Process_test.class ));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}