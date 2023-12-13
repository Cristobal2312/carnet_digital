package com.example.carnetdigital.Controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.carnetdigital.Modelo.RegistrarHoraModel;

public class DBRH {
    private static final String DATABASE_NAME = "RegistrarHoraDatabase";
    private static final int DATABASE_VERSION = 2;
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    // Table name and column names
    private static final String TABLE_AGENDA_HORA = "agenda_hora";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE_PACIENTE = "nombre_paciente";
    private static final String COLUMN_NUM_FICHA = "num_ficha";
    private static final String COLUMN_RUT_PACIENTE = "rut_paciente";
    private static final String COLUMN_FECHA = "fecha";
    private static final String COLUMN_HORARIO = "horario";
    private static final String COLUMN_BOX = "box";
    private static final String COLUMN_TERAPEUTA = "terapeuta";

    public DBRH(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertAgendaHora(RegistrarHoraModel.AgendaHora agendaHora) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE_PACIENTE, agendaHora.getNombrePaciente());
        values.put(COLUMN_NUM_FICHA, agendaHora.getNumFicha());
        values.put(COLUMN_RUT_PACIENTE, agendaHora.getRutPaciente());
        values.put(COLUMN_FECHA, agendaHora.getFecha());
        values.put(COLUMN_HORARIO, agendaHora.getHorario());
        values.put(COLUMN_BOX, agendaHora.getBox());
        values.put(COLUMN_TERAPEUTA, agendaHora.getTerapeuta());

        return database.insert(TABLE_AGENDA_HORA, null, values);
    }

    public Cursor getAllAgendaHoras() {
        String[] columns = {COLUMN_ID, COLUMN_NOMBRE_PACIENTE, COLUMN_NUM_FICHA, COLUMN_RUT_PACIENTE,
                COLUMN_FECHA, COLUMN_HORARIO, COLUMN_BOX, COLUMN_TERAPEUTA};
        return database.query(TABLE_AGENDA_HORA, columns, null, null, null, null, null);
    }

    private static class DBHelper extends SQLiteOpenHelper {
        DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // Create your database tables here
            String createTableQuery = "CREATE TABLE " + TABLE_AGENDA_HORA + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOMBRE_PACIENTE + " TEXT, " +
                    COLUMN_NUM_FICHA + " TEXT, " +
                    COLUMN_RUT_PACIENTE + " TEXT, " +
                    COLUMN_FECHA + " TEXT, " +
                    COLUMN_HORARIO + " TEXT, " +
                    COLUMN_BOX + " TEXT, " +
                    COLUMN_TERAPEUTA + " TEXT)";
            db.execSQL(createTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Handle database upgrades if needed
        }
    }
}
