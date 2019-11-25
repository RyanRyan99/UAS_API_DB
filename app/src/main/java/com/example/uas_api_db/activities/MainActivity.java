package com.example.uas_api_db.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.uas_api_db.R;
import com.example.uas_api_db.adapters.RecyclerViewAdapter;
import com.example.uas_api_db.model.animasi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request ;
    private RequestQueue requestQueue;
    private List<animasi> lstanimasi;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lstanimasi = new ArrayList<>();
        recyclerView = findViewById(R.id.idrecyclerview);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null ;

                for (int i = 0 ; i < response.length(); i++){
                    try {
                        jsonObject = response.getJSONObject(i);
                        animasi animasi =new animasi();
                        animasi.setNama(jsonObject.getString("name"));
                        animasi.setDeskripsi(jsonObject.getString("description"));
                        animasi.setRating(jsonObject.getString("Rating"));
                        animasi.setKategori(jsonObject.getString("categorie"));
                        animasi.setEpisode(jsonObject.getInt("episode"));
                        animasi.setStudio(jsonObject.getString("studio"));
                        animasi.setGambar_url(jsonObject.getString("img"));
                        lstanimasi.add(animasi);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


                setuprecycleview(lstanimasi);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request ) ;

    }

    private void setuprecycleview(List<animasi> lstanimasi) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, lstanimasi);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));

        recyclerView.setAdapter(myadapter);
    }
}
