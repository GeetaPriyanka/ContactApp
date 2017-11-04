/*
Created by Sai Vikhyat Parepalli
            Geeta Priyanka Janapareddy
            Group_26
*/
package com.example.vikhy.homework02;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/*
Created by Sai Vikhyat Parepalli
            Geeta Priyanka Janapareddy
            Group_19
*/

public class DisplayContacts extends AppCompatActivity {

    ArrayList<Contact> contacts;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 300) {
            Bundle ex = data.getExtras();
            Contact old = ex.getParcelable("old");
            Contact nu = ex.getParcelable("new");

            Intent intent = new Intent();
            Bundle extras = new Bundle();
            extras.putParcelable("old", old);
            extras.putParcelable("new", nu);
            intent.putExtras(extras);

            setResult(300, intent);
            //  startActivity(intent);
            finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_contacts_list);
        contacts = new ArrayList<Contact>();

        if (getIntent().getExtras() != null) {


            contacts = (ArrayList<Contact>) getIntent().getExtras().get("contactList");


            final ListView listView = (ListView) findViewById(R.id.dynamicListView);
            Adapter adapter = new CustomAdapter(this, contacts);
            listView.setAdapter((ListAdapter) adapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    final Contact contact = (Contact) listView.getItemAtPosition(position);
                    switch (ContactsHome.ACTION) {

                        case "DISPLAY":
                            Intent intent = new Intent(DisplayContacts.this, ContactDetails.class);
                            intent.putExtra("displayContact", contact);
                            startActivity(intent);

                            break;
                        case "EDIT":
                            Intent intent1 = new Intent(DisplayContacts.this, EditContact.class);
                            intent1.putExtra("displayContact", contact);
                            startActivityForResult(intent1, 300);
                            break;
                        case "DELETE":

                            AlertDialog.Builder builder = new AlertDialog.Builder(DisplayContacts.this);
                            builder.setTitle("Delete")
                                    .setMessage("Are you sure?")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            //Log.d("Demo", "Clicked OK");
                                            Intent intent = new Intent(/*DisplayContacts.this, ContactsHome.class*/);
                                            intent.putExtra("contactDelete", contact);
                                            setResult(400, intent);
                                            //  startActivity(intent);
                                            finish();
                                        }
                                    })
                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            Log.d("Demo", "Cancel");
                                            dialog.dismiss();
                                        }
                                    });
                            final AlertDialog alert = builder.create();
                            alert.show();
                            break;
                    }
                }
            });


        }

    }


}