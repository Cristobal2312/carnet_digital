package com.example.carnetdigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarAgendaHora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_agenda_hora);

        EditText txtMedico = findViewById(R.id.txtMedico);
        EditText txtBox = findViewById(R.id.txtBox);
        EditText txtFecha = findViewById(R.id.txtFecha);
        EditText txtHorario = findViewById(R.id.txtHorario);
        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String medico =txtMedico.getText().toString();
                String box = txtBox.getText().toString();
                String fecha = txtFecha.getText().toString();
                String Horario = txtHorario.getText().toString();

                Intent sIntent = new Intent(RegistrarAgendaHora.this, MostrarAgendaHora.class);
                sIntent.putExtra("medico", medico);
                sIntent.putExtra("box", box);
                sIntent.putExtra("fecha", fecha);
                sIntent.putExtra("Horario", Horario);
                startActivity(sIntent);
            }
        });
    }
}