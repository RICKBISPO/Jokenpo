package model;

public abstract class Coisa {
     
    protected String escolha;

    public Coisa(String escolha) {
        this.escolha = escolha;
    }

    public abstract int getResultadoPartida(Coisa escolhaDoOutroJogador);

    public void setEscolha(String escolha) {
        this.escolha = escolha;
    }

    public String getEscolha() {
        return escolha;
    }
}