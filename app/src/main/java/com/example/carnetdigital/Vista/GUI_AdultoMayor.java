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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carnetdigital.Controlador.NuevaClaseDBHelper;
import com.example.carnetdigital.R;

public class GUI_AdultoMayor extends AppCompatActivity {

    Button bntMas;
    private NuevaClaseDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_adulto_mayor);

        dbHelper = new NuevaClaseDBHelper(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue_button));
        }

        bntMas = (Button) findViewById(R.id.CbtnMas);




        bntMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GUI_AdultoMayor.this, GUI_AdultoMayorPAG_2.class);
                startActivity(intent);

            }
        });

        consultar();

    }

    TextView Hora, Fecha, Tera, Box;
    private void consultar() {
        //conexion a la base de dato para leer los datos


        Hora = findViewById(R.id.txtNHorario);
        Fecha = findViewById(R.id.txtNFecha);
        Tera = findViewById(R.id.txtNnombreTera);
        Box = findViewById(R.id.txtNBox);

        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] parametros = {"1"}; //Usuario Asignado por ID
            //Consulta de base de dato
            Cursor cursor = db.rawQuery("SELECT fecha, hora, boxSala, terapeuta FROM agenda WHERE id =? ", parametros);
            cursor.moveToFirst();



            //obtener los datos del cursor Usuario y Contraseña de la base de datoss
            String fecha = cursor.getString(0);
            String horario = cursor.getString(1);
            String box = cursor.getString(2);
            String medico = cursor.getString(3);


            Fecha.setText(fecha);
            Hora.setText(horario);
            Tera.setText(medico);
            Box.setText(box);
            dbHelper.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "(Error de BD)", Toast.LENGTH_LONG).show();
        }
    }
}