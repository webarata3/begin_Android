package com.example.view15;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SampleViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView noTextView;
    private TextView nameTextView;

    public SampleViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        noTextView = itemView.findViewById(R.id.noTextView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getNoTextView() {
        return noTextView;
    }

    public void setNoTextView(TextView noTextView) {
        this.noTextView = noTextView;
    }

    public TextView getNameTextView() {
        return nameTextView;
    }

    public void setNameTextView(TextView nameTextView) {
        this.nameTextView = nameTextView;
    }
}