package com.example.proj2;

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
