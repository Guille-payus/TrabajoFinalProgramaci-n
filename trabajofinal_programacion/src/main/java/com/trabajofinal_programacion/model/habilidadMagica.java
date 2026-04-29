package com.trabajofinal_programacion.model;
public class HabilidadMagica implements Habilidad {

    @Override
    public String getId() { return "magica_area"; }

    @Override
    public String getNombre() { return "Llama Arcana"; }

    @Override
    public String getDescripcion() {
        return "Daño mágico fijo que ignora defensa.";
    }

    @Override
    public void aplicar(Criatura usuario, Criatura objetivo, StringBuilder log) {
        int dano = 25;
        int nuevaVida = Math.max(0, objetivo.getStats().getVidaActual() - dano);
        objetivo.getStats().setVidaActual(nuevaVida);
        log.append(usuario.getNombre())
           .append(" lanza ")
           .append(getNombre())
           .append(" y hace ")
           .append(dano)
           .append(" de daño mágico.\n");
    }
}