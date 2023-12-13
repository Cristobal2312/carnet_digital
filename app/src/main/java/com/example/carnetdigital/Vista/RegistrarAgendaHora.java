package com.example.carnetdigital.Vista;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carnetdigital.Controlador.NuevaClaseDBHelper;
import com.example.carnetdigital.R;

public class RegistrarAgendaHora extends AppCompatActivity {

    private NuevaClaseDBHelper dbHelper; // Cambiado el nombre de DBHelper a NuevaClaseDBHelper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_agenda_hora);

        dbHelper = new NuevaClaseDBHelper(this); // Cambiado el nombre de DBHelper a NuevaClaseDBHelper

        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al hacer clic en el botón Registrar, recoger los datos de las vistas
                insertarDatosEnDB();
            }
        });
    }

    private void insertarDatosEnDB() {
        eliminarTodosLosDatos();

        try{
            EditText txtNombrePaciente = findViewById(R.id.txtNombrePaciente);
            EditText txtNumFicha = findViewById(R.id.txtNumFicha);
            EditText txtFecha = findViewById(R.id.txtFecha);
            EditText txtHorario = findViewById(R.id.txtHorario);
            EditText txtBox = findViewById(R.id.txtBox);
            EditText txtTerapeuta = findViewById(R.id.txtTerapeuta);
            EditText txtRutPaciente = findViewById(R.id.txtRutPaciente);

            // Obtener los valores de las vistas
            String ID = "1";
            String nombrePaciente = txtNombrePaciente.getText().toString();
            String numeroFicha = txtNumFicha.getText().toString();
            String fecha = txtFecha.getText().toString();
            String horario = txtHorario.getText().toString();
            String box = txtBox.getText().toString();
            String terapeuta = txtTerapeuta.getText().toString();
            String rutPaciente = txtRutPaciente.getText().toString();

            // Insertar en la base de datos
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id", ID);
            values.put("nombrePaciente", nombrePaciente);
            values.put("numeroFicha", numeroFicha);
            values.put("fecha", fecha);
            values.put("hora", horario);
            values.put("boxSala", box);
            values.put("terapeuta", terapeuta);
            values.put("rutPaciente", rutPaciente);

            long newRowId = db.insert("agenda", null, values);

            // Cierra la conexión de la base de datos
            dbHelper.close();

            Intent intent = new Intent(RegistrarAgendaHora.this, MostrarAgendaHora.class);
            startActivity(intent);

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR de Registro", Toast.LENGTH_SHORT).show();
            eliminarTodosLosDatos();
        }

    }

    private void eliminarTodosLosDatos() {
        try {
            // Abre la base de datos en modo escritura
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Elimina todos los registros de la tabla "agenda"
            db.delete("agenda", null, null);

            // Cierra la conexión de la base de datos
            dbHelper.close();

            Toast.makeText(getApplicationContext(), "Todos los datos han sido eliminados", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error al intentar eliminar los datos", Toast.LENGTH_SHORT).show();
        }
    }


}
