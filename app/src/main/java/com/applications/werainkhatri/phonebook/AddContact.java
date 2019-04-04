package com.applications.werainkhatri.phonebook;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
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
    boolean contactAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.number);
        contactAdded = false;
    }

    public void addContact(View view) {
        name = t1.getText().toString();
        number = t2.getText().toString();
//        ContactList.addContact(name, number);
        ContentValues values = new ContentValues();
        values.put(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY, name);
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, number);
        getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values);
        Toast.makeText(this, "Contact Added Successfully", Toast.LENGTH_SHORT).show();
        contactAdded = true;

//        ArrayList<ContentProviderOperation> ops = new ArrayList <> ();
//
//        ops.add(ContentProviderOperation.newInsert(
//                ContactsContract.RawContacts.CONTENT_URI)
//                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
//                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
//                .build());
//
//        //------------------------------------------------------ Names
//        if (name != null) {
//            ops.add(ContentProviderOperation.newInsert(
//                    ContactsContract.Data.CONTENT_URI)
//                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
//                    .withValue(ContactsContract.Data.MIMETYPE,
//                            ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
//                    .withValue(
//                            ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
//                            name).build());
//        }
//
//        //------------------------------------------------------ Mobile Number
//        if (number != null) {
//            ops.add(ContentProviderOperation.
//                    newInsert(ContactsContract.Data.CONTENT_URI)
//                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
//                    .withValue(ContactsContract.Data.MIMETYPE,
//                            ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
//                    .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, number)
//                    .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
//                            ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
//                    .build());
//        }
//
//        try {
//            getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
//            Toast.makeText(this, "Contact Added Successfully", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//        }

//        Intent i = new Intent(this, PhoneBookDirectory.class);
////        Bundle b = new Bundle();
////        b.putString("name", name);
////        b.putString("number", number);
////        i.putExtras(b);
////        startActivity(i);

        startActivity(new Intent(this, PhoneBookDirectory.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(contactAdded)
            finish();
    }

    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
