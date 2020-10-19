package com.example.redenes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new ForgotPasswordFragment())
                .commit();
    }
}