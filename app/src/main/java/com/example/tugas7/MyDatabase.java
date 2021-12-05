package com.example.tugas7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_penjualanlaptop";
    private static final String tb_penjualan = "tb_penjualan";
    private static final String tb_penjualan_id = "id";
    private static final String tb_penjualan_merek = "merek";
    private static final String tb_penjualan_harga = "harga";
    private static final String tb_penjualan_warna = "warna";
    private static final String CREATE_TABLE_PENJUALAN = "CREATE TABLE " + tb_penjualan + "(" + tb_penjualan_id + " INTEGER PRIMARY KEY ," + tb_penjualan_merek + " TEXT," + tb_penjualan_harga + " TEXT," + tb_penjualan_warna + " TEXT " + ")";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PENJUALAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }

    public void CreatePenjualan(PenjualanLaptop mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_penjualan_id, mdNotif.get_id());
        values.put(tb_penjualan_merek, mdNotif.get_merek());
        values.put(tb_penjualan_harga, mdNotif.get_harga());
        values.put(tb_penjualan_warna, mdNotif.get_warna());
        db.insert(tb_penjualan, null, values);
        db.close();
    }

    public List<PenjualanLaptop> ReadPenjualanLaptop() {
        List<PenjualanLaptop> judulModelList = new ArrayList<PenjualanLaptop>();
        String selectQuery = "SELECT * FROM " + tb_penjualan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                PenjualanLaptop mdKontak = new PenjualanLaptop();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_merek(cursor.getString(1));
                mdKontak.set_harga(cursor.getString(2));
                mdKontak.set_warna(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdatePenjualanLaptop(PenjualanLaptop mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_penjualan_merek, mdNotif.get_merek());
        values.put(tb_penjualan_harga, mdNotif.get_harga());
        values.put(tb_penjualan_warna, mdNotif.get_warna());
        return db.update(tb_penjualan, values, tb_penjualan_id + " = ?",
                new String[]{
                        String.valueOf(mdNotif.get_id())});
    }

    public void DeletePenjualanLaptpop(PenjualanLaptop mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_penjualan, tb_penjualan_id+ " = ?", new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

