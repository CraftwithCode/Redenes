package com.example.redenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });

        final EditText password = findViewById(R.id.password);
        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (motionEvent.getRawX() >= (password.getRight() - password.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (count % 2 == 1) {
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            count++;
                        } else {
                            password.setInputType(InputType.TYPE_CLASS_TEXT);
                            count++;
                        }
                        return true;
                    }
                }
                return false;
            }
        });


        final EditText confPassword = findViewById(R.id.confirm_password);
        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (motionEvent.getRawX() >= (confPassword.getRight() - confPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (count % 2 == 1) {
                            confPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            count++;
                        } else {
                            confPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                            count++;
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }
}