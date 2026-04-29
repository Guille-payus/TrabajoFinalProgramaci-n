package com.trabajofinal_programacion.service;

import com.trabajofinal_programacion.model.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JuegoService {

    private final List<Criatura> criaturas;
    private final Map<String, Habilidad> habilidades = new HashMap<>();

    public JuegoService() {
        cargarHabilidades();
        criaturas = JsonLoader.cargarCriaturas();
    }

    private void cargarHabilidades() {
        Habilidad[] arr = {
                new HabilidadFisica(),
                new HabilidadMagica(),
                new HabilidadCuracion(),
                new HabilidadEstado()
        };
        for (Habilidad h : arr) {
            habilidades.put(h.getId(), h);
        }
    }

    public List<Criatura> getCriaturas() { return criaturas; }
    public Map<String, Habilidad> getHabilidades() { return habilidades; }
}
