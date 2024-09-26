package com.example.inter_sporty_guru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.inter_sporty_guru.Room.MyDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {

    static int count=20;
    MyDatabase mydb;
    private String url="http://universities.hipolabs.com/search?country";
    ProgressDialog p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<collage_data> tot_data = new ArrayList<>();


        //////recycle view///

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ////////////////

        ///Room database libirary //////////////////////////

        mydb= Room.databaseBuilder(MainActivity.this,MyDatabase.class,"collage_db").allowMainThreadQueries().build();


        Log.d("STUDENT_DATA" , "starting inn log");
        List<collage_data> stuData =  mydb.dao().get_coll_data();
        Log.d("STUDENT_DATA" , "starting inn db");


        if(stuData.size()==0)
        {
            //empty table
            Log.d("STUDENT_DATA" , "insertion in db with volly");

            RequestQueue requestQueue= Volley.newRequestQueue(this);

            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                    null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response)
                        {
                            try {
                                for (int i = 0; i < 20; i++) {

                                    String s1,s2,s3;
                                    String s4 = null;
                                    JSONObject get_data = response.getJSONObject(i);
                                    s1=get_data.getString("name");
                                    s2=get_data.getString("country");
                                    s3=get_data.getString("state-province");

                                    Log.i("check007",s1+"  "+s2+"  "+count+"  \n");

                                    // JSONArray j_arr01=response.getJSONArray("web_pages");
                                    JSONArray JArrBoundry=get_data.getJSONArray("web_pages");
                                    for(int j1=0;j1<JArrBoundry.length();j1++)
                                    {
                                        s4+=JArrBoundry.getString(j1);
                                        s4+='\n';
                                        //Log.i("check007",s4+"  \n");

                                    }


                                    collage_data d1=new collage_data();
                                    d1.setColl_name(s1);
                                    d1.setColl_country(s2);
                                    d1.setColl_state(s3);
                                    d1.setColl_webpage(s4);

                                    collage_data d2=new collage_data(s1,s2,s3,s4);

                                    Log.d("check007", "onResponse: "+s1+" "+s2+" "+s3);
                                    tot_data.add(d1);
                                    mydb.dao().DataInsertion(d2);

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


        }
        else
        {
            //non-empty
            Log.d("STUDENT_DATA" , "insertion in db with room");
            for (int i =0; i<stuData.size(); i++){

                Log.d("STUDENT_DATA" , stuData.get(i).getColl_country());
                 String s1,s2,s3,s4;

                s1=stuData.get(i).getColl_name();
                s2=stuData.get(i).getColl_country();
                s3=stuData.get(i).getColl_state();
                s4=stuData.get(i).getColl_webpage();


                collage_data d2=new collage_data(s1,s2,s3,s4);


                Log.d("check007", "onResponse: "+s1+" "+s2+" "+s3);
                tot_data.add(d2);

            }


               Adapetr_data adapter = new Adapetr_data(MainActivity.this,tot_data);
               recyclerView.setAdapter(adapter);

        }



    }

    //background task
    private class AsyncTaskExample extends AsyncTask<Void,Void ,Void > implements com.example.inter_sporty_guru.AsyncTaskExample {
        @Override
        protected Void doInBackground(Void... voids) {



            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(MainActivity.this);
            p.setMessage("Please wait...It is downloading");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }


        @Override
        protected void onPostExecute(Void v) {


        }
    }





}