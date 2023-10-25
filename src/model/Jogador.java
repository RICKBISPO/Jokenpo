package model;

import java.util.Random;

public class Jogador {
    
    private String nome;
    private Coisa escolha;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public Coisa fazerEscolha() {
        
        Random random = new Random();
        int escolhaAleatoria = random.nextInt(3); 

        if (escolhaAleatoria == 0) {
            escolha = new Pedra();
        } else if (escolhaAleatoria == 1) {
            escolha = new Papel();
        } else if (escolhaAleatoria == 2) {
            escolha = new Tesoura();
        }

        return escolha;
    }

    public Coisa fazerEscolha(int escolhaExata) {

        if (escolhaExata == 0) {
            escolha = new Pedra();
        } else if (escolhaExata == 1) {
            escolha = new Papel();
        } else if (escolhaExata == 2) {
            escolha = new Tesoura();
        }

        return escolha;
    }

    public int compararResultado(Jogador outroJogador) {
        Coisa escolhaDoOutroJogador = outroJogador.getEscolha();
        return escolha.getResultadoPartida(escolhaDoOutroJogador);
    }

    public String getNome() {
        return nome;
    }

    public Coisa getEscolha() {
        return escolha;
    }
}
