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

public class Fragment5 extends Fragment {
    ImageView imageView5;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5, container, false);

        imageView5 = view.findViewById(R.id.imageView5);
        Glide.with(view).load("http://movie.phinf.naver.net/20170915_299/1505458505658vbKcN_JPEG/movie_image.jpg").into(imageView5);

        return view;
    }
}
