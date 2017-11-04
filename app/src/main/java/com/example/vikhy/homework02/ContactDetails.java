package com.example.vikhy.homework02;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

/*
Created by Sai Vikhyat Parepalli
            Geeta Priyanka Janapareddy
            Group_19
*/
public class ContactDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        final Contact contact = getIntent().getExtras().getParcelable("displayContact");


        if (getIntent().getExtras() != null) {
            ImageView photo = (ImageView) findViewById(R.id.photo);
            TextView name = (TextView) findViewById(R.id.Name);
            TextView phone = (TextView) findViewById(R.id.textView13);
            TextView email = (TextView) findViewById(R.id.textView14);
            TextView company = (TextView) findViewById(R.id.textView15);
            TextView address = (TextView) findViewById(R.id.textView16);
            TextView birthday = (TextView) findViewById(R.id.textView17);
            final TextView URL = (TextView) findViewById(R.id.textView18);
            TextView fbURL = (TextView) findViewById(R.id.textView19);
            TextView nickname = (TextView) findViewById(R.id.textView20);
            TextView twitter = (TextView) findViewById(R.id.textView21);
            TextView skype = (TextView) findViewById(R.id.textView22);
            TextView youtube = (TextView) findViewById(R.id.textView23);

            //     final Contact contact= getIntent().getExtras().getParcelable("displayContact");

            Bitmap bitmap = contact.photo;
            photo.setImageBitmap(bitmap);
            String cname = contact.first + " " + contact.last;
            String cphone = contact.phone;
            String cemail = contact.email;
            String ccompany = contact.company;
            String caddress = contact.address;
            String cbday = contact.birthday;
            String cnickname = contact.nickname;
            final String cURL = contact.URL;
            final String cfbURL = contact.facebook_url;
            final String ctwitter = contact.twitter_url;
            final String cskype = contact.skype;
            final String cyoutube = contact.youtube;

            name.setText(cname);
            phone.setText(cphone);
            email.setText(cemail);
            company.setText(ccompany);
            address.setText(caddress);
            nickname.setText(cnickname);
            birthday.setText(cbday);

            URL.setText(cURL);
            URL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(cURL));
                    startActivity(intent);
                }
            });

            fbURL.setText(cfbURL);
            fbURL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(cfbURL));
                    startActivity(intent);
                }
            });

            twitter.setText(ctwitter);
            twitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(ctwitter));
                    startActivity(intent);
                }
            });

            skype.setText(cskype);
            skype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(cskype));
                    startActivity(intent);
                }
            });

            youtube.setText(cyoutube);
            youtube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(cyoutube));
                    startActivity(intent);
                }
            });
        }

    }
}
