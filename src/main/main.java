/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author João Vitor
 * @author Andre
 */
public class main extends Application {

    public static Stage stage;

    private static Scene sceneMenuIniciar;
    public static Scene sceneJogo;

    @Override
    public void start(Stage inicioStage) throws Exception {
        stage = inicioStage;
        inicioStage.setTitle("All In IFG");
        Parent fxmlMenu = FXMLLoader.load(getClass().getResource("/view/FXMLmenuIniciar.fxml"));
        sceneMenuIniciar = new Scene(fxmlMenu);
        Parent fxmlJogo = FXMLLoader.load(getClass().getResource("/view/FXMLjogo.fxml"));
        sceneJogo = new Scene(fxmlJogo);
        inicioStage.setScene(sceneMenuIniciar);
        inicioStage.setResizable(false);
        inicioStage.setFullScreen(true);
        inicioStage.show();

    }

    /**
     * Metodo para setar tela
     *
     * @param tela
     */
    public static void mudarTelas(String tela) {
        switch (tela) {
            case "menu":
                System.out.println("TELA MENU");
                stage.setScene(sceneMenuIniciar);
                stage.setFullScreen(true);
                break;
            case "jogo":
                System.out.println("TELA JOGO");
                stage.setScene(sceneJogo);
                stage.setFullScreen(true);
                break;
        }
    }
    /**
     * Metodo main
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
