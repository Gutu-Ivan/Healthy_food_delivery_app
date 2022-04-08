package com.healthyfooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Products extends AppCompatActivity {
    TextView textElem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        textElem = (TextView) findViewById(R.id.main_pr_name1);

    }
    public void logOut(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent (getApplicationContext(), MainActivity.class));
        finish();
    }
    public void showDetails() {
        textElem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.product_details);
            }
        });
    }
}