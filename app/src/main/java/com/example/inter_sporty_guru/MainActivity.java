package com.example.inter_sporty_guru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {

    private String url="http://universities.hipolabs.com/search?country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<collage_data> tot_data = new ArrayList<>();

        String data[]=new String[20];

        for(int i=0;i<20;i++)
        {
            data[i]="Name"+i;

        }


        //////recycle view///


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // final RecyclerView.Adapter[] adapter = new RecyclerView.Adapter[1];
        //final Adapetr_data[] adapter = new Adapetr_data[1];
       // recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(adapter);



        ////////////////

        /////////volly labary/////////

        RequestQueue requestQueue= Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                String s1,s2,s3;
                                String s4 = null;
                                JSONObject get_data = response.getJSONObject(i);
                                 s1=get_data.getString("name");
                                 s2=get_data.getString("country");
                                 s3=get_data.getString("state-province");

                                // JSONArray j_arr01=response.getJSONArray("web_pages");
                               JSONArray JArrBoundry=get_data.getJSONArray("web_pages");
                                for(int j1=0;j1<JArrBoundry.length();j1++)
                                {
                                    s4+=JArrBoundry.getString(j1);
                                    s4+='\n';
                                    Log.i("check007",s4+"  \n");

                                }


                                 collage_data d1=new collage_data();
                                 d1.setColl_name(s1);
                                 d1.setColl_country(s2);
                                 d1.setColl_state(s3);
                                 d1.setColl_webpage(s4);
                                Log.d("check007", "onResponse: "+s1+" "+s2+" "+s3);
                                tot_data.add(d1);
                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


                        /////add responce to view
                        Adapetr_data adapter = new Adapetr_data(MainActivity.this,tot_data);
                        recyclerView.setAdapter(adapter);


                       ///////////////
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                    }
                });
        requestQueue.add(jsonArrayRequest);


        //////////////////////////////////




    }
}