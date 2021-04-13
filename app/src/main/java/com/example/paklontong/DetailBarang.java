package com.example.paklontong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class DetailBarang extends AppCompatActivity {
    Button back;

    private int RvOrien = 0;
    private Button btnGrid;
    private Button btnHorizontal;
    private Button btnVertical;
    private RecyclerView rvTokoLontong;
    private ArrayList<TokoLontongModel> listBarang = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        rvTokoLontong = findViewById(R.id.rv_barang);
        rvTokoLontong.setHasFixedSize(true);
        listBarang.addAll(TokoLontongData.getListData());

        btnHorizontal = findViewById(R.id.btnhorizontal);
        btnVertical = findViewById(R.id.btnvertical);
        btnGrid = findViewById(R.id.btngrid);

        back = findViewById(R.id.btn_kembali2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(DetailBarang.this,MainActivity.class);
                startActivity(back);
            }
        });

        btnVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRvOrien(0);
                showRecyclerList();
            }
        });
        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRvOrien(1);
                showRecyclerList();
            }
        });
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRvOrien(2);
                showRecyclerList();
            }
        });

        showRecyclerList();
    }

    private void showRecyclerList(){
        switch (getRvOrien()){
            case 0 : rvTokoLontong.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false));
                break;
            case 1 : rvTokoLontong.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false));
                break;
            case 2 : rvTokoLontong.setLayoutManager(new GridLayoutManager( this, 2));
                break;
            default : rvTokoLontong.setLayoutManager(new LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false));
        }
        TokoLontongAdapter tokolontongAdapter = new TokoLontongAdapter(this);
        tokolontongAdapter.setRvOrienta(getRvOrien());
        tokolontongAdapter.setTokoLontongModels(listBarang);
        rvTokoLontong.setAdapter(tokolontongAdapter);

        tokolontongAdapter.setOnItemClickListener(new TokoLontongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(DetailBarang.this, DeskripsiBarang.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public int getRvOrien() {
        return RvOrien;
    }

    public void setRvOrien(int rvOrien) {
        RvOrien = rvOrien;
    }
}