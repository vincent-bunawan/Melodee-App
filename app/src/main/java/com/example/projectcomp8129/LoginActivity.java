package com.example.projectcomp8129;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private Button loginBtn;
    private EditText usernameText, passwordText;
    private TextView lblError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeAttribute();

        this.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });
    }

    private void initializeAttribute() {
        this.loginBtn = findViewById(R.id.loginBtn);
        this.usernameText = findViewById(R.id.username);
        this.passwordText = findViewById(R.id.password);
        this.lblError = findViewById(R.id.lblError);
    }


    private boolean validateInput() {
        String val1 = usernameText.getText().toString();
        String val2 = passwordText.getText().toString();

        if(val1.isEmpty()){
            this.lblError.setText("Username must be filled!");
            return false;
        }else if (val2.isEmpty()) {
            this.lblError.setText("Password must be filled!");
            return false;
        } else if (val2.matches("^[A-Za-z0-9]")) {
            this.lblError.setText("Password must be alphanumeric!");
            return false;
        } else{
            openHomeActivity();
        }
        return true;
    }

    private void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("USERNAME_KEY",usernameText.getText().toString());
        startActivity(intent);
    }
}