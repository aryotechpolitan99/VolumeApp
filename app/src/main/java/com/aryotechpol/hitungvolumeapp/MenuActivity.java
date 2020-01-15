package com.aryotechpol.hitungvolumeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button btnPrismaS3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnPrismaS3 = findViewById(R.id.btn_prismaS3);

        btnPrismaS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahkePrismaS3 =new Intent(MenuActivity.this, MainActivity.class);
                startActivity(pindahkePrismaS3);
            }
        });

    }
}
