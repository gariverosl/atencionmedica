package com.example.atencionmedica;




public class Atencion {
    
    private int id;
    private String nombreDoc;
    private String causa;
    private String fecha;

    public Atencion(int id, String nombreDoc, String causa, String fecha) {
        this.id = id;
        this.nombreDoc = nombreDoc;
        this.causa = causa;
        this.fecha = fecha;
    }

    // Métodos para acceder y modificar los atributos

    public long getId() {
        return id;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public String getCausa() {
        return causa;
    }
    
    public String getFecha() {
        return fecha;
    }   
}
