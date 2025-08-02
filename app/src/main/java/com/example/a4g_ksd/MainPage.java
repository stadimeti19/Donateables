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
public class MainPage extends AppCompatActivity {
    /**
     * Constructs the onCreate object when the page is initialized
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent intent = new Intent(this, AddItemToList.class);
        startActivity(intent);
    }

    /**
     * Navigates the user to the moveToMatch page
     * @param v
     */
    public void moveToMatchPage(View v) {
        Intent intent = new Intent(this, MatchPage.class);
        startActivity(intent);
    }

    /**
     * Navigates user to the Organization Requests page
     * @param v
     */
    public void ViewOrgReq(View v) {
        Intent intent = new Intent(this, ViewOrgReq.class);
        startActivity(intent);
    }

    /**
     * Navigates the user to the UserOffers page
     * @param v
     */
    public void UserOffers(View v) {
        Intent intent = new Intent(this, UserOffers.class);
        startActivity(intent);
    }
}