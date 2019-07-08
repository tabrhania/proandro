package com.sixth.jsfnl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProdukActivity extends AppCompatActivity {
    private String URL="http://192.168.1.45:8080/rest-server-jembersari/api/product";
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Data> listdata;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);

        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager=new GridLayoutManager(this,2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        listdata=new ArrayList<Data>();
        AmbilData();
        recyclerAdapter=new RecyclerAdapter(this,listdata);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }



    public void AmbilData(){
        JsonArrayRequest arrRequest=new JsonArrayRequest(URL ,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0) {
                            for (int i = 0; i < response.length(); i++)
                                try {
                                    JSONObject data = response.getJSONObject(i);
                                    Data item = new Data();
                                    item.setId(data.getString("product_id"));
                                    item.setJudul(data.getString("product_name"));
                                    item.setHarga(data.getString("price"));
//                                    item.setThubnail(URL + "/img/" + data.getString("gambar"));
                                    listdata.add(item);
                                    recyclerAdapter.notifyDataSetChanged();

                                } catch (JSONException e) {

                                }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){

        };
        Volley.newRequestQueue(this).add(arrRequest);
    }
}
