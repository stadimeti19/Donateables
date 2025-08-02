package com.example.a4g_ksd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class SettingsProfile extends AppCompatActivity {
    /**
     * Constructs the onCreate object when the page is initialized
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_profile);
        TextView email = findViewById(R.id.getEmailSettings);
        TextView addy = findViewById(R.id.getAddressSettings);
        TextView instr = findViewById(R.id.getInstrSettings);
        Intent intent = getIntent();
        final Controller controller = (Controller) getApplicationContext();
        addy.setText(" " + controller.getUser().getAddress());
        email.setText(" " + controller.getUser().getEmail());
        //instr.setText(" " + controller.getUser().getInstr());
    }

}