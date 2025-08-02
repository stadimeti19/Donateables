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
public class OrgMatchAdapter extends RecyclerView.Adapter<OrgMatchAdapter.MyViewHolder> {

    //Data
    Context context;
    ArrayList<Match> list;

    //Constructor
    /**
     * Constructs an OrgMatchAdapter with a given context and list
     */
    public OrgMatchAdapter(Context context, ArrayList<Match> list) {
        this.context = context;
        this.list = list;
    }

    /**
     *
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.orgmatch,parent,false);
        return new MyViewHolder(v);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Match match = list.get(position);
        holder.name.setText(match.getUser().getName());
    }

    /**
     * Returns the count of the Item
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
        TextView name;

        public MyViewHolder(@NonNull View matchView) {
            super(matchView);

            name = matchView.findViewById(R.id.itemName);
        }
    }

}
