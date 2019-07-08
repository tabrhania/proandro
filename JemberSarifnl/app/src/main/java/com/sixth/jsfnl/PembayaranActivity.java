package com.sixth.jsfnl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PembayaranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        Button btn = (Button) findViewById(R.id.bayar_lanjut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent byrlnjt = new Intent(getApplicationContext(),Pembayaran_lanjutActivity.class);
                startActivity(byrlnjt);
            }
        });
    }
}
