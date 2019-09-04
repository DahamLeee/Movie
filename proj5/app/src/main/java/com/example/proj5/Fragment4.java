package com.example.proj5;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Fragment4 extends Fragment {
    ImageView imageView4;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);

        imageView4 = view.findViewById(R.id.imageView4);
        Glide.with(view).load("http://movie.phinf.naver.net/20171013_210/1507861351048TMJcR_JPEG/movie_image.jpg").into(imageView4);

        return view;
    }
}
