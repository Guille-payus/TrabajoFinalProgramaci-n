package com.trabajofinal_programacion.controller;

import com.trabajofinal_programacion.Main;
import com.trabajofinal_programacion.model.Criatura;
import com.trabajofinal_programacion.service.JuegoService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import java.io.IOException;

public class PrimaryController {

    @FXML private ListView<Criatura> listaJugador;
    @FXML private ListView<Criatura> listaEnemigo;
    @FXML private Button btnComenzar;
    @FXML private Button btnEnlace;

    private Main mainApp;
    private final JuegoService juegoService = new JuegoService();

    
    @FXML
    public void initialize() {
        // Cargar criaturas en ambas listas
        listaJugador.getItems().addAll(juegoService.getCriaturas());
        listaEnemigo.getItems().addAll(juegoService.getCriaturas());

        btnComenzar.setOnAction(e -> onComenzar());
        btnEnlace.setOnAction(e-> {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/Guille-payus/TrabajoFinalProgramaci-n/settings"));
            } catch (IOException | URISyntaxException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    private void onComenzar() {
        Criatura jugador = listaJugador.getSelectionModel().getSelectedItem();
        Criatura enemigo = listaEnemigo.getSelectionModel().getSelectedItem();

        if (jugador == null || enemigo == null) {
        
            return;
        }

        // Evitar que se elija la misma criatura para los dos
        if (jugador.getId().equals(enemigo.getId())) {
   
            return;
        }

        mainApp.mostrarCombate(jugador, enemigo, juegoService.getHabilidades());
    }
}