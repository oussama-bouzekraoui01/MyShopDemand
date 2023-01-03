package com.example.myshopdemand.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myshopdemand.R;
import com.example.myshopdemand.models.Client;

import java.util.ArrayList;

public class ClientAdapter extends ArrayAdapter<Client> {


    public ClientAdapter(Context context, ArrayList<Client> clientArrayList) {
        super(context, R.layout.client_item, clientArrayList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Client client = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.client_item, parent, false);
        }

        ImageView image = convertView.findViewById(R.id.imageViewProfile);
        TextView fullName = convertView.findViewById(R.id.textViewFullName);
        TextView textDemande = convertView.findViewById(R.id.textViewDemandes);

        int id = R.drawable.image_profile;

        image.setImageResource(id);
        fullName.setText(client.getFirstName() + " " + client.getLastName());
        textDemande.setText("Test");

        return convertView;

    }
}
