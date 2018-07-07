package com.movie.find_movie.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.movie.find_movie.R;
import com.movie.find_movie.find.FindActivity;

public class Chat extends AppCompatActivity {
    private Button btnMap,btnMoa,btnMoa2,btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        btnMap = (Button)findViewById(R.id.btnMap);
        btnMoa = (Button)findViewById(R.id.Moabogi);
        btnMoa2 = (Button)findViewById(R.id.Moabogi2);
        btnFinish = (Button)findViewById(R.id.btnFinish);


        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.movie.find_movie.MapActivity.class));
            }
        });

        btnMoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MoabogiActivity.class));
            }
        });

        btnMoa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FindActivity.class));
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ChattingActivity.class));
            }
        });
    }

}
