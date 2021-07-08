package com.example.inter_sporty_guru;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Adapetr_data extends RecyclerView.Adapter<Adapetr_data.ViewHolder>{

    List<collage_data> name_ur;
    Context con_Ada;
    //private collage_data name_ur;
    //private Context con;
    // RecyclerView recyclerView;
    private Context mContext;
    public Adapetr_data(Context con_Ada,List<collage_data> data) {
        this.con_Ada=con_Ada;
        name_ur=data;

    }



    /*String name_ur;

    // RecyclerView recyclerView;
    public Adapetr_data(String name) {
        this.name_ur=name;
    }*/
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.row_element, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      /*  final Adapetr_data myListData = listdata[position];
        //holder.textView.setText(listdata[position].getDescription());
       //holder.imageView.setImageResource(listdata[position].getImgId());
        holder.textView.setText(name_ur[1]).getDescription();*/

        holder.textView.setText((CharSequence) name_ur.get(position).getColl_name());
        Log.d("check008", "onResponse: "+name_ur.get(position).getColl_name());

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(v.getContext(),"click on item: "+name_ur, Toast.LENGTH_LONG).show();


                Intent myIntent = new Intent(con_Ada,MainActivity2.class);

                Toast.makeText(v.getContext(),"click on item: ", Toast.LENGTH_LONG).show();
                myIntent.putExtra("Counrty00", name_ur.get(position).coll_country);
                myIntent.putExtra("name001", name_ur.get(position).coll_name);
                myIntent.putExtra("state001", name_ur.get(position).coll_state);
                con_Ada.startActivity(myIntent);


            }
        });

/*        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: ", Toast.LENGTH_LONG).show();
            }
        });*/
    }



    @Override
    public int getItemCount() {
        return 20;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.un_name);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.recyclerView);
        }
    }
}