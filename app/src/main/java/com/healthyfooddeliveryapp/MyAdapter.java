package com.healthyfooddeliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[], data2[], data3[], data4[];
    int images[];
    Context context;

    public MyAdapter(Context ct, String productNames[], String productDescriptions[], String productPrices[], String productBtns[], int productImgs[]){
        context = ct;
        data1 = productNames;
        data2 = productDescriptions;
        data3 = productPrices;
        data4 = productBtns;
        images = productImgs;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_of_products, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(data1[position]);
        holder.description.setText(data2[position]);
        holder.price.setText(data3[position]);
        holder.btn.setText(data4[position]);
        holder.image.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, price, btn;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.product_description);
            price = itemView.findViewById(R.id.product_price);
            btn = itemView.findViewById(R.id.product_btn);
            image = itemView.findViewById(R.id.product_image);

        }
    }
}
