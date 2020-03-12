/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.main;

/**
 * FXML Controller class
 *
* @author João Vitor
 * @author Andre
 */
public class menuIniciarController implements Initializable {

    /**
     * Initializes the controller class.
     *
     */
    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
    }

    @FXML
    private Button button;

    /**
     * Botão que inicia o jogo
     */
    @FXML
    void btnIniciar(ActionEvent event) {
        main.mudarTelas("jogo");
    }

}
