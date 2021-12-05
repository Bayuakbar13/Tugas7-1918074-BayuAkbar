package com.example.tugas7;

public class PenjualanLaptop {
    private String _id, _merek, _harga, _warna;
    public PenjualanLaptop (String id, String merek, String harga, String warna) {
        this._id = id;
        this._merek = merek;
        this._harga = harga;
        this._warna = warna;
    }
    public PenjualanLaptop() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_merek() {
        return _merek;
    }
    public void set_merek(String _merek) {
        this._merek = _merek;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
    public String get_warna() {
        return _warna;
    }
    public void set_warna(String _warna) {
        this._warna = _warna;
    }
}

