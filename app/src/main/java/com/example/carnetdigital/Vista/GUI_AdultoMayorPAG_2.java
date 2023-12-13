package com.example.carnetdigital.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carnetdigital.Controlador.NuevaClaseDBHelper;
import com.example.carnetdigital.R;

public class GUI_AdultoMayorPAG_2 extends AppCompatActivity {

    Button VbtnVolver, VbtnListaTareas, VbtnUbicacion, VbtnCarnetMedico;
    private NuevaClaseDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_adulto_mayor_pag2);

        dbHelper = new NuevaClaseDBHelper(this);

        VbtnVolver = (Button) findViewById(R.id.VbtnVolver);
        VbtnListaTareas = (Button) findViewById(R.id.VbtnListaTareas);
        VbtnUbicacion = (Button) findViewById(R.id.VbtnUbicacion);
        VbtnCarnetMedico = (Button) findViewById(R.id.VbtnCarnetMedico);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue_button));
        }

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

        consultar();

    }

    TextView Paciente, Rut, NumFicha;
    private void consultar() {
        //conexion a la base de dato para leer los datos


        Paciente = findViewById(R.id.txtJPaciente);
        Rut = findViewById(R.id.txtJRut);
        NumFicha = findViewById(R.id.txtJFicha);

        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] parametros = {"1"}; //Usuario Asignado por ID
            //Consulta de base de dato
            Cursor cursor = db.rawQuery("SELECT nombrePaciente, rutPaciente, numeroFicha FROM agenda WHERE id =? ", parametros);
            cursor.moveToFirst();




            //obtener los datos del cursor Usuario y Contraseña de la base de datoss
            String nombrePaciente = cursor.getString(0);
            String rutPaciente = cursor.getString(1);
            String numeroFicha = cursor.getString(2);


            Paciente.setText(nombrePaciente);
            Rut.setText(rutPaciente);
            NumFicha.setText(numeroFicha);

            dbHelper.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "(Error de BD)", Toast.LENGTH_LONG).show();
        }
    }
}