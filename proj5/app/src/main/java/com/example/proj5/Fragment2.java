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

public class Fragment2 extends Fragment {
    ImageView imageView2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        imageView2 = view.findViewById(R.id.imageView2);
        Glide.with(view).load("http://movie.phinf.naver.net/20170925_296/150631600340898aUX_JPEG/movie_image.jpg").into(imageView2);

        return view;
    }
}
