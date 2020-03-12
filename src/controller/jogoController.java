/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import static main.main.stage;
import model.Carta;

/**
 * FXML Controller class
 *
 * @author João Vitor
 * @author Andre
 */
public class jogoController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gerarCartas();
        preencherPilha();
        mostrarPilhas();
        atualizaPilhas();
        setRegrasTxt();

    }

    int Njog = 0;

    boolean btnSelecionado = false;

    ArrayList<Carta> baralho = new ArrayList();

    long i = 0, j = 0, k = 0, hrs = 0;
    Timer tm = null;
    Stack<Carta> a = new Stack();
    Stack<Carta> b = new Stack();
    Stack<Carta> c = new Stack();
    Stack<Carta> d = new Stack();
    Stack<Carta> e = new Stack();
    Stack<Carta> f = new Stack();
    Stack<Carta> g = new Stack();
    Stack<Carta> h = new Stack();

    Stack<Carta> w = new Stack();
    Stack<Carta> x = new Stack();
    Stack<Carta> y = new Stack();
    Stack<Carta> z = new Stack();

    Stack<Carta> final0 = new Stack();
    Stack<Carta> final1 = new Stack();
    Stack<Carta> final2 = new Stack();
    Stack<Carta> final3 = new Stack();

    ImageView posicaoAtual = null;

    File file = new File("src/imagens/cartas/carta-vazia.png");

    Image cartaVazia = new Image(file.toURI().toString());

    /**
     * Método que fecha o jogo.
     *
     * @param event
     */
    @FXML
    void btnSair(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Método controlador de evento que inicia novo jogo.
     *
     * @param event
     */
    @FXML
    void btnNovoJogo(ActionEvent event) {

        novoJogo();
        k = i = hrs = j = 0;
        Njogadas.setText("N° de jogadas: 0");
        Njog = 0;
        InicioCr = true;
        tempo.setText("00:00:00");

    }

    /**
     * Método controlador de evento que chama o metodo fecharAlerta.
     *
     * @param event
     */
    @FXML
    void fecharAlert(ActionEvent event) {
        fecharAlerta();
    }
    boolean InicioCr = true;
    Carta cartaAux = null;

    Stack<Carta> pilhaAux = null;

    ImageView auxView = null;

    @FXML
    private Pane stackA;

    @FXML
    private Label textErro;

    @FXML
    private Label Njogadas;

    @FXML
    private Label NjogadasFinal;

    @FXML
    private Label NjogadasFinalG;

    @FXML
    private Label tempo;

    @FXML
    private Label tempoFinal;

    @FXML
    private Label tempoFinalG;

    @FXML
    private Pane paneErro;

    @FXML
    private StackPane paneGanhou;

    @FXML
    private Pane stackB;

    @FXML
    private Pane stackC;

    @FXML
    private Pane stackD;

    @FXML
    private Pane stackE;

    @FXML
    private Pane stackF;

    @FXML
    private Pane stackG;

    @FXML
    private Pane stackH;

    @FXML
    private ImageView pilha0;

    @FXML
    private ImageView pilha1;

    @FXML
    private ImageView pilha2;

    @FXML
    private ImageView pilha3;

    @FXML
    private ImageView reservaZ;

    @FXML
    private ImageView reservaY;

    @FXML
    private ImageView reservaX;

    @FXML
    private ImageView reservaW;

    @FXML
    private Label textRegras;

    @FXML
    void btn0(ActionEvent event) {
        verificaAcao(final0, pilha0);
    }

    @FXML
    void btn1(ActionEvent event) {
        verificaAcao(final1, pilha1);
    }

    @FXML
    void btn2(ActionEvent event) {
        verificaAcao(final2, pilha2);
    }

    @FXML
    void btn3(ActionEvent event) {
        verificaAcao(final3, pilha3);
    }

    @FXML
    void btnA(ActionEvent event) {
        verificaAcao(a, stackA);
    }

    @FXML
    void btnB(ActionEvent event) {
        verificaAcao(b, stackB);
    }

    @FXML
    void btnC(ActionEvent event) {
        verificaAcao(c, stackC);
    }

    @FXML
    private Pane paneRegra;

    @FXML
    private StackPane panePerdeu;

    @FXML
    void mostrarRegras(ActionEvent event) {
        paneRegra.setVisible(true);
        paneRegra.setDisable(false);
    }

    @FXML
    void fecharRegras(ActionEvent event) {
        paneRegra.setVisible(false);
        paneRegra.setDisable(true);
    }

    @FXML
    void btnD(ActionEvent event) {
        verificaAcao(d, stackD);

    }

    @FXML
    void btnE(ActionEvent event) {
        verificaAcao(e, stackE);

    }

    @FXML
    void btnF(ActionEvent event) {
        verificaAcao(f, stackF);

    }

    @FXML
    void btnG(ActionEvent event) {
        verificaAcao(g, stackG);

    }

    @FXML
    void btnH(ActionEvent event) {
        verificaAcao(h, stackH);

    }

    @FXML
    void btnW(ActionEvent event) {
        verificaAcao(w, reservaW);
    }

    @FXML
    void btnX(ActionEvent event) {
        verificaAcao(x, reservaX);
    }

    @FXML
    void btnY(ActionEvent event) {
        verificaAcao(y, reservaY);

    }

    @FXML
    void btnZ(ActionEvent event) {
        verificaAcao(z, reservaZ);

    }

    /**
     * Método que verifica qual a ultima imageView da pilha.
     *
     * @param cartasDaPilhas
     * @param pane
     */
   public void verificaAcao(Stack<Carta> cartasDaPilhas, Pane pane) {

        ImageView imgView;

        if (cartasDaPilhas.isEmpty()) {

            imgView = (ImageView) pane.getChildren().get(cartasDaPilhas.size());

        } else {
            imgView = (ImageView) pane.getChildren().get(cartasDaPilhas.size() - 1);

        }
        if (cartasDaPilhas.size() == 12) {
            if (btnSelecionado == true) {

                return;
            }
        }

        verificaAcao(cartasDaPilhas, imgView);
    }

    /**
     * Método que verifica qual ação deve ser executada e inicia o cronômetro da
     * partida.
     *
     * @param cartasDaPilhas 
     * @param imgView
     */
    public void verificaAcao(Stack<Carta> cartasDaPilhas, ImageView imgView) {
//      No primeiro clique do jogo inicia o tempo
        if (InicioCr) {
            tempoJogo();
        }

        InicioCr = false;
//       verifica se clicou em uma fileira vazia
        if (auxView == null) {
            if (cartasDaPilhas.isEmpty()) {
                return;
            }

            auxView = imgView;
            pilhaAux = cartasDaPilhas;
        }
//        verifica se tem btn selecionado
        if (btnSelecionado == false) {
          
            if (cartasDaPilhas.isEmpty()) {
                return;
            }

            auxView.setScaleX(0.9);
            auxView.setScaleY(0.9);
            auxView.setStyle("-fx-effect: dropshadow(three-pass-box, #ffcc01, 10, 0, 0, 0);");

            cartaAux = (Carta) cartasDaPilhas.lastElement();

            if (final0.isEmpty() == false) {
                if (cartaAux == final0.lastElement()) {
                    jogadaErrada("As cartas dessa pilhas não podem ser \n removidas");
                    desselecionar();
                    btnSelecionado = false;

                    return;
                }
            }
            if (final1.isEmpty() == false) {

                if (cartaAux == final1.lastElement()) {
                    jogadaErrada("As cartas dessa pilhas não podem ser \nremovidas");
                    desselecionar();
                    btnSelecionado = false;

                    return;
                }
            }
            if (final2.isEmpty() == false) {

                if (cartaAux == final2.lastElement()) {
                    jogadaErrada("As cartas dessa pilhas não podem ser \nremovidas");
                    desselecionar();
                    btnSelecionado = false;

                    return;
                }
            }
            if (final3.isEmpty() == false) {

                if (cartaAux == final3.lastElement()) {
                    jogadaErrada("As cartas dessa pilhas não podem ser \nremovidas");
                    desselecionar();
                    btnSelecionado = false;

                    return;
                }
            }

            btnSelecionado = true;
//         verifica se o jogador esta clicando na carta selecionada
        } else if (btnSelecionado == true && imgView.getScaleX() == 0.9) {
            desselecionar();

        } else if (verificaMovimento(cartasDaPilhas)) {
            moverCarta(cartasDaPilhas, imgView);
        } else {
            desselecionar();
        }

    }

    /**
     * Método que retira a carta de uma pilha com o pop() e coloca em outra
     * atraves do push() e depois verifica se o jogador ganhou ou perdeu a
     * partida.
     * @param pilha
     * @param imgView
     */
    public void moverCarta(Stack<Carta> pilha, ImageView imgView) {
        Njog += 1;
        Njogadas.setText("N° de jogadas: " + Njog);

        pilhaAux.pop();
        pilha.push(cartaAux);

        System.out.println(" ---------- MOVEU CARTA " + cartaAux + " ---------- ");

        atualizaPilhas();

        desselecionar();

        mostrarPilhas();

        if (verificaGanhou()) {
            ganhou();
        }
        if (verificaPerdeu()) {
            perdeu();
        }
    }

    /**
     * Método que seta as imageView de acordo com as pilhas
     *
     * @param s
     * @param imgView
     */
    public void setarFileira(Stack s, Pane imgView) {
        int size = imgView.getChildren().size() - 1;
        for (int indice = 0; indice <= size; indice++) {

            try {

                ImageView aux = (ImageView) imgView.getChildren().get(indice);
                String ca = s.get(indice).toString();
                File fileImg = new File("src/imagens/cartas/" + ca + ".png");
                Image carta = new Image(fileImg.toURI().toString());
                aux.setDisable(false);
                aux.setOpacity(1);
                aux.setImage(carta);

            } catch (Exception erro) {

                ImageView aux = (ImageView) imgView.getChildren().get(indice);
                aux.setDisable(true);
                aux.setOpacity(0);
                aux.setImage(cartaVazia);
            }

        }
    }

    /**
     * Método que cria os 52 objetos do tipo cartas, adiciona no baralho e
     * embaralha o mesmo.
     */
    public void gerarCartas() {
        for (int naipe = 0; naipe <= 3; naipe++) {
            for (int valor = 0; valor <= 12; valor++) {
                if (naipe == 0 || naipe == 2) {
                    baralho.add(new Carta(naipe, valorCarta(valor), 0));

                } else {
                    baralho.add(new Carta(naipe, valorCarta(valor), 1));
                }
            }
        }
        
        Collections.shuffle(baralho);
    }

    /**
     * Método que recebe um inteiro e retorna o valor da carta como string.
     * @param i
     * @return 
     */
    public  String valorCarta(int i) {
        switch (i) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            case 8:
                return "I";
            case 9:
                return "J";
            case 10:
                return "K";
            case 11:
                return "L";
            case 12:
                return "M";
        }
        return null;
    }

    /**
     * Método que recebe uma string e retorna o valor da carta como inteiro.
     * @param i
     * @return 
     */
    public  int valorCarta(String i) {
        switch (i) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            case "I":
                return 8;
            case "J":
                return 9;
            case "K":
                return 10;
            case "L":
                return 11;
            case "M":
                return 12;
        }
        return 404;
    }

    /**
     * Método que preenche as pilhas de A...H e remove as cartas do baralho.
     */
    public void preencherPilha() {
        int fileira = 0;

        for (int indice = 0; indice < baralho.size(); indice++) {

            if (fileira == 0) {
                a.push(baralho.get(indice));
            }
            if (fileira == 1) {
                b.push(baralho.get(indice));
            }
            if (fileira == 2) {
                c.push(baralho.get(indice));
            }
            if (fileira == 3) {
                d.push(baralho.get(indice));
            }
            if (fileira == 4) {
                e.push(baralho.get(indice));
            }
            if (fileira == 5) {
                f.push(baralho.get(indice));
            }
            if (fileira == 6) {
                g.push(baralho.get(indice));
            }
            if (fileira == 7) {
                h.push(baralho.get(indice));
                fileira = -1;
            }
            fileira++;
        }
        baralho.removeAll(baralho);
    }

    /**
     * Método que chama setarFileira para atualizar os estados das pilhas na
     * partida.
     */
    public void atualizaPilhas() {

        setarFileira(a, stackA);
        setarFileira(b, stackB);
        setarFileira(c, stackC);
        setarFileira(d, stackD);
        setarFileira(e, stackE);
        setarFileira(f, stackF);
        setarFileira(g, stackG);
        setarFileira(h, stackH);

        setarFileira(w, reservaW);
        setarFileira(x, reservaX);
        setarFileira(y, reservaY);
        setarFileira(z, reservaZ);

        setarFileira(final0, pilha0);
        setarFileira(final1, pilha1);
        setarFileira(final2, pilha2);
        setarFileira(final3, pilha3);
    }

    /**
     * Método que imprime todas as pilhas.
     */
    public  void mostrarPilhas() {

        System.out.println("Pilha A\n" + a.toString());
        System.out.println("Pilha B\n" + b.toString());
        System.out.println("Pilha C\n" + c.toString());
        System.out.println("Pilha D\n" + d.toString());
        System.out.println("Pilha E\n" + e.toString());
        System.out.println("Pilha F\n" + f.toString());
        System.out.println("Pilha G\n" + g.toString());
        System.out.println("Pilha H\n" + h.toString());

        System.out.println("Pilha W\n" + w.toString());
        System.out.println("Pilha X\n" + x.toString());
        System.out.println("Pilha Y\n" + y.toString());
        System.out.println("Pilha Z\n" + z.toString());

        System.out.println("Pilha 0\n" + final0.toString());
        System.out.println("Pilha 1\n" + final1.toString());
        System.out.println("Pilha 2\n" + final2.toString());
        System.out.println("Pilha 3\n" + final3.toString());

    }

    /**
     * Método que seta as imageView de acordo com as pilhas
     * @param pilhaCarta
     * @param imgView
     */
    public  void setarFileira(Stack<Carta> pilhaCarta, ImageView imgView) {

        try {

            String nomeCarta = pilhaCarta.lastElement().toString();
            File fileImg = new File("src/imagens/cartas/" + nomeCarta + ".png");
            Image carta = new Image(fileImg.toURI().toString());
            imgView.setImage(carta);

        } catch (Exception exception) {
            String text = imgView.getId();
            switch (text) {
                case "pilha0": {
                    String nomeCarta = "0";
                    File fileImg = new File("src/imagens/cartas/" + nomeCarta + ".png");
                    Image carta = new Image(fileImg.toURI().toString());
                    imgView.setImage(carta);
                    break;
                }
                case "pilha1": {
                    String nomeCarta = "1";
                    File fileImg = new File("src/imagens/cartas/" + nomeCarta + ".png");
                    Image carta = new Image(fileImg.toURI().toString());
                    imgView.setImage(carta);
                    break;
                }
                case "pilha2": {
                    String nomeCarta = "2";
                    File fileImg = new File("src/imagens/cartas/" + nomeCarta + ".png");
                    Image carta = new Image(fileImg.toURI().toString());
                    imgView.setImage(carta);
                    break;
                }
                case "pilha3": {
                    String nomeCarta = "3";
                    File fileImg = new File("src/imagens/cartas/" + nomeCarta + ".png");
                    Image carta = new Image(fileImg.toURI().toString());
                    imgView.setImage(carta);
                    break;
                }
                default:
                    imgView.setImage(cartaVazia);
                    break;
            }
        }

    }

    /**
     * Método que verifica as regras do jogo e retorna se a jogada é possivel ou
     * não.
     *
     * @param cartasDaPilhas
     * @return 
     */
    public  boolean verificaMovimento(Stack<Carta> cartasDaPilhas) {

        boolean check = regraPrincipal(cartasDaPilhas);

//        Regras reserva
        if ((cartasDaPilhas == w || cartasDaPilhas == x || cartasDaPilhas == y || cartasDaPilhas == z) && cartasDaPilhas.empty() == false) {
            jogadaErrada("Reserva cheia.");

            check = false;
        }
//        Regra Final
        if (cartasDaPilhas == final0) {
            if (cartaAux.getNaipe() == 0) {
                if (final0.isEmpty() && cartaAux.getValor().equals("A")) {
                    check = true;
                } else if (cartaAux.getValor().equals(valorCarta(final0.size()))) {
                    check = true;
                } else {
                    jogadaErrada("Pilhas base devem começar por um Ás e \ncrescer em um mesmo naipe, de Ás até Rei.");
                    check = false;
                }
            } else {
                jogadaErrada("A carta deve ser do mesmo naipe da base");
                check = false;
            }

        }
        if (cartasDaPilhas == final1) {
            if (cartaAux.getNaipe() == 1) {
                if (final1.isEmpty() && cartaAux.getValor().equals("A")) {
                    check = true;
                } else if (cartaAux.getValor().equals(valorCarta(final1.size()))) {
                    check = true;
                } else {
                    jogadaErrada("Pilhas base devem começar por um Ás e \ncrescer em um mesmo naipe, de Ás até Rei.");
                    check = false;
                }

            } else {
                jogadaErrada("A carta deve ser do mesmo naipe da base");
                check = false;
            }
        }
        if (cartasDaPilhas == final2) {
            if (cartaAux.getNaipe() == 2) {
                if (final2.isEmpty() && cartaAux.getValor().equals("A")) {
                    check = true;

                } else if (cartaAux.getValor().equals(valorCarta(final2.size()))) {
                    check = true;
                } else {
                    jogadaErrada("Pilhas base devem começar por um Ás e \ncrescer em um mesmo naipe, de Ás até Rei.");
                    check = false;
                }
            } else {
                jogadaErrada("A carta deve ser do mesmo naipe da base");
                check = false;
            }
        }
        if (cartasDaPilhas == final3) {
            if (cartaAux.getNaipe() == 3) {
                if (final3.isEmpty() && cartaAux.getValor().equals("A")) {
                    check = true;

                } else if (cartaAux.getValor().equals(valorCarta(final3.size()))) {
                    check = true;
                } else {
                    jogadaErrada("Pilhas base devem começar por um Ás e \ncrescer em um mesmo naipe, de Ás até Rei.");
                    check = false;
                }
            } else {
                jogadaErrada("A carta deve ser do mesmo naipe da base");
                check = false;
            }
        }

        // Caso não alguma das regras não seja atendida
        if (!check) {
            System.err.println("Regra não aceita");
        }
        return check;
    }

    /**
     * Método que inicia um novo jogo setando variaveis auxiliares como nulas,
     * removendo todos os objetos das pilhas e posteriormente chamando os
     * metodos gerarCartas(), preencherPilha(), mostrarPilhas(),
     * atualizaPilhas();.
     */
    public void novoJogo() {

        System.out.println("           ------------- NOVO JOGO -------------");

        if (!InicioCr) {
            tm.cancel();
        }

        paneGanhou.setDisable(true);
        paneGanhou.setVisible(false);

        panePerdeu.setDisable(true);
        panePerdeu.setVisible(false);

        auxView = null;
        cartaAux = null;
        btnSelecionado = false;

        a.removeAllElements();
        b.removeAllElements();
        c.removeAllElements();
        d.removeAllElements();
        e.removeAllElements();
        f.removeAllElements();
        g.removeAllElements();
        h.removeAllElements();

        final0.removeAllElements();
        final1.removeAllElements();
        final2.removeAllElements();
        final3.removeAllElements();

        w.removeAllElements();
        x.removeAllElements();
        y.removeAllElements();
        z.removeAllElements();

        gerarCartas();
        preencherPilha();
        mostrarPilhas();
        atualizaPilhas();
    }

    /**
     * Método que seta estilo da carta ao padrão e seta variaveis auxiliares
     * como nula.
     */
    public void desselecionar() {

        cartaAux = null;

        auxView.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);\n"
                + "-fx-scale-y: 1;-fx-scale-x: 1;");
        auxView = null;
        pilhaAux = null;
        btnSelecionado = false;
    }

    /**
     * Método que verifica as regras das fileiras A..H do jogo e retorna se a
     * jogada é possivel ou não.
     *
     * @param cartasDaPilhas
     * @return 
     */
    public boolean regraPrincipal(Stack<Carta> cartasDaPilhas) {

        if (cartasDaPilhas.isEmpty()) {
            return true;
        }

        Carta cartaAtual = cartasDaPilhas.lastElement();
        Carta cartaAnterior = pilhaAux.lastElement();

        int intCartaAtual = valorCarta(cartaAtual.getValor());
        int intCartaAnterior = valorCarta(cartaAnterior.getValor());
        
        if (intCartaAtual > intCartaAnterior) {
            if (valorCarta(intCartaAnterior + 1).equals(valorCarta(intCartaAtual))) {
                if (cartaAtual.getNaipe() != cartaAnterior.getNaipe() && cartaAtual.getCor() != cartaAnterior.getCor()) {
                    return true;
                }

            }

        }
//        verifica se a jogada esta sendo realizada entre as pilha A...H
        if (cartasDaPilhas == a || cartasDaPilhas == b || cartasDaPilhas == c || cartasDaPilhas == d || cartasDaPilhas == e || cartasDaPilhas == f || cartasDaPilhas == g || cartasDaPilhas == h) {
            if (pilhaAux == a || pilhaAux == b || pilhaAux == c || pilhaAux == d || pilhaAux == e || pilhaAux == f || pilhaAux == g || pilhaAux == h) {
                jogadaErrada("Não é permitido esse tipo de movimento");
            }
        }

        return false;
    }

    /**
     * Método que fecha o aviso de jogada errada.
     *
     */
    public void fecharAlerta() {
        paneErro.setVisible(false);
        paneErro.setDisable(true);
    }

    /**
     * Método que exibe quando uma jogada está errada.
     *
     * @param erro
     */
    public void jogadaErrada(String erro) {
        textErro.setText(erro);
        paneErro.setVisible(true);
        paneErro.setDisable(false);
    }

    /**
     * Executa um cronometro que conta quanto tempo se passou no jogo. Isso
     * provavelmente é uma pessima pratica de programação, mas atende a
     * exigencia então...
     */
    @Deprecated
    public void tempoJogo() {

        tm = new Timer();
        TimerTask task;
        task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    stage.setFullScreen(true);
                    i++;
                    j = i % 60;
                    k = i / 60;
                    hrs = k / 60;
                    k %= 60;
                    tempo.setText(String.format("%02d:%02d:%02d", hrs, k, j));
                });
            }

        };
        tm.scheduleAtFixedRate(task, 1000, 1000);

    }

    /**
     * Método que verifica se ainda tem jogada possivel.
     *
     * @return 
     */
   public boolean verificaPerdeu() {
        if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty() || e.isEmpty() || f.isEmpty() || g.isEmpty() || h.isEmpty()) {
            return false;
        }
        if (w.isEmpty() || y.isEmpty() || x.isEmpty() || z.isEmpty()) {
            return false;
        }
        boolean check = false;
        Stack[] baralhoPilha = new Stack[12];

        baralhoPilha[0] = a;
        baralhoPilha[1] = b;
        baralhoPilha[2] = c;
        baralhoPilha[3] = d;
        baralhoPilha[4] = e;
        baralhoPilha[5] = f;
        baralhoPilha[6] = g;
        baralhoPilha[7] = h;

        baralhoPilha[8] = w;
        baralhoPilha[9] = x;
        baralhoPilha[10] = y;
        baralhoPilha[11] = z;
        
        Carta um, dois;
        
        for (Stack stackUm : baralhoPilha) {
            for (Stack stackDois : baralhoPilha) {
                um = (Carta) stackUm.lastElement();
                dois = (Carta) stackDois.lastElement();
                if (um.equals(w.lastElement()) || um.equals(x.lastElement()) || um.equals(y.lastElement()) || um.equals(z.lastElement())) {

                } else {

                    if (podeJogar(um)) {

                        return false;
                    }
                    if (podeJogar(um, dois)) {

                        return false;
                    } else {
                        check = true;
                    }
                }

            }
        }

        return check;
    }

    /**
     * Método que verifa se pode mover uma carta de uma pilha para outra.
     *
     * @param cartaAnterior
     * @param cartaAtual
     * @return 
     */
    public boolean podeJogar(Carta cartaAnterior, Carta cartaAtual) {
        boolean check = false;
        int intCartaAtual = valorCarta(cartaAnterior.getValor());
        int intCartaAnterior = valorCarta(cartaAtual.getValor());

        if (intCartaAtual > intCartaAnterior) {
            if (valorCarta(intCartaAnterior + 1).equals(valorCarta(intCartaAtual))) {
                if (cartaAtual.getNaipe() != cartaAnterior.getNaipe() && cartaAtual.getCor() != cartaAnterior.getCor()) {
                    return true;
                }

            }

        }
        return check;
    }

    /**
     * Método que seta a label que exibe as regras.
     *
     */
    public void setRegrasTxt() {

        textRegras.setText("A ideia é movimentar todas as cartas contidas nas pilhas do meio\n"
                + "para as pilhas superiores da direita, podendo-se utilizar os \n"
                + "espaços reservas do canto superior esquerdo para armazenamento\n"
                + "temporário de cartas.\nPara mover as cartas utilize o mouse, clicando em uma carta e depois clicando onde deseja inserir.\n"
                + "Algumas regras devem ser seguidas:\n"
                + "* A ordem crescente das cartas é: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K;\n"
                + "* A inserção de cartas nas pilhas do meio deve respeitar a ordem decrescente \n"
                + "e ainda duas cartas adjacentes não devem ter a mesma cor: preta (paus e espada)\n"
                + "e vermelha (ouro e copas). Como exemplo, a seguinte ordem de cartas é aceita:\n"
                + "Rei de paus (K), Dama de ouro (Q), Valete de espada (J), 10 de ouro, 9 de\n"
                + "espada, 8 de copas. Assim a última carta colocada na pilha é 8 de copas.\n"
                + " Se a pilha estiver vazia, qualquer carta é aceita;\n"
                + "* Em cada uma das pilhas finais deve haver apenas cartas de mesmo naipe e\n"
                + "em ordem crescente: por exemplo, na pilha 0, primeiro deve-se colocar um às\n"
                + "de copas, depois, sobre o às de copas, deve-se colocar um 2 de copas, e assim\n"
                + "por diante;\n"
                + "* Cada espaço reserva pode armazenar no máximo uma carta;\n"
                + "*As cartas devem ser movimentadas seguindo a definição de pilhas:\n"
                + "A última carta colocada na pilha deve ser a primeira a ser retirada da pilha.");

    }

    /**
     * Método que veridica se todas as pilhas finais tem 13 cartas caso sim
     * chama o método ganhou.
     *
     * @return 
     */
    public boolean verificaGanhou() {

        if (final0.size() == 13 && final1.size() == 13 && final2.size() == 13 && final3.size() == 13) {
            ganhou();
            return true;
        }
        return false;
    }

    /**
     * Método cancela o timer e exibe a mensagem de ganhador.
     *
     */
    public void ganhou() {
        tm.cancel();
        NjogadasFinalG.setText(Njogadas.getText());
        tempoFinalG.setText(tempo.getText());
        paneGanhou.setDisable(false);
        paneGanhou.setVisible(true);

    }

    /**
     * Método cancela o timer e exibe a mensagem de derrota.
     *
     */
    public void perdeu() {
        tm.cancel();
        NjogadasFinal.setText(Njogadas.getText());
        tempoFinal.setText(tempo.getText());
        panePerdeu.setDisable(false);
        panePerdeu.setVisible(true);
    }

    /**
     * Método que verifa se pode mover uma carta de uma pilha para outra.
     *
     * @param um
     * @return 
     */
    public boolean podeJogar(Carta um) {

        boolean check = false;

        if (um.getNaipe() == 0) {
            if (final0.isEmpty() && um.getValor().equals("A")) {
                check = true;
            } else if (um.getValor().equals(valorCarta(final0.size()))) {
                check = true;
            }
        }
        if (um.getNaipe() == 1) {
            if (final1.isEmpty() && um.getValor().equals("A")) {
                check = true;
            } else if (um.getValor().equals(valorCarta(final1.size()))) {
                check = true;
            }
        }
        if (um.getNaipe() == 2) {
            if (final2.isEmpty() && um.getValor().equals("A")) {
                check = true;
            } else if (um.getValor().equals(valorCarta(final2.size()))) {
                check = true;
            }
        }
        if (um.getNaipe() == 3) {
            if (final3.isEmpty() && um.getValor().equals("A")) {
                check = true;
            } else if (um.getValor().equals(valorCarta(final3.size()))) {
                check = true;
            }
        }

        return check;

    }

}
