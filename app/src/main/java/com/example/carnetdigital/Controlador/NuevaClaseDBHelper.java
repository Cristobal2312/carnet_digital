package com.example.carnetdigital.Controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.carnetdigital.Modelo.Cita;

import java.util.ArrayList;
import java.util.List;

public class NuevaClaseDBHelper extends SQLiteOpenHelper {

    // Cambia el nombre de la base de datos aquí
    private static final String DATABASE_NAME = "NuevoNombreDeLaBD";
    private static final int DATABASE_VERSION = 4;

    private static final String CREATE_TABLE_AGENDA = "CREATE TABLE agenda " +
            "(id INTEGER PRIMARY KEY, " +
            "nombrePaciente TEXT, " +
            "numeroFicha TEXT, " +
            "fecha TEXT, " +
            "hora TEXT, " +
            "boxSala TEXT, " +
            "terapeuta TEXT, " +
            "rutPaciente TEXT);";

    public NuevaClaseDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_AGENDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Manejar actualizaciones de la base de datos si es necesario
        db.execSQL("DROP TABLE IF EXISTS "+ "agenda");
        onCreate(db);
    }

    public List<Cita> obtenerListaDeCitas() {
        List<Cita> listaDeCitas = new ArrayList<>();

        // Consulta para obtener las citas
        String consulta = "SELECT terapeuta, fecha, hora FROM agenda";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(consulta, null);

        try {
            // Procesar los resultados de la consulta
            while (cursor.moveToNext()) {
                int terapeutaIndex = cursor.getColumnIndex("terapeuta");
                int fechaIndex = cursor.getColumnIndex("fecha");
                int horaIndex = cursor.getColumnIndex("hora");

                // Verificar si las columnas existen antes de intentar acceder a ellas
                if (terapeutaIndex >= 0 && fechaIndex >= 0 && horaIndex >= 0) {
                    String terapeuta = cursor.getString(terapeutaIndex);
                    String fecha = cursor.getString(fechaIndex);
                    String hora = cursor.getString(horaIndex);

                    Cita cita = new Cita(terapeuta, fecha, hora);
                    listaDeCitas.add(cita);
                }
            }
        } finally {
            // Asegurarse de cerrar el cursor después de usarlo
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        // Devolver la lista de citas
        return listaDeCitas;
    }
}
