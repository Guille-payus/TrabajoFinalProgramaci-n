package com.trabajofinal_programacion.model;

public interface Habilidad {
    String getId();
    String getNombre();
    String getDescripcion();
    void aplicar(Criatura usuario, Criatura objetivo, StringBuilder log);
}