package com.healthyfooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class Products extends AppCompatActivity {
    String productNames[], productDescriptions[], productPrices[], productBtns[];
    int productImgs[] = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8};
    RecyclerView recyclerView;
    Button addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        recyclerView = findViewById(R.id.product_list);

        productNames = getResources().getStringArray(R.array.product_names);
        productDescriptions = getResources().getStringArray(R.array.product_descriptions);
        productPrices = getResources().getStringArray(R.array.product_prices);
        productBtns = getResources().getStringArray(R.array.product_btns);

        MyAdapter myAdapter = new MyAdapter(this, productNames, productDescriptions, productPrices, productBtns, productImgs);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void logOut(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent (getApplicationContext(), MainActivity.class));
        finish();
    }

    public void openShoppingCart(View view) {
        setContentView(R.layout.shopping_cart);
    }
}