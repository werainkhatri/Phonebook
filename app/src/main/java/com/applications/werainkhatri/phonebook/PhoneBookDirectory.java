package com.applications.werainkhatri.phonebook;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;

import com.applications.werainkhatri.phonebook.listClasses.RvAdapter;

import java.util.ArrayList;
import java.util.List;

import toan.android.floatingactionmenu.FloatingActionButton;

public class PhoneBookDirectory extends AppCompatActivity {

    private RvAdapter adapter;
    private RecyclerView recyclerView;
    private List<Contact> contactList = new ArrayList<>();
    String mProj[] = new String[]{
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY,
            ContactsContract.CommonDataKinds.Phone.NUMBER
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book_directory);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setIcon(R.drawable.fab_bg_normal);
        adapter = new RvAdapter(this);
        recyclerView = findViewById(R.id.rv);
        EnableRuntimePermission();
        getData(contactList);
        setUpRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getData(contactList);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        adapter = new RvAdapter(this);
        adapter.setDataList(contactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void moveToAdd(View view) {
        startActivity(new Intent(this, AddContact.class));
    }

    public void getData(List<Contact> contactList) {
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, mProj, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY);
        if(cursor != null && cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                contactList.add(new Contact(cursor.getString(0), cursor.getString(1)));
            }
        }
        cursor.close();

    }

    public void EnableRuntimePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                PhoneBookDirectory.this,
                android.Manifest.permission.READ_CONTACTS))
        {
        } else {
            ActivityCompat.requestPermissions(PhoneBookDirectory.this,new String[]{
                    Manifest.permission.READ_CONTACTS}, 1);
        }
    }


}
