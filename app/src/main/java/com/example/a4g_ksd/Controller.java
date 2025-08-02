package com.example.a4g_ksd;

import android.app.Application;
import android.widget.EditText;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class Controller extends Application {
    User testUser = new User("name", "location", "mail");

    /**
     *Returns the User object
     * @return testUser object
     */
    public User getUser() {
        return testUser;
    }


}
