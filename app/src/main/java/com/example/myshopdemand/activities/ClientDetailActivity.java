package com.example.myshopdemand.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myshopdemand.R;

public class ClientDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);

        TextView fullName = findViewById(R.id.fullName1);
        TextView email = findViewById(R.id.email1);
        TextView phone = findViewById(R.id.phone1);

        Intent intent = getIntent();

        fullName.setText(intent.getStringExtra("full_name"));
        email.setText(intent.getStringExtra("email"));
        phone.setText(intent.getStringExtra("phone"));

        Button btn = findViewById(R.id.buttonDetail);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientDetailActivity.this, DemandeActivity.class);
                startActivity(intent);
            }
        });





    }
}