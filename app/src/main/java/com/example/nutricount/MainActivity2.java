package com.example.nutricount;

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
    Button btnSubmit;
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
                    else if(pass!=confirmpass) {
                        Toast.makeText(MainActivity2.this, "PASSWORD AND CONFIRM PASSWORD IS INVALID", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String u = username.toString();
                        String e = email.toString();
                        String p = pass.toString();
                        dbConnection db = new dbConnection(MainActivity2.this);
                        db.addUser(u,e,p);
                    }



            }
        });
    }



}