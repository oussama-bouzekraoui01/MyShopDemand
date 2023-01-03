package com.example.myshopdemand.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myshopdemand.R;
import com.example.myshopdemand.adapters.ClientAdapter;
import com.example.myshopdemand.models.Client;
import com.example.myshopdemand.models.Demande;
import com.example.myshopdemand.models.Status;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


public class ClientActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        String[] firstName = {"Ahmed", "Khalid", "Samir", "Ali"};
        String[] lastName = {"Ahmed", "Khalidi", "Rachidi", "Alaoui"};
        String[] phone = {"+21264862388", "+21264862388", "+21264862388", "+21264862388"};
        String[] email = {"ahmed@gmail.com", "khalid@gmail.com", "samir@gmail.com", "ali@gmail.com"};


        HashMap<String, Demande> demandes = new HashMap<>();
        demandes.put("1",new Demande(1l,"2L d'Eau", false));
        demandes.put("2",new Demande(2l,"1L d'Eau", false));
        demandes.put("3", new Demande(3l,"6L d'Eau", false));

        ArrayList<Client> clientArrayList = new ArrayList<>();


        for (int i = 0; i < phone.length; i++) {
            Client client = new Client(i,firstName[i], lastName[i], phone[i], email[i], demandes);
            clientArrayList.add(client);
        }



        ClientAdapter listAdapter = new ClientAdapter(ClientActivity.this, clientArrayList);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Client");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    final Client client = dataSnapshot.getValue(Client.class);
                    clientArrayList.add(client);
                }
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ListView listView = findViewById(R.id.listViewClients);
        listView.setAdapter(listAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ClientActivity.this, ClientDetailActivity.class);

                intent.putExtra("full_name", clientArrayList.get(i).getFirstName() + clientArrayList.get(i).getLastName());
                intent.putExtra("email", clientArrayList.get(i).getEmail());
                intent.putExtra("phone", clientArrayList.get(i).getPhone());

                startActivity(intent);
            }
        });
    }

}