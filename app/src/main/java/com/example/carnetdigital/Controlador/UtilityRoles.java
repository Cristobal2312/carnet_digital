package com.example.carnetdigital.Controlador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UtilityRoles extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ROLESPRO";
    private static final int DATABASE_VERSION = 2;

    private static final String CREATE_TABLE_ROLES = "CREATE TABLE Roles " +
            "(ID INTEGER PRIMARY KEY, " +
            "Rol INTEGER);";


    public UtilityRoles(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ROLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Manejar actualizaciones de la base de datos si es necesario
        db.execSQL("DROP TABLE IF EXISTS "+ "Roles");
        onCreate(db);
    }

}
