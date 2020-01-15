package com.aryotechpol.hitungvolumeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView tvHasil;
    private EditText etPanjang, etLebar, etTinggi;
    private Button btnHitung, btnReset;
    private ActionBar actionBar;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial();

        btnHitung.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    private void initial() {
        tvHasil = findViewById(R.id.tv_hasil);
        etPanjang = findViewById(R.id.et_panjang);
        etLebar = findViewById(R.id.et_lebar);
        etTinggi = findViewById(R.id.et_tinggi);
        btnHitung = findViewById(R.id.btn_hitung);
        btnReset = findViewById(R.id.btn_reset);
        actionBar = getSupportActionBar();
        getSupportActionBar().setTitle(getResources().getString(R.string.activity_title));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hitung:
                String panjang = etPanjang.getText().toString().trim();
                String lebar = etLebar.getText().toString().trim();
                String tinggi = etTinggi.getText().toString().trim();

                hitungVolume(panjang, lebar, tinggi);
                break;

            case R.id.btn_reset:
                reset();
                break;
        }
    }

    private void reset(){
        etPanjang.setText("");
        etLebar.setText("");
        etLebar.setText("");
    }

    private void hitungVolume(String paramPanjang, String paramLebar, String paramTinggi) {
        boolean isEmptyInput = false;
        boolean isValidDouble = true;
        if (TextUtils.isEmpty(paramPanjang)) {
            isEmptyInput = true;
            etPanjang.setError("Field panjang tidak boleh kosong");
            Toast.makeText(this, "Field panjang tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(paramLebar)) {
            isEmptyInput = true;
            etLebar.setError("Field lebar tidak boleh kosong");
            Toast.makeText(this, "Field lebar tidak boleh kosong", Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(paramTinggi)) {
            isEmptyInput = true;
            etTinggi.setError("Field tinggi tidak boleh kosong");
            Toast.makeText(this, "Field tinggi tidak boleh kosong", Toast.LENGTH_LONG).show();
        }


        //proses konversi
        Double panjang = convertToDouble(paramPanjang); // null
        Double lebar = convertToDouble(paramLebar);
        Double tinggi = convertToDouble(paramTinggi);

        if (panjang == null) {
            isValidDouble = false;
        }

        if (lebar == null) {
            isValidDouble = false;
        }

        if (tinggi == null) {
            isValidDouble = false;
        }

        if (!isEmptyInput && isValidDouble) {
            Double volume = (panjang * lebar / 2) * tinggi;
            tvHasil.setText(String.valueOf(volume));
        }
    }


    private Double convertToDouble(String data) {
        try {
            return Double.valueOf(data);
        } catch (Exception e) {
            Log.e("Convert Error : ", e.getMessage());
            return null;
        }
    }
}