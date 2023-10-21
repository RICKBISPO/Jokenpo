package model;

public class Papel extends Coisa {
    
    public Papel() {
        super("Papel");
    }

    @Override
    public int getResultadoPartida(Coisa escolhaDoOutroJogador) {
        
        int resultado;

        if (escolhaDoOutroJogador.getEscolha().equals("Tesoura")){
            resultado = 1; // outro jogador ganhou
        } 
        else if (escolhaDoOutroJogador.getEscolha().equals("Pedra")){
            resultado = 0; // outro jogador perdeu
        } 
        else{
            resultado = -1; // empate
        }

        return resultado;
    }
}
