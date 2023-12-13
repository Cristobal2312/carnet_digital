package com.example.carnetdigital.Modelo;

public class Roles {
    private int Rol;

    public Roles() {
    }

    public Roles(int rol) {
        Rol = rol;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int rol) {
        Rol = rol;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "Rol=" + Rol +
                '}';
    }
}
