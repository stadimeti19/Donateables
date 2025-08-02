package com.example.a4g_ksd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class ViewDonateables extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference ref;
    MyAdapter adapter;
    ArrayList<Item> list;

    /**
     * Constructs the onCreate object when the page is initialized
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_offers);

        recyclerView = findViewById(R.id.requestsRecycler2);
        ref = FirebaseDatabase.getInstance().getReference("items/general");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        ref.addValueEventListener(new ValueEventListener() {
            /**
             *
             * @param snapshot
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Item item = dataSnapshot.getValue(Item.class);
                    list.add(item);
                }
                adapter.notifyDataSetChanged();
            }

            /**
             *
             * @param error
             */
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}