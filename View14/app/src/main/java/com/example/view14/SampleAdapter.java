package com.example.view14;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SampleAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Sample> sampleList;

    public SampleAdapter(Context context, List<Sample> sampleList) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.sampleList = sampleList;
    }

    @Override
    public int getCount() {
        return sampleList.size();
    }

    @Override
    public Object getItem(int position) {
        return sampleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return sampleList.get(position).getNo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView noTextView = convertView.findViewById(R.id.noTextView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        Sample sample = sampleList.get(position);
        imageView.setImageBitmap(BitmapFactory.decodeResource(convertView.getResources(), R.drawable.sample));
        noTextView.setText(String.valueOf(sample.getNo()));
        nameTextView.setText(sample.getName());
        return convertView;
    }
}
