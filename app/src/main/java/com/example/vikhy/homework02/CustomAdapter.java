/*
Created by Sai Vikhyat Parepalli
            Geeta Priyanka Janapareddy
            Group_26
*/
package com.example.vikhy.homework02;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
Created by Sai Vikhyat Parepalli
            Geeta Priyanka Janapareddy
            Group_19
*/

public class CustomAdapter extends BaseAdapter {

    private Context context;
    ArrayList<Contact> allContact = new ArrayList<Contact>();


    public void add(ArrayList<Contact> c) {
        allContact.addAll(c);
        notifyDataSetChanged();
    }

    public CustomAdapter(Context context, ArrayList<Contact> allContact) {
        this.context = context;
        this.allContact = allContact;
    }

    @Override
    public int getCount() {
        return allContact.size();
    }

    @Override
    public Object getItem(int position) {
        return allContact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = allContact.get(position);
        if (convertView == null)

            convertView = View.inflate(context, R.layout.single_contact, null);


        TextView fn = (TextView) convertView.findViewById(R.id.textViewFN);
        TextView ln = (TextView) convertView.findViewById(R.id.textViewLN);
        TextView ph = (TextView) convertView.findViewById(R.id.textViewNO);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageViewsc);

        fn.setText(contact.first);
        ln.setText(contact.last);
        ph.setText(contact.phone);
        img.setImageBitmap(contact.photo);

        return convertView;
    }
}
