package com.applications.werainkhatri.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.applications.werainkhatri.phonebook.listClasses.RvAdapter;

import java.util.ArrayList;
import java.util.List;

import toan.android.floatingactionmenu.FloatingActionButton;

public class PhoneBookDirectory extends AppCompatActivity {

    private RvAdapter adapter;
    private RecyclerView recyclerView;
//    private List<Contact> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book_directory);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setIcon(R.drawable.fab_bg_normal);
        adapter = new RvAdapter(this);
        recyclerView = findViewById(R.id.rv);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        adapter = new RvAdapter(this);
        adapter.setDataList(ContactList.getContacts());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void moveToAdd(View view) {
        startActivity(new Intent(this, AddContact.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
