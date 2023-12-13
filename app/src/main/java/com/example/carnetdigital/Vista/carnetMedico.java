package com.example.carnetdigital.Vista;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.carnetdigital.MSGNuevaCitaMedica;
import com.example.carnetdigital.R;
import com.example.carnetdigital.Vista.menu_principal;

public class carnetMedico extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnet_medico);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue_button));
        }

        // Asigna clic listeners a los botones
        Button btnNuevaCita = findViewById(R.id.BbtnNuevaCita);
        Button btnVolver = findViewById(R.id.BbbtnVolver);

        btnNuevaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad menu_principal
                Intent intent = new Intent(carnetMedico.this, MSGNuevaCitaMedica.class);
                startActivity(intent);
                finish();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    //hola cristobal
}
