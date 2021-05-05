package com.example.musicappproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.musicappproject.fragments.HomeFragment;
import com.example.musicappproject.fragments.SearchFragment;
import com.example.musicappproject.fragments.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());


//        Show  Bottom Sheet Dialog for playlist

//        ImageButton btn = findViewById(R.id.btn_more_option);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomDialogTheme);
//                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.popup_more_option,findViewById(R.id.popup_more_option));
//                bottomSheetDialog.setContentView(view);
//                bottomSheetDialog.show();
//            }
//        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.ic_home:
                fragment = new HomeFragment();
                break;
            case R.id.ic_search:
                fragment = new SearchFragment();
                break;
            case R.id.ic_user:
                fragment = new UserFragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return  true;
        }
        return  false;
    }

}