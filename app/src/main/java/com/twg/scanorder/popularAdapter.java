package com.twg.scanorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class popularAdapter extends RecyclerView.Adapter<popularAdapter.VeiwHolder> {
    Context context;
    List<modelPopular> popularList;

    public popularAdapter(Context context, List<modelPopular> popularList) {
        this.context = context;
        this.popularList = popularList;
    }

    @NonNull
    @Override
    public VeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_popular,parent,false);
        return new VeiwHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull VeiwHolder holder, int position) {
        modelPopular modelPopular =popularList.get(position);
        holder.food.setText(modelPopular.getImageName());
        holder.price.setText(modelPopular.getPrice());
        holder.rating.setText(modelPopular.getRating());
        Picasso.get().load(modelPopular.getImageURL()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return popularList.size();
    }

    public class VeiwHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView food, price, rating;
        public VeiwHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.food_image);
            food = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}
