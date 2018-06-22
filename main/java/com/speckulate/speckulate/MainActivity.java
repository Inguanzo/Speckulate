package com.speckulate.speckulate;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.speckulate.speckulate.Feed.FeedActivity;

public class MainActivity extends AppCompatActivity {
    public String FRAGMENT_TAG = "PhotosFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, FeedActivity.class);
        startActivity(intent);

        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(
                        R.id.fragment_container,
                        new  PhotosFragment(),
                        FRAGMENT_TAG)
                .commit();
    }
}
