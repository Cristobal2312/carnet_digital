package com.example.carnetdigital.Vista;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carnetdigital.R;

public class MostrarAgendaHora extends AppCompatActivity {

    private TextView txtNombrePaciente;
    private TextView txtNumeroFicha;
    private TextView txtRutPaciente;
    private TextView txtNFecha;
    private TextView txtNHorario;
    private TextView txtMedico;
    private TextView txtBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_agenda_hora);

        // Inicializar vistas
        txtNombrePaciente = findViewById(R.id.HtxtNombrePaciente);
        txtNumeroFicha = findViewById(R.id.HtxtNFicha);
        txtRutPaciente = findViewById(R.id.HtxtRut);
        txtNFecha = findViewById(R.id.HtxtFecha);
        txtNHorario = findViewById(R.id.HtxtHora);
        txtMedico = findViewById(R.id.HtxtNombreTera);
        txtBox = findViewById(R.id.HtxtBox);

        // Obtener datos de la agenda (puedes obtener estos datos de tu base de datos o de donde sea necesario)
        String nombrePaciente = "Pedro Alfaro Rodrigez";
        String numeroFicha = "A20-B";
        String rutPaciente = "12345678-9";
        String fecha = "20/12/2023";
        String horario = "14:30";
        String medico = "Dr. Smith"; // Reemplaza esto con el nombre real del médico
        String box = "A101"; // Reemplaza esto con el número real del box

        // Establecer los datos en las vistas
        txtNombrePaciente.setText(nombrePaciente);
        txtNumeroFicha.setText(numeroFicha);
        txtRutPaciente.setText(rutPaciente);
        txtNFecha.setText(fecha);
        txtNHorario.setText(horario);
        txtMedico.setText(medico);
        txtBox.setText(box);

        // Agregar un listener al botón para volver
        Button btnVolver = findViewById(R.id.HbtnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para volver, por ejemplo, cerrar la actividad
                finish();
            }
        });
    }
}
