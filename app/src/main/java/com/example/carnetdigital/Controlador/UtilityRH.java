package com.example.carnetdigital.Controlador;

import android.widget.EditText;


public class UtilityRH {

    public static final String TABLA_AGENDA = "Agenda";
    public static final String CAMPO_ID = "ID";
    public static final String CAMPO_NOMBRE_PACIENTE = "NombrePaciente";
    public static final String CAMPO_NUM_FICHA = "NumFicha";
    public static final String CAMPO_FECHA = "Fecha";
    public static final String CAMPO_HORARIO = "Horario";
    public static final String CAMPO_BOX = "Box";
    public static final String CAMPO_TERAPEUTA = "Terapeuta";
    public static final String CAMPO_RUT_PACIENTE = "RutPaciente";

    public static final String CREAR_TABLA_AGENDA = "CREATE TABLE " + TABLA_AGENDA + " (" +
            CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_NOMBRE_PACIENTE + " TEXT, " +
            CAMPO_NUM_FICHA + " TEXT, " +
            CAMPO_FECHA + " TEXT, " +
            CAMPO_HORARIO + " TEXT, " +
            CAMPO_BOX + " TEXT, " +
            CAMPO_TERAPEUTA + " TEXT, " +
            CAMPO_RUT_PACIENTE + " TEXT)";

}
