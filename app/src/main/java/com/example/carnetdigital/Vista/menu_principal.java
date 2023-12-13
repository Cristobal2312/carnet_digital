package com.example.carnetdigital.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.carnetdigital.Controlador.UtilityRoles;
import com.example.carnetdigital.R;

/*
*hola
* */
//hola cristobal
public class menu_principal extends AppCompatActivity {

    Button Btn_Horas, Btn_Registro, btn_RegistrarCarnet,btn_mapsCarnet, btnTerminarRegistro, btnListaTareas;
    private UtilityRoles dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        dbHelper = new UtilityRoles(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue_button));
        }

        Btn_Horas = findViewById(R.id.Btn_Horas);
        Btn_Registro = findViewById(R.id.Btn_Registro);
        btn_RegistrarCarnet = findViewById(R.id.btn_RegistrarCarnet);
        btn_mapsCarnet=findViewById(R.id.btn_mapsCarnet);
        btnTerminarRegistro = (Button)findViewById(R.id.btnTerminarRegistro);
        btnListaTareas = (Button) findViewById(R.id.btnListaTareas);

        btnListaTareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_principal.this, Lista_Tarea.class);
                startActivity(intent);
            }
        });

        Btn_Horas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad de siguiente horaa
                Intent intent = new Intent(menu_principal.this, RegistrarAgendaHora.class);
                startActivity(intent);
            }
        });

        Btn_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad de Registro
                Intent intent = new Intent(menu_principal.this, registrado.class);
                startActivity(intent);
            }
        });

        btn_RegistrarCarnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_principal.this, carnetMedico.class);
                startActivity(intent);
            }
        });

        btn_mapsCarnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_principal.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        btnTerminarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CambiarRol();
                finishAffinity();
                //Intent intent = new Intent(menu_principal.this, GUI_AdultoMayor.class);
                //startActivity(intent);
            }
        });






    }
    public void Ejecutar(View view){
        Intent carnet = new Intent(menu_principal.this, MostrarAgendaHora.class);
        startActivity(carnet);
    }


    public void CambiarRol(){
        try{
            eliminarTodosLosDatos();

            // Obtener los valores de las vistas
            String ID2 = "1";
            String Roles = "2";

            // Insertar en la base de datos
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id", ID2);
            values.put("Rol", Roles);

            long newRowId = db.insert("Roles", null, values);

            // Cierra la conexión de la base de datos
            dbHelper.close();

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
            db.delete("Roles", null, null);

            // Cierra la conexión de la base de datos
            dbHelper.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error al intentar eliminar los datos", Toast.LENGTH_SHORT).show();
        }
    }

}

