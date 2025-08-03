package com.example.a4g_ksd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class MainActivity extends AppCompatActivity {
    private boolean boolin;
    static User user ;
    static Organization org;

    //karisma was here
    /**
     * Constructs the onCreate object when the page is initialized
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    /**
     * Directs user to specified page on the start of the page
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Conversts the ItemName to a string format to return to user
     * @return nameStr
     */
    private String nameToString(){
        EditText name = findViewById(R.id.enterNameEditText);
        return name.getText().toString();
    }

    /**
     * Converts the location to a string format to return to user
     * @return locationStr
     */
    private String locationToString(){
        EditText location = findViewById(R.id.enterAddressEditText);
        return location.getText().toString();
    }

    /**
     * Converts mail to string format to return to user
     * @return mailStr
     */
    private String mailToString(){
        EditText mail = findViewById(R.id.enterEmailEditText);
        return mail.getText().toString();
    }

    /**
     * Sets the user to the view
     * @param v
     */
    public void setUser(View v) {

        user = new User(nameToString(), locationToString(), mailToString());


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users/general");
        DatabaseReference childRef1 = myRef.child(nameToString());
        childRef1.push().setValue(user);

        Toast.makeText(getApplicationContext(),user.getUserName(),Toast.LENGTH_SHORT).show();

    }

    /**
     * Sets the Organization to the view
     * @param v
     */
    public void setOrg(View v) {
        org = new Organization(nameToString(), locationToString(), mailToString());
        Toast.makeText(getApplicationContext(),"Set Org",Toast.LENGTH_SHORT).show();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users/organizations");
        DatabaseReference childRef1 = myRef.child(nameToString());
        childRef1.push().setValue(org);

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
     * Navigates the user to the Settings page
     * @param v
     */
    public void moveToSettings(View v) {
        Intent intent = new Intent(this, SettingsProfile.class);
        startActivity(intent);
    }

    /**
     * Navigates the user to the ViewOrgReq page
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

    /**
     * Moves to main page determined whether it is a user or an organization
     * @param v
     */
    public void moveToMainPage(View v) {
        if(boolin) {
            setUser(v);
            Intent intent = new Intent(this, MainPage.class);
            startActivity(intent);
        }
        else {
            setOrg(v);
            Intent intent = new Intent(this, MainOrgPage.class);
            startActivity(intent);
        }
    }

    /**
     * Checks which button is clicked to specify if it is a user or an organization
     * @param view
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        int viewId = view.getId();

        if (viewId == R.id.genUserRadio) {
            if (checked) {
                boolin = true;
            }
        } else if (viewId == R.id.orgRadio) {
            if (checked) {
                boolin = false;
            }
        }
    }
}
