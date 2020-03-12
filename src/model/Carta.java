/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author João Vitor
 * @author Andre
 */
public class Carta {

    int naipe; //’0’ = copas, ’1’ = paus, ’2’ = ouro, ’3’= espada
    String valor; // 'A'= ás, 'B' = 2 'C' = 3,...  ’J’ = 10, ’K’ = Valete, ’L’ = Dama, ’M’ = Rei
    int cor; // 0="Vermelho", 1="Preto"

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public Carta(int naipe, String valor, int cor) {
        this.naipe = naipe;
        this.valor = valor;
        this.cor = cor;
    }

    public int getNaipe() {
        return naipe;
    }

    public void setNaipe(int naipe) {
        this.naipe = naipe;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.naipe + "-" + this.valor;
    }

}
