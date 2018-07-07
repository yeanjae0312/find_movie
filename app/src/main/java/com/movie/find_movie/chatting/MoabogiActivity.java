package com.movie.find_movie.chatting;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.movie.find_movie.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoabogiActivity extends AppCompatActivity {
    Button mbbutton;
    Button CGV_link;
    Button LOTTE_link;
    Button MEGABOX_link;
    ImageView btnbefore;

    String receiveMsg="";
    StringBuffer sb;

    TextView textview;
    loadJsp task;
    //String serverURL = "http://192.168.0.153:9999/Movie/movietable.jsp";
    //192.168.0.177
    String serverURL = "http://203.252.218.95:8080/Movie/movietable_jsptest.jsp";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moabogi);

        mbbutton = (Button)findViewById(R.id.mbbutton);
        CGV_link = (Button)findViewById(R.id.CGV_link);
        LOTTE_link = (Button)findViewById(R.id.LOTTE_link);
        MEGABOX_link = (Button)findViewById(R.id.MEGABOX_link);
        btnbefore = (ImageView)findViewById(R.id.btnbefore);


        btnbefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),Chat.class));
            }
        });

        textview = (TextView) findViewById(R.id.textview);

        mbbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = new loadJsp();

                task.execute();
                textview.append(receiveMsg);
            }
        });

        CGV_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cgv.co.kr/ticket/")));
            }
        });

        LOTTE_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lottecinema.co.kr/LCHS/Contents/ticketing/ticketing.aspx")));
            }
        });

        MEGABOX_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.megabox.co.kr/?menuId=theater")));
            }
        });


    }
    class loadJsp extends AsyncTask<Void, String, String> {
        String data = null;
        StringBuffer buffer;
        StringBuffer testbuffer = new StringBuffer();
        String testS;

        String startJson = "[";
        String endJson = "]";
        String teststring = "{\"theatername\"" + ":" + "\"" + "\"suyu CGV,\"" + "\"" + "\"theaterid\"" + ":" + "\"1\"" + "," + "\"location_x\"" + ":" + "\"37.6271852\"" + "," + "\"location_y\"" + ":" + "\"127.0127748\"" + "}";


        @Override
        protected String doInBackground(Void... voids) {

            try {
                testbuffer.append(teststring);
                testS = startJson + teststring + endJson;
                //textview.setText(startJson+testbuffer+endJson);

                URL url = new URL(serverURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                /*conn.setRequestProperty("theaterid","theaterid");
                conn.setRequestProperty("theatername","theatername");
                conn.setRequestProperty("location_x","location_x");
                conn.setRequestProperty("location_y","location_y");*/
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.connect();

                Log.i("yj", "URL접속");

                OutputStreamWriter ows = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                //ows.write("key=" + "ok");
                ows.flush();
                Log.i("yj", "key");

                if (conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader in = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(in);
                    buffer = new StringBuffer();

                    Log.i("yj", "while위");

                    while ((data = reader.readLine()) != null) {
                        buffer.append(data);
                        Log.i("yj", "data = " + data);
                    }
                    receiveMsg = buffer.toString();

                    Log.i("yj", "서버에서 안드로이드로 전달 됨");
                    Log.i("yj", "receiveMsg = " + receiveMsg); //

                    reader.close();

                    //textview.append(receiveMsg);
////////////////////////////////////////////////////////////////////////////////////////////////////
                    Log.i("yj", "json파싱 위"); //

                    JSONObject json = new JSONObject(receiveMsg);
                    Log.i("yj", "json = " + json);

                    JSONArray jArr = new JSONArray(receiveMsg);
                    //JSONArray jArr = json.getJSONArray("datasend");
                    Log.i("yj", "jArr = " + jArr);

                    sb = new StringBuffer();
                    for (int i = 0; i < jArr.length(); i++) {
                        json = jArr.getJSONObject(i);
                        //Log.i("yj","json = " + json);
                        //json = jArr.getJSONObject(i);
                        String theaterid = json.getString("theaterid");
                        String theatername = json.getString("theatername");
                        String location_x = json.getString("location_x");
                        String location_y = json.getString("location_y");
                        sb.append("[ " + theaterid + " ]\n");
                        sb.append("[ " + theatername + " ]\n");
                        sb.append(location_x + "\n");
                        sb.append(location_y + "\n");
                        sb.append("\n");
                    }

                    //textview.append(sb);
                    //textview.append("hello");

                    //return buffer.toString().trim();
                } else {
                    Log.i("통신 결과", conn.getResponseCode() + "에러");
                }

                //textview.append("모아보기");

            } catch (Exception e) {
                e.printStackTrace();
            }


            return receiveMsg;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //textview.append(sb);
        }
    }
}
