package com.example.carnetdigital.Modelo;

public class Roles {
    private int ID;
    private int Rol;

    public Roles() {
    }

    public Roles(int ID, int rol) {
        this.ID = ID;
        Rol = rol;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
                "ID=" + ID +
                ", Rol=" + Rol +
                '}';
    }
}
