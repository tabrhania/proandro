package com.sixth.jsfnl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class BerandaActivity extends AppCompatActivity {


    ViewFlipper v_flipper;
    ImageView iproduk, iakun, ipembelian, ikeranjang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};

        iproduk = (ImageView) findViewById(R.id.productImg);
        iakun = (ImageView) findViewById(R.id.accountImg);
        ipembelian = (ImageView) findViewById(R.id.purchaseImg);
        ikeranjang = (ImageView) findViewById(R.id.cartImg);
        v_flipper = findViewById(R.id.v_flipper);

        // loop flipper
        for (int image: images){
            flipperImages(image);
        }

        iproduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1 = new Intent(getApplicationContext(),ProdukActivity.class);
                startActivity(i1);
            }
        });


        iakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(getApplicationContext(),AkunActivity.class);
                startActivity(i2);
            }
        });

        ipembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1 = new Intent(getApplicationContext(),StatusPemesananActivity.class);
                startActivity(i1);
            }
        });

        ikeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1 = new Intent(getApplicationContext(),KeranjangActivity.class);
                startActivity(i1);
            }
        });

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000); //4sec
        v_flipper.setAutoStart(true);

        //animation

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
