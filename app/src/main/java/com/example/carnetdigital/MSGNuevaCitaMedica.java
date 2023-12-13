package com.example.carnetdigital;

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
import com.example.carnetdigital.Vista.GUI_AdultoMayor;
import com.example.carnetdigital.Vista.MainActivity;
import com.example.carnetdigital.Vista.menu_principal;

public class MSGNuevaCitaMedica extends AppCompatActivity {

    Button BbtnVolverS, BbtnCrearC;
    private UtilityRoles dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msgnueva_cita_medica);

        dbHelper = new UtilityRoles(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue_button));
        }

        BbtnVolverS = (Button) findViewById(R.id.BbtnVolverS);

        BbtnCrearC = (Button) findViewById(R.id.BbtnCrearC);

        BbtnVolverS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MSGNuevaCitaMedica.this, GUI_AdultoMayor.class);
                startActivity(intent);
            }
        });

        BbtnCrearC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CambiarRol();

            }
        });
    }

    public void CambiarRol(){
        try{
            eliminarTodosLosDatos();

            // Obtener los valores de las vistas
            String ID2 = "1";
            String Roles = "1";

            // Insertar en la base de datos
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id", ID2);
            values.put("Rol", Roles);

            long newRowId = db.insert("Roles", null, values);

            // Cierra la conexión de la base de datos
            dbHelper.close();

            startActivity(new Intent(MSGNuevaCitaMedica.this, MainActivity.class));
            finishAffinity();
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