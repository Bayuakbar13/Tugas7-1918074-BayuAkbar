package com.example.tugas7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Emerek, Eharga, Ewarna;
    private String Smerek, Sharga, Swarna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Emerek = (EditText) findViewById(R.id.create_mereklaptop);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Ewarna = (EditText) findViewById(R.id.create_warnalaptop);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Smerek = String.valueOf(Emerek.getText());
                Sharga = String.valueOf(Eharga.getText());
                Swarna = String.valueOf(Ewarna.getText());
                if (Smerek.equals("")){
                    Emerek.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi merek laptop anda", Toast.LENGTH_SHORT).show();
                } else if (Eharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi harga laptop anda", Toast.LENGTH_SHORT).show();
                } else if (Swarna.equals("")) {
                    Ewarna.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi warna laptop anda",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Emerek.setText("");
                    Eharga.setText("");
                    Ewarna.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreatePenjualan (new PenjualanLaptop(null, Smerek, Sharga ,Swarna));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

