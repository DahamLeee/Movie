package com.example.proj3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_SHOW_ALL = 101;
    public static final int REQUEST_CODE_REGISTER = 102;
    ReviewAdapter reviewAdapter;
    RecyclerView recyclerView;
    TextView likeCount;
    TextView hateCount;
    ImageButton like;
    ImageButton hate;
    String temp = null;
    int temp1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeCount = findViewById(R.id.likeCount);
        hateCount = findViewById(R.id.hateCount);

        like = findViewById(R.id.like);
        like.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                like.setSelected(!like.isSelected());
                if(like.isSelected()){
                    if(hate.isSelected()){
                        hate.setSelected(!hate.isSelected());
                        hateDecrease();
                    }
                    likeIncrease();
                }
                else{
                    likeDecrease();
                }
            }
        });
        hate = findViewById(R.id.hate);
        hate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hate.setSelected(!hate.isSelected());
                if(hate.isSelected()){
                    if(like.isSelected()){
                        like.setSelected(!like.isSelected());
                        likeDecrease();
                    }
                    hateIncrease();
                }
                else{
                    hateDecrease();
                }
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        reviewAdapter = new ReviewAdapter();
        reviewAdapter.addItem(new Review("kym71**", "10분전" , "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        reviewAdapter.addItem(new Review("angel**", "15분전", "웃긴 내용보다는 좀 더 진지한 영화."));
        reviewAdapter.addItem(new Review("dlek1011","17분전", "아주 좋았어요"));
        reviewAdapter.addItem(new Review("B.I.S", "20분전", "낫 배 드"));

        recyclerView.setAdapter(reviewAdapter);

        Button button2 = findViewById(R.id.showAll);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SHOW_ALL);
            }
        });

        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivityForResult(intent, REQUEST_CODE_REGISTER);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_REGISTER){
            if(resultCode == RESULT_CANCELED){
                assert data != null;
                boolean bool = data.getBooleanExtra("response", false);
                Toast.makeText(getApplicationContext(), "저장하기 화면에서 돌아왔습니다.\n저장하기 여부 : " + bool , Toast.LENGTH_LONG).show();
            }
            else if(resultCode == RESULT_OK){
                assert data != null;
                boolean bool = data.getBooleanExtra("response", true);
                Toast.makeText(getApplicationContext(), "저장하기 화면에서 돌아왔습니다.\n저장하기 여부 : " + bool, Toast.LENGTH_LONG).show();
            }
        }

    }

    public void likeIncrease(){
        temp = likeCount.getText().toString();
        temp1 = Integer.parseInt(temp);
        temp1 += 1;
        temp = String.valueOf(temp1);
        likeCount.setText(temp);
    }
    public void likeDecrease(){
        temp = likeCount.getText().toString();
        temp1 = Integer.parseInt(temp);
        temp1 -= 1;
        temp = String.valueOf(temp1);
        likeCount.setText(temp);
    }
    public void hateIncrease(){
        temp = hateCount.getText().toString();
        temp1 = Integer.parseInt(temp);
        temp1 += 1;
        temp = String.valueOf(temp1);
        hateCount.setText(temp);
    }
    public void hateDecrease(){
        temp = hateCount.getText().toString();
        temp1 = Integer.parseInt(temp);
        temp1 -= 1;
        temp = String.valueOf(temp1);
        hateCount.setText(temp);
    }
}
