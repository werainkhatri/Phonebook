package com.applications.werainkhatri.phonebook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {

    TextView t1;
    TextView t2;
    String name = "";
    String number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.number);
    }


    public void addContact(View view) {
        name = t1.getText().toString();
        number = t2.getText().toString();
        ContactList.addContact(name, number);
        Toast.makeText(this, "Contact Added Successfully", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, PhoneBookDirectory.class);
        startActivity(i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void back(View view) {
        Intent i = new Intent(this, PhoneBookDirectory.class);
        startActivity(i);
    }
}
