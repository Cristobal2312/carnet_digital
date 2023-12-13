package com.example.carnetdigital.Vista;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carnetdigital.Modelo.RegistrarHoraModel;

import com.example.carnetdigital.Controlador.DBRH;
import com.example.carnetdigital.Modelo.RegistrarHoraModel;
import com.example.carnetdigital.R;

public class RegistrarAgendaHora extends AppCompatActivity {

    private DBRH agendaHoraDAO;

    private EditText txtNombrePaciente;
    private EditText txtNumFicha;
    private EditText txtRutPaciente;
    private EditText txtFecha;
    private EditText txtHorario;
    private EditText txtBox;
    private EditText txtTerapeuta;

    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_agenda_hora);

        // Inicializar la base de datos y abrir la conexión
        agendaHoraDAO = new DBRH(this);
        agendaHoraDAO.open();

        // Inicializar los elementos de la interfaz de usuario
        txtNombrePaciente = findViewById(R.id.txtNombrePaciente);
        txtNumFicha = findViewById(R.id.txtNumFicha);
        txtRutPaciente = findViewById(R.id.txtRutPaciente);
        txtFecha = findViewById(R.id.txtFecha);
        txtHorario = findViewById(R.id.txtHorario);
        txtBox = findViewById(R.id.txtBox);
        txtTerapeuta = findViewById(R.id.txtTerapeuta);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarAgendaHora();
            }
        });
    }

    private void registrarAgendaHora() {
        // Obtener los valores de los campos de texto
        String nombrePaciente = txtNombrePaciente.getText().toString();
        String numFicha = txtNumFicha.getText().toString();
        String rutPaciente = txtRutPaciente.getText().toString();
        String fecha = txtFecha.getText().toString();
        String horario = txtHorario.getText().toString();
        String box = txtBox.getText().toString();
        String terapeuta = txtTerapeuta.getText().toString();

        // Validar que no haya campos vacíos
        if (camposSonValidos(nombrePaciente, numFicha, rutPaciente, fecha, horario, box, terapeuta)) {
            // Crear un objeto AgendaHora con los valores ingresados
            RegistrarHoraModel.AgendaHora nuevaAgendaHora = new RegistrarHoraModel.AgendaHora();
            nuevaAgendaHora.setNombrePaciente(nombrePaciente);
            nuevaAgendaHora.setNumFicha(numFicha);
            nuevaAgendaHora.setRutPaciente(rutPaciente);
            nuevaAgendaHora.setFecha(fecha);
            nuevaAgendaHora.setHorario(horario);
            nuevaAgendaHora.setBox(box);
            nuevaAgendaHora.setTerapeuta(terapeuta);

            // Insertar la nueva agenda en la base de datos
            long resultado = agendaHoraDAO.insertAgendaHora(nuevaAgendaHora);

            if (resultado != -1) {
                // Registro exitoso
                Toast.makeText(this, "Agenda registrada correctamente", Toast.LENGTH_SHORT).show();
                // Aquí puedes agregar cualquier lógica adicional que necesites
            } else {
                // Error al registrar
                Toast.makeText(this, "Error al registrar la agenda", Toast.LENGTH_SHORT).show();
                // Aquí puedes manejar el error de alguna manera
            }
        } else {
            // Mostrar mensaje de campos vacíos
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean camposSonValidos(String... campos) {
        // Verificar que ninguno de los campos esté vacío
        for (String campo : campos) {
            if (campo.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cerrar la conexión de la base de datos al destruir la actividad
        agendaHoraDAO.close();
    }
}
