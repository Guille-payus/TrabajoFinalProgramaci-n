//package com.trabajofinal_programacion.model;

//public class HabilidadEstado implements habilidad {
//
//    @Override
//    public String getId() { return "escudo"; }
//
//    @Override
//    public String getNombre() { return "Escudo"; }
//
//    @Override
//    public String getDescripcion() {
//        return "Aumenta temporalmente la defensa.";
//    }
//
//    @Override
//    public void aplicar(Criatura usuario, Criatura objetivo, StringBuilder log) {
//        int defensaActual = usuario.getStats().getDefensa();
//        usuario.getStats().setDefensa(defensaActual + 5);
//        log.append(usuario.getNombre())
//           .append(" usa ")
//           .append(getNombre())
//           .append(" y aumenta su defensa.\n");
//    }
//}