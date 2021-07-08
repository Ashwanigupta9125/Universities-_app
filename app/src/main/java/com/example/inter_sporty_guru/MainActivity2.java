package com.example.inter_sporty_guru;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView name,country,state,web_page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         name=(TextView)findViewById(R.id.textView);
        country=(TextView)findViewById(R.id.textView2);
        state=(TextView)findViewById(R.id.textView3);
        web_page=(TextView)findViewById(R.id.textView4);
         name.setText(getIntent().getStringExtra("name001"));
         country.setText(getIntent().getStringExtra("Counrty00"));
         state.setText(getIntent().getStringExtra("state001"));
         web_page.setText(getIntent().getStringExtra("webpage"));


    }
}