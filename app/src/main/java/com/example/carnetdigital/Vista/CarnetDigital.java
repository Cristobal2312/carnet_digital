package com.example.carnetdigital.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carnetdigital.Controlador.DBHelper;
import com.example.carnetdigital.Controlador.UtilityUS;
import com.example.carnetdigital.R;
import com.example.carnetdigital.menu_principal;

public class CarnetDigital extends AppCompatActivity {

    Button btnSoloDatos;
    Button btnVolver;

    TextView txtNombreC, txtApellidoC, txtRutC, txtNacionalidadC, txtSexoC, txtFechaNacimientoC, txtNumeroDocumentoC, txtFechaEmisionC, txtFechaVencimientoC;
    DBHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnet_digital);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.mi_color_de_barra_de_estado));
        }

        conn = new DBHelper(getApplicationContext(), "bd_carnetdigital", null, 1);

        btnSoloDatos = (Button)findViewById(R.id.btnSoloDatos);
        btnVolver = (Button)findViewById(R.id.btnVolver);

        txtNombreC = findViewById(R.id.txtNombreC);
        txtApellidoC = findViewById(R.id.txtApellidoC);
        txtRutC = findViewById(R.id.txtRutC);
        txtNacionalidadC = findViewById(R.id.txtNacionalidadC);
        txtSexoC = findViewById(R.id.txtSexoC);
        txtFechaNacimientoC = findViewById(R.id.txtFechaNacimientoC);
        txtNumeroDocumentoC = findViewById(R.id.txtNumeroDocumentoC);
        txtFechaEmisionC = findViewById(R.id.txtFechaEmisionC);
        txtFechaVencimientoC = findViewById(R.id.txtFechaVencimientoC);



        btnSoloDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarnetDigital.this, CarnetDigitalFondos.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarnetDigital.this, menu_principal.class);
                startActivity(intent);
            }
        });
        consultar();

    }

    private void consultar() {
        //conexion a la base de dato para leer los datos
        SQLiteDatabase db = conn.getReadableDatabase();

        String[] parametros = {"1"}; //Usuario Asignado por ID

        try {
            //Consulta de base de dato
            Cursor cursor = db.rawQuery("SELECT " + UtilityUS.CAMPO_NOMBRE + "," + UtilityUS.CAMPO_APELLIDO + "," + UtilityUS.CAMPO_RUT + "," +
                            UtilityUS.CAMPO_NACIONALIDAD + "," + UtilityUS.CAMPO_SEXO + "," + UtilityUS.CAMPO_FENACIMIENTO + "," +
                            UtilityUS.CAMPO_NUDOCUMENTO + "," + UtilityUS.CAMPO_FEEMISION + "," + UtilityUS.CAMPO_FEVENCIMIENTO +
                    " FROM " + UtilityUS.TABLA_CARNET + " WHERE " + UtilityUS.CAMPO_IDUSER + "=? ", parametros);
            cursor.moveToFirst();

            //obtener los datos del cursor Usuario y Contraseña de la base de datoss
            String NombreA = cursor.getString(0);
            String ApellidoA = cursor.getString(1);
            String RutA = cursor.getString(2);
            String NacionalidadA = cursor.getString(3);
            String SexoA = cursor.getString(4);
            String FechaNacimientoA = cursor.getString(5);
            String NumeroDocumentoA = cursor.getString(6);
            String FechaEmisionA = cursor.getString(7);
            String FechaVencimientoA = cursor.getString(8);

            txtNombreC.setText(NombreA);
            txtApellidoC.setText(ApellidoA);
            txtRutC.setText(RutA);
            txtNacionalidadC.setText(NacionalidadA);
            txtSexoC.setText(SexoA);
            txtFechaNacimientoC.setText(FechaNacimientoA);
            txtNumeroDocumentoC.setText(NumeroDocumentoA);
            txtFechaEmisionC.setText(FechaEmisionA);
            txtFechaVencimientoC.setText(FechaVencimientoA);






            //Toast.makeText(getApplicationContext(), "Usuario: "+ UsuarioBD + "Contraseña: " +ContraseñaBD, Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "(Error de BD)", Toast.LENGTH_LONG).show();
        }
    }


}