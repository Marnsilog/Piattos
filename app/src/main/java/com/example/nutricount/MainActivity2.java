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

                    if(username==null || email==null ||pass==null || confirmpass==null) {
                        Toast.makeText(MainActivity2.this, "INVALID ACCOUNT", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        Toast.makeText(MainActivity2.this, "REGISTERED SUCCESFULLY", Toast.LENGTH_SHORT).show();

                        dbConnection db = new dbConnection(MainActivity2.this);
                        String u = username.getText().toString();
                        String e = email.getText().toString();
                        String p = pass.getText().toString();
                        db.addUser(u,e,p);
                    }



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