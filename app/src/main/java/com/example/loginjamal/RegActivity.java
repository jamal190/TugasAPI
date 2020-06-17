package com.example.loginjamal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button daftar, back;
    EditText username, password, passwordconf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        db = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.usernamereg);
        password = (EditText)findViewById(R.id.passwordreg);
        passwordconf = (EditText)findViewById(R.id.passwordconfreg);
        daftar = (Button)findViewById(R.id.breg);
        back = (Button)findViewById(R.id.bkembali);

        //daftar
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(RegActivity.this, MainActivity.class);
                startActivity(backIntent);
                finish();
            }
        });
        //daftar
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strPasswordconf = passwordconf.getText().toString();
                if (strPassword.equals(strPasswordconf)){
                    Boolean daftarakun = db.insertUser(strUsername,strPassword);
                    if (daftarakun == true){
                        Toast.makeText(getApplicationContext(),"Berhasil Daftar", Toast.LENGTH_SHORT).show();
                        Intent daftarakunIntent = new Intent(RegActivity.this, MainActivity.class);
                        startActivity(daftarakunIntent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
