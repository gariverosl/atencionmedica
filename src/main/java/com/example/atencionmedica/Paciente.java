package com.example.atencionmedica;

import java.util.List;

public class Paciente {

    private int id;
    private String nombre;
    private List<Atencion> atenciones;

    public Paciente(int id, String nombre, List<Atencion> atenciones) {
        this.id = id;
        this.nombre = nombre;
        this.atenciones = atenciones;
    }

    // Métodos para acceder y modificar los atributos

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Atencion> getAtenciones() {
        return atenciones;
    }
}