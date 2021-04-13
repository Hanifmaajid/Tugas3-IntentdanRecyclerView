package com.example.paklontong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InputData extends AppCompatActivity {
    TextView tvHasil;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        tvHasil = findViewById(R.id.tv_hasil);

        String namabarangg = getIntent().getStringExtra("namabarang");
        String qtyy = getIntent().getStringExtra("qty");
        int datee = getIntent().getIntExtra("date",0);

        String tekshasil = "Barang bernama '"+namabarangg+"' dengan jumlah '"+qtyy+"' telah masuk pada tanggal '"+datee+"'";
        tvHasil.setText(tekshasil);

        back = findViewById(R.id.btn_kembali1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(InputData.this,MainActivity.class);
                startActivity(back);
            }
        });
//        MainActivity mainActivity = new MainActivity();
//        mainActivity.Halo();
    }
}