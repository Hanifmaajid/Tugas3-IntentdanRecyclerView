package com.example.paklontong;

import java.util.ArrayList;

public class TokoLontongData {

    private static String[] nama = new String[]{"Beras | 8500/Kg", "indomie | 2500/Pcs",
            "Minyak | 12000/L", "Telur | 20000/Kg", "Marlboro | 27000/Bks", "Sprite / 10000/Ltr"};
    private static int[] gambar = new int[]{R.drawable.beras, R.drawable.indomie, R.drawable.minyak,
            R.drawable.telur, R.drawable.malboro, R.drawable.sprite};

    public static ArrayList<TokoLontongModel> getListData(){
        TokoLontongModel tokolontongModel = null;
        ArrayList<TokoLontongModel> list = new ArrayList<>();

        for (int i = 0; i < nama.length; i++){
            tokolontongModel = new TokoLontongModel();
            tokolontongModel.setIcon(gambar[i]);
            tokolontongModel.setNamabarang(nama[i]);
            list.add(tokolontongModel);
        }
        return list;
    }

    public String getNama(int position) {
        return nama[position];
    }

    public int getGambar(int position) {
        return gambar[position];
    }
}
