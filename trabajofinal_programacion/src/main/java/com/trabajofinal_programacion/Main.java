// package com.trabajofinal_programacion;
// 
// import com.trabajofinal_programacion.controller.PrimaryController;
// import com.trabajofinal_programacion.model.Criatura;
// import com.trabajofinal_programacion.model.Habilidad;
// import com.trabajofinal_programacion.controller.SecondaryController;
// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.image.Image;
// import javafx.stage.Stage;
// 
// import java.io.IOException;
// import java.util.Map;
// 
// public class Main extends Application {
// 
//     private Stage primaryStage;
// 
//     @Override
//     public void start(Stage stage) throws IOException {
//         this.primaryStage = stage;
//         stage.setResizable(false);
// 
//         try {
//             Image icon = new Image(
//                     Main.class.getResource("images/dragon.png").toExternalForm()
//             );
//             stage.getIcons().add(icon);
//         } catch (Exception e) {
//             System.err.println("Icono no encontrado (images/golem.png)");
//         }
// 
//         mostrarMenu();
//     }
// 
//     private void mostrarMenu() throws IOException {
//         FXMLLoader loader = new FXMLLoader(
//                 Main.class.getResource("primary.fxml")
//         );
//         Parent root = loader.load();
// 
//         PrimaryController controller = loader.getController();
//         controller.setMainApp(this);
// 
//         Scene scene = new Scene(root, 800, 600);
//         try {
//             scene.getStylesheets().add(
//                     Main.class.getResource("styles/styles.css").toExternalForm()
//             );
//         } catch (Exception e) {
//             System.err.println("styles.css no encontrado");
//         }
// 
//         primaryStage.setTitle("Juego de Combates");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }
// 
//     public void mostrarCombate(Criatura jugador,
//                                Criatura enemigo,
//                                Map<String, Habilidad> habilidades) {
//         try {
//             FXMLLoader loader = new FXMLLoader(
//                     Main.class.getResource("secondary.fxml")
//             );
//             Parent root = loader.load();
// 
//             SecondaryController controller = loader.getController();
//             controller.inicializar(jugador, enemigo, habilidades);
// 
//             Scene scene = new Scene(root, 800, 600);
//             try {
//                 scene.getStylesheets().add(
//                         Main.class.getResource("styles/styles.css").toExternalForm()
//                 );
//             } catch (Exception e) {
//                 System.err.println("styles.css no encontrado");
//             }
// 
//             primaryStage.setScene(scene);
//         } catch (IOException e) {
//             System.err.println("Error al cargar secondary.fxml");
//             e.printStackTrace();
//         }
//     }
// 
//     public static void main(String[] args) {
//         launch();
//     }
// }