package com.adampolt.giphy.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adampolt.giphy.GiphyImage;
import com.adampolt.giphy.R;

import java.util.List;

public class GifAdapter extends RecyclerView.Adapter<GifViewHolder> {
    public List<GiphyImage> images;

    @NonNull
    @Override
    public GifViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gif_cell, viewGroup, false);

        return new GifViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GifViewHolder gifViewHolder, int i) {
        GiphyImage image = images.get(i);

        gifViewHolder.bind(image);
    }

    @Override
    public int getItemCount() {
        if(images == null) {
            return 0;
        } else {
            return images.size();
        }
    }
}
