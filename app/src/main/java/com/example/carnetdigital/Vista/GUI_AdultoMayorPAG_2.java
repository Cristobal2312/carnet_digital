package com.example.carnetdigital.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carnetdigital.R;

public class GUI_AdultoMayorPAG_2 extends AppCompatActivity {

    Button VbtnVolver, VbtnListaTareas, VbtnUbicacion, VbtnCarnetMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_adulto_mayor_pag2);

        VbtnVolver = (Button) findViewById(R.id.VbtnVolver);
        VbtnListaTareas = (Button) findViewById(R.id.VbtnListaTareas);
        VbtnUbicacion = (Button) findViewById(R.id.VbtnUbicacion);
        VbtnCarnetMedico = (Button) findViewById(R.id.VbtnCarnetMedico);

        VbtnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GUI_AdultoMayorPAG_2.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        VbtnCarnetMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GUI_AdultoMayorPAG_2.this, carnetMedico.class);
                startActivity(intent);
            }
        });


        VbtnListaTareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GUI_AdultoMayorPAG_2.this, Lista_Tarea.class);
                startActivity(intent);
            }
        });


        VbtnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GUI_AdultoMayorPAG_2.this, GUI_AdultoMayor.class);
                startActivity(intent);
            }
        });



    }
}