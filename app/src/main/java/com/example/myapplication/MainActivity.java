package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.display.view.fragment.SearchRoverFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY = "q4deDlN3QCbYgqSwkAE9FJfPx7blT7iJsnJ5tgiS";

    private ViewPager viewPager;


    private SearchRoverFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupFragment();
    }

    /**
     * Initialisation du fragment de recherche
     * */
    private void setupFragment(){

        if(this.viewPager == null) {

            this.viewPager = findViewById(R.id.viewPager);
            this.adapter = new SearchRoverFragmentAdapter(getSupportFragmentManager());

            this.viewPager.setAdapter(this.adapter);

        }

    }
}