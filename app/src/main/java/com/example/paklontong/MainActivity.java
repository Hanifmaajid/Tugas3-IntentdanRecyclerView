package com.example.paklontong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button BTN1,BTN2,BTN3;
    TextView TV1,TV2,TV3;

    private int RvOrien = 0;
    private Button btnGrid;
    private Button btnHorizontal;
    private Button btnVertical;
    private RecyclerView rvTokoLontong;
    private ArrayList<TokoLontongModel> listBarang = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BTN1 = findViewById(R.id.btn_inputdata);
        BTN2 = findViewById(R.id.btn_detailbarang);
        BTN3 = findViewById(R.id.btn_dial);
        TV1 = findViewById(R.id.et_namabarang);
        TV2 = findViewById(R.id.et_qty);
        TV3 = findViewById(R.id.et_date);



        //dial number
        BTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dial = new Intent (Intent.ACTION_DIAL, Uri.parse("tel:0274486733"));
                //uri (Uniform Resource Identifier) untuk mengidentifikasi resource
                //uri.parse disini menjadikan uri menjadi suatu objek
                //tel: untuk buka calling app, geo: untuk buka maps, disebut data schemes
                startActivity(dial);
            }
        });

        //pindah activity dengan ngirim data
        BTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent (MainActivity.this,InputData.class);
//                data.putExtra("nama", "Putri Ayu");
//                data.putExtra("umur",21);
                data.putExtra("namabarang",TV1.getText().toString());
//                EditText masih berupa objek saat di getText, maka dari itu harus ditambah toString.
                data.putExtra("qty",TV2.getText().toString());
//                EditText masih berupa objek saat di getText, maka dari itu harus ditambah toString.
                data.putExtra("date",Integer.parseInt(TV3.getText().toString()));
//                Integer.parseInt untuk mengkonversi String menjadi int.

                startActivity(data);
            }
        });

        //pindah activity tanpa ngirim data
        BTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent (MainActivity.this,DetailBarang.class);
                //Intent variabel = new Intent(class asal.this,class tujuan.class);
                startActivity(pindah);
                //startActivity(variabel intent);
            }
        });
    }
//    public void Halo() {
//        System.out.println("Halo");
//    }
}