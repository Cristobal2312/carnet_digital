package com.example.carnetdigital.Vista;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carnetdigital.Controlador.DBHelper;
import com.example.carnetdigital.Controlador.NuevaClaseDBHelper;
import com.example.carnetdigital.Controlador.UtilityUS;
import com.example.carnetdigital.R;


public class MostrarAgendaHora extends AppCompatActivity {
    private NuevaClaseDBHelper dbHelper;
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

        dbHelper = new NuevaClaseDBHelper(this);

        // Inicializar vistas
        txtNombrePaciente = findViewById(R.id.HtxtNombrePaciente);
        txtNumeroFicha = findViewById(R.id.HtxtNFicha);
        txtRutPaciente = findViewById(R.id.HtxtRut);
        txtNFecha = findViewById(R.id.HtxtFecha);
        txtNHorario = findViewById(R.id.HtxtHora);
        txtMedico = findViewById(R.id.HtxtNombreTera);
        txtBox = findViewById(R.id.HtxtBox);

        consultar();

        // Obtener datos de la agenda (puedes obtener estos datos de tu base de datos o de donde sea necesario)



        // Agregar un listener al botón para volver
        Button btnVolver = findViewById(R.id.HbtnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para volver, por ejemplo, cerrar la actividad
                Intent intent = new Intent(MostrarAgendaHora.this, menu_principal.class);
                startActivity(intent);
                finish();


            }
        });
    }


    private void consultar() {
        //conexion a la base de dato para leer los datos


        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] parametros = {"1"}; //Usuario Asignado por ID
            //Consulta de base de dato
            Cursor cursor = db.rawQuery("SELECT nombrePaciente, numeroFicha, fecha, hora, boxSala, terapeuta, rutPaciente FROM agenda WHERE id =? ", parametros);
            cursor.moveToFirst();



            //obtener los datos del cursor Usuario y Contraseña de la base de datoss
            String nombrePaciente = cursor.getString(0);
            String numeroFicha = cursor.getString(1);
            String fecha = cursor.getString(2);
            String horario = cursor.getString(3);
            String box = cursor.getString(4);
            String medico = cursor.getString(5);
            String rutPaciente = cursor.getString(6);


            txtNombrePaciente.setText(nombrePaciente);
            txtNumeroFicha.setText(numeroFicha);
            txtRutPaciente.setText(rutPaciente);
            txtNFecha.setText(fecha);
            txtNHorario.setText(horario);
            txtMedico.setText(medico);
            txtBox.setText(box);


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "(Error de BD)", Toast.LENGTH_LONG).show();
        }
    }
}
