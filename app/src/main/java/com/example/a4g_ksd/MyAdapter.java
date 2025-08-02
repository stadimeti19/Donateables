package com.example.a4g_ksd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    //Data
    Context context;
    ArrayList<Item> list;

    //Constructor

    /**
     * Constructs a MyAdapter object with a given context and list of items
     * @param context
     * @param list
     */
    public MyAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = list.get(position);
        holder.name.setText(item.getName());
        holder.quantity.setText(String.valueOf(item.getCount()));
        holder.status.setText(item.getOrgStatus());

    }

    /**
     * Returns the count of the item
     * @return itemCount
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     *
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,quantity,status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.itemName);
            quantity = itemView.findViewById(R.id.amount1);
            status = itemView.findViewById(R.id.amount2);
        }
    }

}