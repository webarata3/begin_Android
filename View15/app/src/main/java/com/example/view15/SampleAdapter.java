package com.example.view15;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SampleAdapter extends RecyclerView.Adapter<SampleViewHolder> {
    private Context context;
    private List<Sample> sampleList;

    public SampleAdapter(Context context, List<Sample> sampleList) {
        this.context = context;
        this.sampleList = sampleList;
    }

    @Override
    @NonNull
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new SampleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder holder, int position) {
        Sample sample = sampleList.get(position);

        holder.getImageView().setImageBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.sample));
        holder.getNoTextView().setText(String.valueOf(sample.getNo()));
        holder.getNameTextView().setText(sample.getName());
    }

    @Override
    public int getItemCount() {
        return sampleList.size();
    }
}
