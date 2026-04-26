package com.trabajofinal_programacion.model;

import java.util.Map;
import java.util.Random;

public class Combate {

    private final Criatura jugador;
    private final Criatura enemigo;
    private final Map<String, Habilidad> habilidades;
    private final StringBuilder log = new StringBuilder();
    private final Random random = new Random();

    private boolean terminado;

    public Combate(Criatura jugador, Criatura enemigo, Map<String, Habilidad> habilidades) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.habilidades = habilidades;
    }

    public void turnoJugador(String habilidadId) {
        if (terminado) return;
        Habilidad h = habilidades.get(habilidadId);
        if (h == null) return;
        h.aplicar(jugador, enemigo, log);
        comprobarFin();
        if (!terminado) turnoEnemigo();
    }

    private void turnoEnemigo() {
        if (terminado) return;
        var lista = enemigo.getHabilidadesIds();
        String habId = lista.get(random.nextInt(lista.size()));
        Habilidad h = habilidades.get(habId);
        if (h != null) {
            h.aplicar(enemigo, jugador, log);
        }
        comprobarFin();
    }

    private void comprobarFin() {
        if (jugador.getStats().getVidaActual() <= 0 ||
            enemigo.getStats().getVidaActual() <= 0) {
            terminado = true;
            if (jugador.getStats().getVidaActual() <= 0 &&
                enemigo.getStats().getVidaActual() <= 0) {
                log.append("¡Empate!\n");
            } else if (jugador.getStats().getVidaActual() <= 0) {
                log.append("¡Has perdido!\n");
            } else {
                log.append("¡Has ganado!\n");
            }
        }
    }

    public Criatura getJugador() { return jugador; }
    public Criatura getEnemigo() { return enemigo; }
    public boolean isTerminado() { return terminado; }
    public String getLog() { return log.toString(); }
}
