package com.trabajofinal_programacion.controller;

import com.trabajofinal_programacion.Main;
import com.trabajofinal_programacion.model.Combate;
import com.trabajofinal_programacion.model.Criatura;
import com.trabajofinal_programacion.model.Habilidad;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.Map;

public class SecondaryController {

    @FXML private ImageView imgJugador;
    @FXML private ImageView imgEnemigo;
    @FXML private Label lblNombreJugador;
    @FXML private Label lblNombreEnemigo;
    @FXML private ProgressBar barraVidaJugador;
    @FXML private ProgressBar barraVidaEnemigo;
    @FXML private TextArea areaLog;
    @FXML private Button btnHab1;
    @FXML private Button btnHab2;
    @FXML private Button btnHab3;
    @FXML private Button btnHab4;
    @FXML private Button btnHab5;

    private Combate combate;
    private List<String> habilidadesJugador;
    private Map<String, Habilidad> mapaHabilidades;

    public void inicializar(Criatura jugador,
                            Criatura enemigo,
                            Map<String, Habilidad> habilidades) {

        this.mapaHabilidades = habilidades;
        this.combate = new Combate(jugador, enemigo, habilidades);
        this.habilidadesJugador = jugador.getHabilidadesIds();

        lblNombreJugador.setText(jugador.getNombre());
        lblNombreEnemigo.setText(enemigo.getNombre());

        // imagen en JSON: "images/dragon.png"
        imgJugador.setImage(new Image(
                Main.class.getResource(jugador.getImagen()).toExternalForm()
        ));
        imgEnemigo.setImage(new Image(
                Main.class.getResource(enemigo.getImagen()).toExternalForm()
        ));

        configurarBotones();
        actualizarVistas();
    }

    private void configurarBotones() {
        Button[] botones = {btnHab1, btnHab2, btnHab3, btnHab4, btnHab5};
        for (int i = 0; i < botones.length; i++) {
            if (i < habilidadesJugador.size()) {
                String habId = habilidadesJugador.get(i);
                Habilidad h = mapaHabilidades.get(habId);
                botones[i].setDisable(false);
                botones[i].setUserData(habId);
                botones[i].setText(h != null ? h.getNombre() : habId);
            } else {
                botones[i].setDisable(true);
            }
        }
    }

    private void actualizarVistas() {
        barraVidaJugador.setProgress(
                (double) combate.getJugador().getStats().getVidaActual() /
                        combate.getJugador().getStats().getVidaMaxima()
        );
        barraVidaEnemigo.setProgress(
                (double) combate.getEnemigo().getStats().getVidaActual() /
                        combate.getEnemigo().getStats().getVidaMaxima()
        );
        areaLog.setText(combate.getLog());
    }

    private void ejecutarTurno(Button btn) {
        if (btn.getUserData() == null) return;
        String habId = (String) btn.getUserData();
        combate.turnoJugador(habId);
        actualizarVistas();
    }

    @FXML private void onHab1() { ejecutarTurno(btnHab1); }
    @FXML private void onHab2() { ejecutarTurno(btnHab2); }
    @FXML private void onHab3() { ejecutarTurno(btnHab3); }
    @FXML private void onHab4() { ejecutarTurno(btnHab4); }
    @FXML private void onHab5() { ejecutarTurno(btnHab5); }
}