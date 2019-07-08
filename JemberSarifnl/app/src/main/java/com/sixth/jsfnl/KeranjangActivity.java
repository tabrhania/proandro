package com.sixth.jsfnl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class KeranjangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjangx);

        Button btn = (Button) findViewById(R.id.bayar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent byr = new Intent(getApplicationContext(),PembayaranActivity.class);
                startActivity(byr);
            }
        });
    }
}
