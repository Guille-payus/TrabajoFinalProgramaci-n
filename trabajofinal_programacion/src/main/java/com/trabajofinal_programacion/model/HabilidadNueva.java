package com.trabajofinal_programacion.model;
public class HabilidadNueva implements Habilidad{

    @Override
    public String getId() {return "nueva";}
    
    @Override
    public String getNombre() {return "habilidad nueva";}

    @Override
    public String getDescripcion() {
        return "Habilidad nueva que no se que hace";
    }

    @Override
    public void aplicar(Criatura usuario, Criatura objetivo, StringBuilder log) {
        if (usuario.getStats().getVidaActual() % 2 == 0) {
            if (objetivo.getStats().getVidaActual() > 2) {
                int dano = objetivo.getStats().getVidaActual() / 2;
                int nuevaVida = Math.max(0, objetivo.getStats().getVidaActual() - dano);
                objetivo.getStats().setVidaActual(nuevaVida);
                log.append(usuario.getNombre())
                .append(" usa ")
                .append(getNombre())
                .append(" y hace ")
                .append(dano)
                .append(" de daño.\n");
            } else {
                System.out.println("Tienes piedad y no lo matas");
            }
        } 
    }
}
