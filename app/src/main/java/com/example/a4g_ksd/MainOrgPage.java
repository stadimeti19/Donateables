package com.example.a4g_ksd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class MainOrgPage extends AppCompatActivity {
    /**
     * Constructs the onCreate object when the page is initialized
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_orgpage);
    }

    /**
     * Directs user to specified page on the start of the page
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Navigates the user to the AddItemToList page
     * @param v
     */
    public void moveToAddItemToList(View v) {
        Intent intent = new Intent(this, addItemAsOrg.class);
        startActivity(intent);
    }

    /**
     * Navigates the user to the moveToMatch page
     * @param v
     */
    public void moveToMatchPage(View v) {
        Intent intent = new Intent(this, OrgMatchPage.class);
        startActivity(intent);
    }

    /**
     * Navigates user to the Organization Requests page
     * @param v
     */
    public void OrgReq(View v) {
        Intent intent = new Intent(this, OrgRequests.class);
        startActivity(intent);
    }

    /**
     * Navigates user to the ViewDonateables page
     * @param v
     */
    public void toViewDonateables(View v) {
        Intent intent = new Intent(this, ViewDonateables.class);
        startActivity(intent);
    }
}
