package com.example.tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Smerek, Sharga, Swarna;
    private EditText Emerek, Eharga, Ewarna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Smerek = i.getStringExtra("Imerek");
        Sharga = i.getStringExtra("Iharga");
        Swarna = i.getStringExtra("Iwarna");
        Emerek = (EditText) findViewById(R.id.updel_mereklaptop);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Ewarna= (EditText) findViewById(R.id.updel_warnalaptop);
        Emerek.setText(Smerek);
        Eharga.setText(Sharga);
        Ewarna.setText(Swarna);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smerek= String.valueOf(Emerek.getText());
                Sharga = String.valueOf(Eharga.getText());
                Swarna = String.valueOf(Ewarna.getText());
                if (Smerek.equals("")){
                    Emerek.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi merek laptop", Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga laptop", Toast.LENGTH_SHORT).show();
                } else if (Swarna.equals("")){
                    Ewarna.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi warna laptop",
                            Toast.LENGTH_SHORT).show();
                } else {db.UpdatePenjualanLaptop(new PenjualanLaptop(Sid, Smerek, Sharga, Swarna));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePenjualanLaptpop (new PenjualanLaptop(Sid, Smerek, Sharga, Swarna));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

