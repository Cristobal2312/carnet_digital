package com.example.carnetdigital.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.carnetdigital.R;

public class MostrarAgendaHora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_agenda_hora);

        TextView txtNMedico = findViewById(R.id.VtxtNombrePaciente);
        TextView txtNSala = findViewById(R.id.VtxtRutPaciente);
        TextView txtNFecha = findViewById(R.id.txtNFecha);
        TextView txtNHorario = findViewById(R.id.txtNHorario);

        Intent intent = getIntent();
        if(intent != null){
            String MEDICO = getIntent().getStringExtra("medico");
            String SALA = getIntent().getStringExtra("box");
            String FECHA = getIntent().getStringExtra("fecha");
            String HORARIO = getIntent().getStringExtra("Horario");

            txtNMedico.setText(MEDICO);
            txtNSala.setText(SALA);
            txtNFecha.setText(FECHA);
            txtNHorario.setText(HORARIO);
        }
    }
}