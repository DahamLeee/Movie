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

public class Fragment3 extends Fragment {
    ImageView imageView3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);

        imageView3 = view.findViewById(R.id.imageView3);
        Glide.with(view).load("http://movie.phinf.naver.net/20170928_85/1506564710105ua5fS_PNG/movie_image.jpg").into(imageView3);

        return view;
    }
}
