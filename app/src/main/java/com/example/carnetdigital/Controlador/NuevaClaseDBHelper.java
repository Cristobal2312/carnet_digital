package com.example.carnetdigital.Controlador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
