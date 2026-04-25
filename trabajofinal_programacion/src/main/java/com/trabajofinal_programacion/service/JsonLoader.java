// package com.trabajofinal_programacion.service;
// 
// import com.trabajofinal_programacion.Main;
// import com.trabajofinal_programacion.Criatura;
// import com.google.gson.Gson;
// import com.google.gson.reflect.TypeToken;
// 
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.Reader;
// import java.lang.reflect.Type;
// import java.util.Collections;
// import java.util.List;
// 
// public class JsonLoader {
// 
//     public static List<Criatura> cargarCriaturas() {
//         Gson gson = new Gson();
//         Type listType = new TypeToken<List<Criatura>>(){}.getType();
// 
//         InputStream is = Main.class.getResourceAsStream("data/criaturas.json");
//         if (is == null) {
//             System.err.println("No se ha encontrado data/criaturas.json");
//             return Collections.emptyList();
//         }
// 
//         try (Reader r = new InputStreamReader(is)) {
//             return gson.fromJson(r, listType);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return Collections.emptyList();
//         }
//     }
// }