package com.example.myshopdemand.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.myshopdemand.R;
import com.example.myshopdemand.adapters.DemandeListAdapter;
import com.example.myshopdemand.models.Demande;
import com.example.myshopdemand.models.Status;

import java.util.HashSet;
import java.util.Set;

public class DemandeActivity extends AppCompatActivity {


    Demande d1 = new Demande(1l,"2L Eau Minéral", false);
    Demande d2 = new Demande(2l,"3L Lait", false);
    Demande d3 = new Demande(3l,"30 Oeufs", false);
    Demande d4 = new Demande(4l,"2Kg Pomme", false);
    Demande d5 = new Demande(1l,"1Kg Banane", false);
    Demande d6 = new Demande(2l,"Biscuit", false);
    Demande d7 = new Demande(3l,"Frommage", false);
    Demande d8 = new Demande(4l,"1kg Viande", false);


    Demande[] demandes = {d1,d2,d3,d4,d5,d6,d7,d8};;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demande);


        ListView listViewDemandes = findViewById(R.id.ListView100);



        int id = R.layout.demande_item;
        DemandeListAdapter adapter = new DemandeListAdapter(getApplicationContext(),id,demandes);
        listViewDemandes.setAdapter(adapter);


        Set<Demande> uncheckedDemand = new HashSet<>();

        listViewDemandes.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                boolean checked = demandes[i].isChecked();

                if (!checked) {
                    demandes[i].setChecked(true);
                    view.setBackgroundColor(getResources().getColor(R.color.purple_200));

                } else {
                    view.setBackground(getResources().getDrawable(R.drawable.layout_bg));
                    demandes[i].setChecked(false);
                }

                for (Demande d : demandes) {
                    if(d.isChecked()) {
                        uncheckedDemand.add(d);
                    }
                }

            }
        });

        Button btn = findViewById(R.id.buttonValider);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:+212645874562");

                Intent intent = new Intent(Intent.ACTION_SEND, uri);
                intent.putExtra("sms_body", "Vos achats sont dans l'état en cours, Vous allez recevoir tes achats dans 2H");
                //intent.putExtra(Intent.EXTRA_PHONE_NUMBER, "+21216551487");

                startActivity(intent);
            }
        });

        Button btn1 = findViewById(R.id.buttonAnnuler);





        StringBuilder sb = new StringBuilder();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (Demande d : uncheckedDemand) {
                    sb.append(d.getTitle());
                    sb.append("\n");
                }

                Uri uri = Uri.parse("smsto:+212645874562");

                Intent intent = new Intent(Intent.ACTION_SEND, uri);
                intent.putExtra("sms_body", "Les achats suivants sont hors stock : \n" + sb);

                System.out.println(sb);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        for (int i = 0; i < demandes.length; i++) {
            if(demandes[i].isChecked())
                outState.putInt(""+i, 1);
            else
                outState.putInt(""+i, 0);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int id = R.layout.demande_item;
        View view = (LinearLayout) findViewById(R.layout.demande_item);
        for (int i = 0; i < demandes.length; i++) {
            int j = savedInstanceState.getInt("" + i);
            if (j == 1) {
                view.setBackgroundColor(getResources().getColor(R.color.purple_200));
            }

        }

    }
//

}
