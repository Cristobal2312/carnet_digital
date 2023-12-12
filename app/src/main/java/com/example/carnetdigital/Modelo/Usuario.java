package com.example.carnetdigital.Modelo;

public class Usuario {

    private int id;
    private String Nombre;
    private String Apellido;
    private String Rut;
    private String Nacionalidad;
    private String Sexo;
    private String FechaNacimiento;
    private String NumeroDocumento;
    private String FechaEmision;
    private String FechaVencimiento;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String rut, String nacionalidad, String sexo, String fechaNacimiento, String numeroDocumento, String fechaEmision, String fechaVencimiento) {
        this.id = id;
        Nombre = nombre;
        Apellido = apellido;
        Rut = rut;
        Nacionalidad = nacionalidad;
        Sexo = sexo;
        FechaNacimiento = fechaNacimiento;
        NumeroDocumento = numeroDocumento;
        FechaEmision = fechaEmision;
        FechaVencimiento = fechaVencimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String rut) {
        Rut = rut;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        NumeroDocumento = numeroDocumento;
    }

    public String getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        FechaEmision = fechaEmision;
    }

    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        FechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Rut='" + Rut + '\'' +
                ", Nacionalidad='" + Nacionalidad + '\'' +
                ", Sexo='" + Sexo + '\'' +
                ", FechaNacimiento='" + FechaNacimiento + '\'' +
                ", NumeroDocumento='" + NumeroDocumento + '\'' +
                ", FechaEmision='" + FechaEmision + '\'' +
                ", FechaVencimiento='" + FechaVencimiento + '\'' +
                '}';
    }
}
