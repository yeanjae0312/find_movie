package com.movie.find_movie.friends;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.movie.find_movie.R;
import com.movie.find_movie.chatting.ChattingActivity;
import com.movie.find_movie.first.LoginActivity;
import com.movie.find_movie.like.LikeActivity;

import java.util.ArrayList;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<FriendDatas> friendDatas;
    FriendAdapter friendAdapter;
    ImageView friendbefore;

    private static final int RC_LOCATION = 1;
    private static final int RC_LOCATION_UPDATE = 2;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @SuppressWarnings("MissingPermission")
    @AfterPermissionGranted(RC_LOCATION)
    public void getLastLocation() {
        String[] perms = {android.Manifest.permission.ACCESS_FINE_LOCATION};
        if(EasyPermissions.hasPermissions(this, perms)){

        }
        else {
            EasyPermissions.requestPermissions(this, "This app needs access to your location to know where you are.",  RC_LOCATION, perms);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("yj", "MainActivity.class 생성");

        listView = (ListView) findViewById(R.id.listView);
        friendDatas = new ArrayList<FriendDatas>();
        ImageView go_friend = (ImageView)findViewById(R.id.go_friend);
        ImageView go_chat = (ImageView)findViewById(R.id.go_chat);
        ImageView go_like = (ImageView)findViewById(R.id.go_like);
        friendbefore = (ImageView)findViewById(R.id.friendbefore);


        friendbefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),LoginActivity.class));
            }
        });
        go_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        go_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ChattingActivity.class));
            }
        });
        go_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LikeActivity.class));
            }
        });

        friendDatas.add(new FriendDatas(null,"이연재",""));
        friendDatas.add(new FriendDatas(null,"강민성","흠...!"));
        friendDatas.add(new FriendDatas(null,"강민식","2016.9.6~2018.6.5"));
        friendDatas.add(new FriendDatas(null,"강찬호",""));
        friendDatas.add(new FriendDatas(null,"강희진",""));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","exmaple"));
//        friendDatas.add(new FriendDatas(null,"이거","잘되네"));




        friendAdapter = new FriendAdapter(friendDatas, getApplicationContext());
        listView.setAdapter(friendAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
            }
        });
    }





}
