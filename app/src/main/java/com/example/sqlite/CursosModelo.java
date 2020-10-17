package com.example.sqlite;

public class CursosModelo {
    private String codigo, curso, carrera;

    public CursosModelo() {
    }

    public CursosModelo(String curso, String codigo, String carrera) {
        this.codigo = codigo;
        this.curso = curso;
        this.carrera = carrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }



    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}

