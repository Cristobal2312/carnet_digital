package com.example.carnetdigital.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carnetdigital.Controlador.DBHelper;
import com.example.carnetdigital.Controlador.UtilityUS;
import com.example.carnetdigital.R;

public class RegistroCarnet extends AppCompatActivity {

    EditText txtNombre, txtApellido, txtRut, txtNacionalidad, txtSexo, txtFechaNacimiento, txtNumeroDocumento, txtFechaEmision, txtFechaVencimiento;

    Button btnGenerarCarnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_carnet);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtRut = findViewById(R.id.txtRut);
        txtNacionalidad = findViewById(R.id.txtNacionalidad);
        txtSexo = findViewById(R.id.txtSexo);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        txtNumeroDocumento = findViewById(R.id.txtNumeroDocumento);
        txtFechaEmision = findViewById(R.id.txtFechaEmision);
        txtFechaVencimiento = findViewById(R.id.txtFechaVencimiento);

        btnGenerarCarnet = findViewById(R.id.btnGenerarCarnet);

        btnGenerarCarnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrarUsuario();
            }
        });
    }

    private void RegistrarUsuario(){

        int id;
        String Nombre = txtNombre.getText().toString();
        String Apellido = txtApellido.getText().toString();
        String Rut = txtRut.getText().toString();
        String Nacionalidad = txtNacionalidad.getText().toString();
        String Sexo = txtSexo.getText().toString();
        String FechaNacimiento = txtFechaNacimiento.getText().toString();
        String NumeroDocumento = txtNumeroDocumento.getText().toString();
        String FechaEmision = txtFechaEmision.getText().toString();
        String FechaVencimiento = txtFechaVencimiento.getText().toString();


        try {
            //Conexion a la base de datos
            DBHelper conn = new DBHelper(this, "bd_carnetdigital", null, 1);
            SQLiteDatabase db = conn.getWritableDatabase();


            //Obtener los valores de cada EditTex y Insertarlos en Campos
            ContentValues contentValues = new ContentValues();
            contentValues.put(UtilityUS.CAMPO_NOMBRE, Nombre);
            contentValues.put(UtilityUS.CAMPO_APELLIDO, Apellido);
            contentValues.put(UtilityUS.CAMPO_RUT, Rut);
            contentValues.put(UtilityUS.CAMPO_NACIONALIDAD, Nacionalidad);
            contentValues.put(UtilityUS.CAMPO_SEXO, Sexo);
            contentValues.put(UtilityUS.CAMPO_FENACIMIENTO, FechaNacimiento);
            contentValues.put(UtilityUS.CAMPO_NUDOCUMENTO, NumeroDocumento);
            contentValues.put(UtilityUS.CAMPO_FEEMISION, FechaEmision);
            contentValues.put(UtilityUS.CAMPO_FEVENCIMIENTO, FechaVencimiento);

            //obtener los campos y insertarlo en la base de dato
            long ID_Resultante = db.insert(UtilityUS.TABLA_CARNET, null, contentValues);

            //mostrar Mensaje del usuario Registrado
            Toast.makeText(getApplicationContext(),"Carnet Registrado Exitosamente!! " + ID_Resultante, Toast.LENGTH_LONG).show();
            //cerrar conexion
            db.close();

            //Pasar al Layout de Inicio de Sesion
            Intent RbtnRegistrar = new Intent(RegistroCarnet.this, CarnetDigital.class);
            startActivity(RbtnRegistrar);

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR de Registro", Toast.LENGTH_LONG).show();

        }

    }



}