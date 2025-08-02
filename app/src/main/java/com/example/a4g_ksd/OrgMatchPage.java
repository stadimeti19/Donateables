package com.example.a4g_ksd;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class OrgMatchPage extends AppCompatActivity {

    DatabaseReference genRef;
    DatabaseReference orgRef;

    ArrayList<Match> matches;
    RecyclerView recyclerView;
    MatchAdapter adapter;
    ArrayList<Item> userItems;
    ArrayList<Item> orgItems;

    /**
     * Constructs the onCreate object when the page is initialized
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermatch);

        orgRef = FirebaseDatabase.getInstance().getReference("users/organizations/" + MainActivity.org.getUserName() + "/items");
        genRef = FirebaseDatabase.getInstance().getReference("items/general");

        userItems = new ArrayList<Item>();
        orgItems = new ArrayList<Item>();

        recyclerView = findViewById(R.id.matchesRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        matches = new ArrayList<>();
        adapter = new MatchAdapter(this, matches);
        recyclerView.setAdapter(adapter);


        genRef.addValueEventListener(new ValueEventListener() {
            /**
             *
             * @param snapshot
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Item item = dataSnapshot.getValue(Item.class);
                    userItems.add(item);
                    Log.d("MatchUsers: ", item.getName());

                }
                matches = Match.getMatchList(userItems, orgItems);
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

        orgRef.addValueEventListener(new ValueEventListener() {
            /**
             *
             * @param snapshot
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Item item = dataSnapshot.getValue(Item.class);
                    orgItems.add(item);
                    Log.d("MatchOrgs: ", item.getName());

                }
                Log.d("MatchOrgsSize: ", orgItems.size() + "");
                matches = Match.getMatchList(userItems, orgItems);
                adapter = new MatchAdapter(getApplicationContext(), matches);
                recyclerView.setAdapter(adapter);
                Log.d("Matcheslist: ", matches + "");

            }

            /**
             *
             * @param error
             */
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        Log.d("MatchBoth: ", userItems + " " + orgItems);
    }
}
