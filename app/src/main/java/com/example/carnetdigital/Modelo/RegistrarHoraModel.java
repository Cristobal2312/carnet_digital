package com.example.carnetdigital.Modelo;

public class RegistrarHoraModel {

    private String nombrePaciente;
    private String numFicha;
    private String fecha;
    private String horario;
    private String box;
    private String terapeuta;
    private String rutPaciente;

    public RegistrarHoraModel(String nombrePaciente, String numFicha, String fecha, String horario, String box, String terapeuta, String rutPaciente) {
        this.nombrePaciente = nombrePaciente;
        this.numFicha = numFicha;
        this.fecha = fecha;
        this.horario = horario;
        this.box = box;
        this.terapeuta = terapeuta;
        this.rutPaciente = rutPaciente;
    }

    // Agrega getters y setters según sea necesario
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getNumFicha() {
        return numFicha;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHorario() {
        return horario;
    }

    public String getBox() {
        return box;
    }

    public String getTerapeuta() {
        return terapeuta;
    }

    public String getRutPaciente() {
        return rutPaciente;
    }
}
