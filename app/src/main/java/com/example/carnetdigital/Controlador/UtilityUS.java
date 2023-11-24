package com.example.carnetdigital.Controlador;

public class UtilityUS {
    public static final String TABLA_CARNET = "CarnetUsuario";

    public static final String CAMPO_IDUSER = "IDUsuario";
    public static final String CAMPO_NOMBRE = "Nombre";
    public static final String CAMPO_APELLIDO = "Apellido";
    public static final String CAMPO_RUT = "Rut";
    public static final String CAMPO_NACIONALIDAD = "Nacionalidad";
    public static final String CAMPO_SEXO = "Sexo";
    public static final String CAMPO_FENACIMIENTO = "FechaNacimiento";
    public static final String CAMPO_NUDOCUMENTO = "NumeroDocumento";
    public static final String CAMPO_FEEMISION = "FechaEmision";
    public static final String CAMPO_FEVENCIMIENTO = "FechaVencimiento";


    public static final String CREAR_TABLA_CARNET = "CREATE TABLE " + TABLA_CARNET + " ("+
            CAMPO_IDUSER + " INTEGER PRIMARY KEY, " +
            CAMPO_NOMBRE + " TEXT, " +
            CAMPO_APELLIDO + " TEXT, " +
            CAMPO_RUT + " TEXT, " +
            CAMPO_NACIONALIDAD + " TEXT, " +
            CAMPO_SEXO + " TEXT, " +
            CAMPO_FENACIMIENTO + " DATE " +
            CAMPO_NUDOCUMENTO + " TEXT, " +
            CAMPO_FEEMISION + " DATE " +
            CAMPO_FEVENCIMIENTO + "  DATE )";



}
