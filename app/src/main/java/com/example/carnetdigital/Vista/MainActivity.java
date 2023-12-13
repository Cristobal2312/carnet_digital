package com.example.carnetdigital.Vista;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;


import com.example.carnetdigital.Controlador.NuevaClaseDBHelper;
import com.example.carnetdigital.Controlador.UtilityRoles;
import com.example.carnetdigital.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private UtilityRoles dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new UtilityRoles(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }

        firebaseAuth = FirebaseAuth.getInstance();
        int tiempo = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*startActivity(new Intent(PantallaDeCarga.this,MainActivity.class));
                finish();*/
                VerificacionUsuario();
            }
        }, tiempo);


    } private void VerificacionUsuario(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        consultar();
        finish();

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

    private void consultar() {
        //conexion a la base de dato para leer los datos


        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] parametros = {"1"};

            Cursor cursor = db.rawQuery("SELECT Rol FROM Roles WHERE ID =? ", parametros);
            cursor.moveToFirst();

            String Rol = cursor.getString(0);


            if(Rol.equals("1")){
                Toast.makeText(getApplicationContext(), "(Terapeuta)", Toast.LENGTH_LONG).show();

                try{
                    eliminarTodosLosDatos();

                    // Obtener los valores de las vistas
                    String ID2 = "1";
                    String Roles = "1";

                    // Insertar en la base de datos
                    db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("id", ID2);
                    values.put("Rol", Roles);

                    long newRowId = db.insert("Roles", null, values);

                    // Cierra la conexión de la base de datos
                    dbHelper.close();

                    startActivity(new Intent(MainActivity.this, menu_principal.class));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "ERROR de Registro", Toast.LENGTH_SHORT).show();
                    eliminarTodosLosDatos();
                }

            }
            else if(Rol.equals("2")){
                Toast.makeText(getApplicationContext(), "(Adulto Mayor)", Toast.LENGTH_LONG).show();

                startActivity(new Intent(MainActivity.this, GUI_AdultoMayor.class));
                finish();

            }else{
                try{
                    eliminarTodosLosDatos();

                    // Obtener los valores de las vistas
                    String ID2 = "1";
                    String Roles = "1";


                    // Insertar en la base de datos
                    db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("id", ID2);
                    values.put("Rol", Roles);

                    long newRowId = db.insert("Roles", null, values);

                    // Cierra la conexión de la base de datos
                    dbHelper.close();
                    Toast.makeText(getApplicationContext(), "(Nuevo Usuario)", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, menu_principal.class));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "ERROR de Registro", Toast.LENGTH_SHORT).show();
                    eliminarTodosLosDatos();
                }
            }




        } catch (Exception e) {

            String ID2 = "1";
            String Roles = "0";

            // Insertar en la base de datos
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id", ID2);
            values.put("Rol", Roles);
            long newRowId = db.insert("Roles", null, values);
            Toast.makeText(getApplicationContext(), "(ABRIR DE NUEVO LA APLICACION)", Toast.LENGTH_LONG).show();
        }
    }

}
