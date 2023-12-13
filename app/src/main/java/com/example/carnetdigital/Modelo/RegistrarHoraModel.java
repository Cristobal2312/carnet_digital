package com.example.carnetdigital.Modelo;

public class RegistrarHoraModel {

    public class AgendaHora {
        private long id;
        private String nombrePaciente;
        private String numFicha;
        private String rutPaciente;
        private String fecha;
        private String horario;
        private String box;
        private String terapeuta;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNombrePaciente() {
            return nombrePaciente;
        }

        public void setNombrePaciente(String nombrePaciente) {
            this.nombrePaciente = nombrePaciente;
        }

        public String getNumFicha() {
            return numFicha;
        }

        public void setNumFicha(String numFicha) {
            this.numFicha = numFicha;
        }

        public String getRutPaciente() {
            return rutPaciente;
        }

        public void setRutPaciente(String rutPaciente) {
            this.rutPaciente = rutPaciente;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getHorario() {
            return horario;
        }

        public void setHorario(String horario) {
            this.horario = horario;
        }

        public String getBox() {
            return box;
        }

        public void setBox(String box) {
            this.box = box;
        }

        public String getTerapeuta() {
            return terapeuta;
        }

        public void setTerapeuta(String terapeuta) {
            this.terapeuta = terapeuta;
        }

    }}
