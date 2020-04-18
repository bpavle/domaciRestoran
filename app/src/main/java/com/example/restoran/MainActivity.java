package com.example.restoran;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sakrivanje titl bara
        getSupportActionBar().hide();
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.tripadvisor.rs/Restaurants-g294472-Belgrade.html";
                Intent Browser = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(Browser);
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Main_Menu = new Intent(MainActivity.this,MenuActivity.class);

                startActivity(Main_Menu);
            }

        });


    }
}
