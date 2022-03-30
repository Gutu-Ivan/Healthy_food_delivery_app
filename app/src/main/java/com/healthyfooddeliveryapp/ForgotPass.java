package com.healthyfooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import com.google.android.material.textfield.TextInputEditText;

public class ForgotPass extends AppCompatActivity {
    private TextInputEditText mEmail;
    Button mRestorePassBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restore_password);

        mEmail = findViewById(R.id.restore_email_text);
        mRestorePassBtn = findViewById(R.id.restore_password_btn);

        mRestorePassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ForgotPass.this, "Reset link has sent to your email!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                   @Override
                    public void onFailure (@NonNull Exception e) {
                       Toast.makeText(ForgotPass.this, "Error! Reset link is not sent.", Toast.LENGTH_SHORT).show();
                   }
                });
            }
        });
    }

    public void logOut(View view) {
        startActivity(new Intent (getApplicationContext(), MainActivity.class));
        finish();
    }
}