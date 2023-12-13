package com.example.carnetdigital.Modelo;

public class Cita {
    private String terapeuta;
    private String fecha;
    private String hora;

    public Cita(String terapeuta, String fecha, String hora) {
        this.terapeuta = terapeuta;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getTerapeuta() {
        return terapeuta;
    }

    public void setTerapeuta(String terapeuta) {
        this.terapeuta = terapeuta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
