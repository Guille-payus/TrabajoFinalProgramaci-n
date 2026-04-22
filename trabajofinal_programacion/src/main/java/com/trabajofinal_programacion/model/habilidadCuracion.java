//package com.trabajofinal_programacion.model;
//
//public class habilidadCuracion implements habilidad {
//
//    @Override
//    public String getId() { return "cura_basica"; }
//
//    @Override
//    public String getNombre() { return "Curación"; }
//
//    @Override
//    public String getDescripcion() {
//        return "Restaura un 30% de la vida máxima.";
//    }
//
//    @Override
//    public void aplicar(Criatura usuario, Criatura objetivo, StringBuilder log) {
//        int cantidad = (int) (usuario.getStats().getVidaMaxima() * 0.3);
//        int nuevaVida = Math.min(
//                usuario.getStats().getVidaMaxima(),
//                usuario.getStats().getVidaActual() + cantidad
//        );
//        usuario.getStats().setVidaActual(nuevaVida);
//        log.append(usuario.getNombre())
//           .append(" usa ")
//           .append(getNombre())
//           .append(" y se cura ")
//           .append(cantidad)
//           .append(" puntos.\n");
//    }
//}