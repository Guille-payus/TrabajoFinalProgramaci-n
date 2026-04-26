package com.trabajofinal_programacion.model;

public class Estadisticas {
    private int vidaMaxima;
    private int vidaActual;
    private int ataque;
    private int defensa;
    private int velocidad;

    public int getVidaMaxima() { return vidaMaxima; }
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
        if (vidaActual == 0) this.vidaActual = vidaMaxima;
    }

    public int getVidaActual() { return vidaActual; }
    public void setVidaActual(int vidaActual) { this.vidaActual = vidaActual; }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = defensa; }

    public int getVelocidad() { return velocidad; }
    public void setVelocidad(int velocidad) { this.velocidad = velocidad; }
}