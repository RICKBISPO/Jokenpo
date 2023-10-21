package model;

public class Tesoura extends Coisa {
    
    public Tesoura() {
        super("Tesoura");
    }

    @Override
    public int getResultadoPartida(Coisa escolhaDoOutroJogador) {
        
        int resultado;

        if (escolhaDoOutroJogador.getEscolha().equals("Pedra")){
            resultado = 1; // outro jogador ganhou
        } 
        else if (escolhaDoOutroJogador.getEscolha().equals("Papel")){
            resultado = 0; // outro jogador perdeu
        } 
        else{
            resultado = -1; // empate
        }

        return resultado;
    }
}
