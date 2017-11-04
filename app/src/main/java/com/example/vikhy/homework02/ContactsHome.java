package com.example.vikhy.homework02;

/*
Created by Sai Vikhyat Parepalli
            Geeta Priyanka Janapareddy
            Group_19
*/

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;

public class ContactsHome extends AppCompatActivity {

    ArrayList<Contact> contactArrayList = new ArrayList<>();

    public static String ACTION = "";
    //String whichTo ="";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 200:
                if (data.getExtras() != null) {
                    Contact c = (Contact) data.getExtras().get("contactClass");
                    //whichTo = data.getExtras().getString("default");
                    contactArrayList.add(c);
                }
                break;
            case 300:
                Bundle extras = data.getExtras();
                Contact old = (Contact) extras.getParcelable("old");
                Contact nu = extras.getParcelable("new");

                contactArrayList.add(nu);

                /*if(contactArrayList.get(i).equals(old))
                    contactArrayList.remove(i);*/

                //contactArrayList.remove(old);
                //  contactArrayList.remove(contactArrayList.indexOf(old));          Equals func not working(hence manual comparision)

                for (int i = 0; i < contactArrayList.size(); i++)
                    if (contactArrayList.get(i).first.equals(old.first)
                            && contactArrayList.get(i).last.equals(old.last)
                            && contactArrayList.get(i).phone.equals(old.phone)
                            && contactArrayList.get(i).birthday.equals(old.birthday)
                            && contactArrayList.get(i).email.equals(old.email)
                            && contactArrayList.get(i).address.equals(old.address)
                            && contactArrayList.get(i).company.equals(old.address)
                            && contactArrayList.get(i).company.equals(old.company)
                            && contactArrayList.get(i).facebook_url.equals(old.facebook_url)
                            && contactArrayList.get(i).nickname.equals(old.nickname)
                            && contactArrayList.get(i).youtube.equals(old.youtube)
                            && contactArrayList.get(i).skype.equals(old.skype)
                            && contactArrayList.get(i).twitter_url.equals(old.twitter_url)
                            && contactArrayList.get(i).photo.sameAs(old.photo)
                            )

                        contactArrayList.remove(i);
                break;
            case 400:

                if (resultCode == 400) {
                    Contact delete = (Contact) data.getExtras().get("contactDelete");
                    for (int i = 0; i < contactArrayList.size(); i++)
                        if (contactArrayList.get(i).first.equals(delete.first)
                                && contactArrayList.get(i).last.equals(delete.last)
                                && contactArrayList.get(i).phone.equals(delete.phone)
                                && contactArrayList.get(i).birthday.equals(delete.birthday)
                                && contactArrayList.get(i).email.equals(delete.email)
                                && contactArrayList.get(i).address.equals(delete.address)
                                && contactArrayList.get(i).company.equals(delete.address)
                                && contactArrayList.get(i).company.equals(delete.company)
                                && contactArrayList.get(i).facebook_url.equals(delete.facebook_url)
                                && contactArrayList.get(i).nickname.equals(delete.nickname)
                                && contactArrayList.get(i).youtube.equals(delete.youtube)
                                && contactArrayList.get(i).skype.equals(delete.skype)
                                && contactArrayList.get(i).twitter_url.equals(delete.twitter_url)
                                && contactArrayList.get(i).photo.sameAs(delete.photo)
                                )
                            contactArrayList.remove(i);

                }
                break;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_home);

        findViewById(R.id.buttonCreateNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsHome.this, CreateNewContact.class);
                startActivityForResult(intent, 200);
            }
        });
        findViewById(R.id.buttonDisplayContact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "DISPLAY";
                Intent intent = new Intent(ContactsHome.this, DisplayContacts.class);
                intent.putExtra("contactList", contactArrayList);

                startActivity(intent);
            }
        });
        findViewById(R.id.buttonDeleteContact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "DELETE";
                Intent intent = new Intent(ContactsHome.this, DisplayContacts.class);
                intent.putExtra("contactList", contactArrayList);
                startActivityForResult(intent, 400);
            }
        });
        findViewById(R.id.buttonEditContact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "EDIT";
                Intent intent = new Intent(ContactsHome.this, DisplayContacts.class);
                intent.putExtra("contactList", contactArrayList);
                startActivityForResult(intent, 300);
            }
        });

        findViewById(R.id.buttonFinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactsHome.this.onDestroy();
                System.exit(0);
                android.os.Process.killProcess(android.os.Process.myPid());
               /* ActivityManager am = (ActivityManager) getSystemService(Activity.ACTIVITY_SERVICE);
                am.killBackgroundProcesses("com.example.vikhy.homework02");
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
*/
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
