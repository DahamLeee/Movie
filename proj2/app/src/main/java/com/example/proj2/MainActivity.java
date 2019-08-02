package com.example.proj2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ReviewAdapter reviewAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        reviewAdapter = new ReviewAdapter();

        reviewAdapter.addItem(new Review("kym71**", "10분전" , "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        reviewAdapter.addItem(new Review("kym71**", "10분전" , "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        recyclerView.setAdapter(reviewAdapter);

        Button button = findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "작성하기 버튼이 눌렸습니다", Toast.LENGTH_LONG).show();
            }
        });

        Button button2 = findViewById(R.id.showAll);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "모두보기 버튼이 눌렸습니다", Toast.LENGTH_LONG).show();
            }
        });

//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                layout2 = findViewById(R.id.layout2);
//                layout2.setRate("5위  1.8%");
//                layout2.setClientCount("839,399명");
//            }
//        }).start();
    }
}
