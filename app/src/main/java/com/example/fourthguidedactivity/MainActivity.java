package com.example.fourthguidedactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText userText, passText;
    TextView result;
    Button loginButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        userText = findViewById(R.id.userText);
        passText = findViewById(R.id.passText);
        result = findViewById(R.id.resultText);
        loginButton = findViewById(R.id.loginButton);
        exitButton = findViewById(R.id.exitButton);
        showResult();
    }

    public void showResult(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userText.getText().toString();
                if(username.equals("France") && passText.getText().toString().equals("Cabrera")){
                    result.setText("Welcome " + username +"!");
                    result.setTextColor(Color.GREEN);
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("USERNAME", username);
                    startActivity(intent);
                    clearEntry();
                } else {
                    result.setText("Username and Password does not exist!");
                    result.setTextColor(Color.RED);
                    clearEntry();
                }
            }
        });
    }


    public void clearEntry(){
        result.setVisibility(View.VISIBLE);
        userText.setText("");
        passText.setText("");
        userText.requestFocus();
    }
}
