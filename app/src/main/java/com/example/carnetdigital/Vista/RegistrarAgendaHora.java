package com.example.carnetdigital.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.carnetdigital.R;

public class RegistrarAgendaHora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_agenda_hora);

        EditText txtMedico = findViewById(R.id.txtTerapeuta);
        EditText txtBox = findViewById(R.id.txtBox);
        EditText txtFecha = findViewById(R.id.txtFecha);
        EditText txtHorario = findViewById(R.id.txtHorario);
        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sIntent = new Intent(RegistrarAgendaHora.this, MostrarAgendaHora.class);
                startActivity(sIntent);
            }
        });
    }
}