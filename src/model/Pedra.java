package model;

public class Pedra extends Coisa {

    public Pedra() {
        super("Pedra");
    }

    @Override
    public int getResultadoPartida(Coisa escolhaDoOutroJogador) {
        
        int resultado;

        if (escolhaDoOutroJogador.getEscolha().equals("Papel")){
            resultado = 1; // outro jogador ganhou
        } 
        else if (escolhaDoOutroJogador.getEscolha().equals("Tesoura")){
            resultado = 0; // outro jogador perdeu
        } 
        else{
            resultado = -1; // empate
        }

        return resultado;
    }
}
