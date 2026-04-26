package com.trabajofinal_programacion.model;
public class HabilidadFisica implements Habilidad {

    @Override
    public String getId() { return "fisica_basica"; }

    @Override
    public String getNombre() { return "Golpe Físico"; }

    @Override
    public String getDescripcion() {
        return "Ataque físico que usa ataque y defensa.";
    }

    @Override
    public void aplicar(Criatura usuario, Criatura objetivo, StringBuilder log) {
        int base = usuario.getStats().getAtaque() - objetivo.getStats().getDefensa() / 2;
        int dano = Math.max(5, base);
        int nuevaVida = Math.max(0, objetivo.getStats().getVidaActual() - dano);
        objetivo.getStats().setVidaActual(nuevaVida);
        log.append(usuario.getNombre())
           .append(" usa ")
           .append(getNombre())
           .append(" y hace ")
           .append(dano)
           .append(" de daño.\n");
    }
}