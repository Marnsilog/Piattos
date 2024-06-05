package com.example.nutricount;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity2 extends AppCompatActivity {

    EditText username, email, pass, confirmpass;
    Button btnSubmit, btnLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        confirmpass = findViewById(R.id.confrm);
        btnSubmit = findViewById(R.id.btnsignup);
        btnLogIn = findViewById(R.id.btnlogin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();
                String pass1 = pass.getText().toString();
                String email1 = email.getText().toString();
                String conpass = confirmpass.getText().toString();

                if (TextUtils.isEmpty(username1) || TextUtils.isEmpty(email1) || TextUtils.isEmpty(pass1) || TextUtils.isEmpty(conpass)) {
                    Toast.makeText(MainActivity2.this, "INVALID ACCOUNT: All fields must be filled", Toast.LENGTH_SHORT).show();
                }
                else if (!pass1.equals(conpass)) {
                    Toast.makeText(MainActivity2.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }else if(!isPasswordValid(pass1)){
                    Toast.makeText(MainActivity2.this, "Password must contain at least one special character, one number, and one uppercase letter", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity2.this, "REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                    dbConnection db = new dbConnection(MainActivity2.this);
                    db.addUser(username1, email1, pass1);
                }
            }
            public boolean isPasswordValid(String password) {
                String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).+$";
                return password.matches(regex);
            }

        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this ,MainActivity3.class);
                startActivity(intent);
            }
        });
    }



}