package com.twg.scanorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class recommendAdapter extends RecyclerView.Adapter<recommendAdapter.ViewHolder> {
    Context context;
    List<modelRecommend> recommendList;

    public recommendAdapter(Context context, List<modelRecommend> recommendList) {
        this.context = context;
        this.recommendList = recommendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recommend,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        modelRecommend modelRecommend = recommendList.get(position);
        holder.food.setText(modelRecommend.imageName);
        holder.rating.setText(modelRecommend.rating);
        Glide.with(context).load(modelRecommend.getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return recommendList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView food, rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.food_image_r);
            food = itemView.findViewById(R.id.name);
            rating= itemView.findViewById(R.id.price);
        }
    }
}
