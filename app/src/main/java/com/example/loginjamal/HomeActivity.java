package com.example.loginjamal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DatabaseHelper(this);
        logout = (Button)findViewById(R.id.blogout);

        Boolean checkSession = db.checkSession("ada");
        if (checkSession == false){
            Intent loginIntent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(loginIntent);
            finish();
        }

        //logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updateSession = db.upgradesession("kosong", 1);
                if (updateSession == true){
                    Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });
    }
}
