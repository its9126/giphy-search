package com.adampolt.giphy.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adampolt.giphy.GiphyImage;
import com.adampolt.giphy.R;
import com.bumptech.glide.Glide;

public class GifViewHolder extends RecyclerView.ViewHolder {
    public TextView titleView;
    public ImageView gifView;

    public GifViewHolder(@NonNull View itemView) {
        super(itemView);

        titleView = itemView.findViewById(R.id.gifTitle);
        gifView = itemView.findViewById(R.id.imageView);
    }

    public void bind(GiphyImage image) {
        titleView.setText(image.getTitle());
        Glide.with(gifView).load(image.getGifUrl()).into(gifView);
    }
}
