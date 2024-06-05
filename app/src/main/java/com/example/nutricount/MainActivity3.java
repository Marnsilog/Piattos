package com.example.nutricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    dbConnection db;
    EditText username, password;
    Button btnLogin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        db = new dbConnection(this);
        username = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        btnLogin1 = findViewById(R.id.login);

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                boolean isUserExist = db.checkUser(username1, password1);
                if (isUserExist) {
                    Intent intent = new Intent(MainActivity3.this ,MainActivity4.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity3.this, "Login successful", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity3.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}