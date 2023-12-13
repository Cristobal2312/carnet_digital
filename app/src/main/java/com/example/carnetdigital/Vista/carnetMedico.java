package com.example.carnetdigital.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.carnetdigital.R;
import com.example.carnetdigital.Vista.menu_principal;

public class carnetMedico extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnet_medico);

        // Asigna clic listeners a los botones
        Button btnNuevaCita = findViewById(R.id.BbtnNuevaCita);
        Button btnVolver = findViewById(R.id.BbbtnVolver);

        btnNuevaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad menu_principal
                Intent intent = new Intent(carnetMedico.this, menu_principal.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad menu_principal
                Intent intent = new Intent(carnetMedico.this, menu_principal.class);
                startActivity(intent);
            }
        });
    }
    //hola cristobal
}
