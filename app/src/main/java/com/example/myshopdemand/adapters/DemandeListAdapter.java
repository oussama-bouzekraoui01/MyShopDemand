package com.example.myshopdemand.adapters;

import android.annotation.SuppressLint;
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
import com.example.myshopdemand.models.Demande;

public class DemandeListAdapter extends ArrayAdapter<Demande> {

    Context adapterContext;
    int adapterResource;
    Demande[] demandes;
    boolean checked;

    public DemandeListAdapter(@NonNull Context context, int resource, @NonNull Demande[] objects) {
        super(context, resource, objects);
        adapterContext = context;
        adapterResource = resource;
        demandes = objects;
    }


    @Override
    public Demande getItem(int position) {
        return super.getItem(position);
    }


    @SuppressLint("ResourceAsColor")

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        LayoutInflater rowInflater = LayoutInflater.from(adapterContext);
        row = rowInflater.inflate(adapterResource,parent,false);

        ImageView image = row.findViewById(R.id.imageView20);
        TextView textViewTitreProduit = row.findViewById(R.id.textViewTitreProduit);

        Demande c = demandes[position];

        image.setImageResource(R.drawable.grocery);
        textViewTitreProduit.setText(c.getTitle());



        return row;
    }
}
