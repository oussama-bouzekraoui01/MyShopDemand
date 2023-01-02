package com.example.myshopdemand.activities;

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

import java.util.ArrayList;


public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        String[] firstName = {"Ahmed", "Ahmed", "Ahmed", "Ahmed"};
        String[] lastName = {"Ahmed", "Ahmed", "Ahmed", "Ahmed"};
        String[] phone = {"+21264862388", "+21264862388", "+21264862388", "+21264862388"};
        String[] email = {"ahmed@gmail.com", "ahmed@gmail.com", "ahmed@gmail.com", "ahmed@gmail.com"};


        ArrayList<Demande> demandes = new ArrayList<>();
        demandes.add(new Demande(1l,"2L d'Eau","Achat d'Eau", Status.PENDING, false));
        demandes.add(new Demande(2l,"1L d'Eau","Achat d'Eau", Status.PENDING, false));
        demandes.add(new Demande(3l,"6L d'Eau","Achat d'Eau", Status.PENDING, false));

        ArrayList<Client> clientArrayList = new ArrayList<>();

        for (int i = 0; i < phone.length; i++) {
            Client client = new Client(firstName[i], lastName[i], phone[i], email[i], demandes);
            clientArrayList.add(client);
        }

        ClientAdapter listAdapter = new ClientAdapter(ClientActivity.this, clientArrayList);

        ListView listView = findViewById(R.id.listViewClients);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ClientActivity.this, ClientDetailActivity.class);
//                intent.putExtra("Array_size", clientArrayList.get(i).getDemandes().size());
//                for(int j = 0; j < clientArrayList.get(i).getDemandes().size(); j++) {
//                    intent.putExtra("Title "+j, clientArrayList.get(i).getDemandes().get(j).getTitle());
//                    intent.putExtra("Description "+j, clientArrayList.get(i).getDemandes().get(j).getDescription());
//                    intent.putExtra("Checked "+j, clientArrayList.get(i).getDemandes().get(j).isChecked());
//                    //intent.putExtra("Status "+j, clientArrayList.get(i).getDemandes().get(j).getStatus());
//                    intent.putExtra("Id "+j, clientArrayList.get(i).getDemandes().get(j).getDemandeId());
//                }
                startActivity(intent);
            }
        });
    }
}