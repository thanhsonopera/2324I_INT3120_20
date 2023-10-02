package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Contact extends AppCompatActivity {

    private static final int REQUEST_CONTACT_PERMISSION = 1001;
    ListView lv;
    ArrayList<ContactInfor> ds;
    ArrayAdapter<ContactInfor> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        addControls();
        showAllContact();
        deleteContact();
//        addContact();
    }
    //ContactsContract -> ContactsContract.Contacts.xxx, ContactsContract.CommonDataKinds.xxx, CommonDataKinds.Data.xxx
    //Add:  RAW_CONTACT_ID  -> ArrayList<ContentProviderOperation> khi đó sẽ gồm nhiều giá trị trùng RAW_CONTACT_ID
    //Get: dữ liêu -> GroupBy các giá trị cùng RAW_CONTACT_ID -> lấy các giá trị khác null  đặt trong adapter
    //Update dữ liệu -> Xóa dữ liệu đó -> Add dữ liệu mới ->Get data In ra
    public void showAllContact() {
        Uri uri = ContactsContract.Data.CONTENT_URI;

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        ds.clear();
        while (cursor.moveToNext()) {
            String col = ContactsContract.Data.RAW_CONTACT_ID;
            String columName = ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME;
            String columPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int trace = cursor.getColumnIndex(col);
            Log.d("Trace", "showAllContact: " + cursor.getString(trace));
            int pN = cursor.getColumnIndex(columName);
            int pP = cursor.getColumnIndex(columPhone);
            /////////////////////////////
//            String[] projection = {ContactsContract.CommonDataKinds.Phone.CONTACT_ID};
//            String selection = ContactsContract.Contacts.DISPLAY_NAME + " = ? AND "
//                    + ContactsContract.CommonDataKinds.Phone.NUMBER + " = ?";
//            String[] selectionArgs = {cursor.getString(pN), cursor.getString(pP)};
//            Cursor query = getContentResolver().query(uri, projection, selection, selectionArgs, null);
//            if (query != null && query.moveToFirst()) {
//                do {
//                    @SuppressLint("Range") String contactId = query.getString(query.getColumnIndex(ContactsContract.Data.CONTACT_ID));
//
//                    Log.d("Contact", "CONTACT_ID: " + contactId);
//                } while (query.moveToNext());
//            }
            /////////////////////////////
            ContactInfor newContact = new ContactInfor(cursor.getString(pN), cursor.getString(pP));
            ds.add(newContact);
            ad.notifyDataSetChanged();
        }


//        Uri uri = ContactsContract.Data.CONTENT_URI;
//
//
//        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
//        ds.clear();
//        while (cursor.moveToNext()) {
//            @SuppressLint("Range") int rawContactId = cursor.getInt(cursor.getColumnIndex(ContactsContract.Data.RAW_CONTACT_ID));
//            Log.d("Cursor Data", "rawContactId: " + rawContactId);
//            // Thực hiện xử lý với rawContactId và count tương ứng
//        }

    }
    public void addContact() {
//        String account_type = null;
//        String account_name = null;
//
//        ContentValues values = new ContentValues();
//        values.put(ContactsContract.RawContacts.ACCOUNT_TYPE, account_type);
//        values.put(ContactsContract.RawContacts.ACCOUNT_NAME, account_name);
//        Uri rawContactUri =
//                getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values);
//        long rawContactId = ContentUris.parseId(rawContactUri);
//
//
//        values.clear();
//        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
//        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
//        values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, "xinchao");
////        values.put(ContactsContract.CommonDataKinds.Phone.LABEL, "Sarah");
//        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
//        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "91111111");
//
//        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
        int rawContactId = 92; // Lấy rawContactId từ nguồn dữ liệu khác

        ArrayList<ContentProviderOperation> operations = new ArrayList<>();
        operations.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts._ID, rawContactId)
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                .build());

// Tạo nội dung cho StructuredName
        ContentProviderOperation nameOperation = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValue(ContactsContract.Data.RAW_CONTACT_ID, rawContactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, "Chao2")
                .build();
        operations.add(nameOperation);

// Tạo nội dung cho Phone
        ContentProviderOperation phoneOperation = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValue(ContactsContract.Data.RAW_CONTACT_ID, rawContactId)
                .withValue(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, "012018387")
                .build();
        operations.add(phoneOperation);

//        operations.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
//                .withSelection(
//                        ContactsContract.Data.RAW_CONTACT_ID + "=? AND " +
//                                ContactsContract.RawContacts.Data.MIMETYPE + "=?",
//                        new String[]{String.valueOf(rawContactId), ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE})
//                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, "999999999")
//                .withYieldAllowed(true)
//                .build());



// Thực hiện các hoạt động chèn thông qua ContentResolver
        try {
            ContentProviderResult[] results = getContentResolver().applyBatch(ContactsContract.AUTHORITY, operations);
            if (results != null && results.length > 0) {
                ContentProviderResult result = results[0]; // Assuming you have only one update operation

                // Check the number of rows affected (should be 1 if the update was successful)
                int count = result.count;
                if (count == 1) {
                    Log.d("999", "addContact: ");
                    // The update was successful
                    // You can add your success handling logic here
                } else {
                    // The update was not successful
                    // Handle the failure case here
                }
            }

        } catch (Exception e) {
            // Xử lý lỗi
        }
    }
    public void deleteContact() {
        Uri uri = ContactsContract.Data.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        while (cursor.moveToNext()) {
            int columnIdIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
          String contactId = cursor.getString(columnIdIndex);
            int columnIdIndex1 = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID);
            String contactId1 = cursor.getString(columnIdIndex1);
           Log.d("1", "showAllContact: " + contactId + " " + contactId1);
//            String myData = "content://contacts/people/";
//            Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
//           startActivity(it);
            String selection = ContactsContract.CommonDataKinds.Phone._ID + " = ? AND "
                    + ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?";
            String[] selectionArgs = new String[] {contactId1, contactId};

            int deletedRows = getContentResolver().delete(uri, selection, selectionArgs);
            Log.d("2", "showAllContact: " + deletedRows);
       }
    }
    public void addControls() {
        lv = findViewById(R.id.Contact);
        ds = new ArrayList<>();
        ad = new ArrayAdapter<>(Contact.this, android.R.layout.simple_list_item_1, ds);
        lv.setAdapter(ad);
    }
}