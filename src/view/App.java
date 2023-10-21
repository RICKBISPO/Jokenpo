package view;

import java.util.Arrays;

import javax.swing.*;
import model.*;

public class App {
    public static void main(String[] args) {
        
        String nomeJogador1 = "";
        String nomeJogador2 = "";

        // Usa arraylist para criar modo de jogo
        String[] options = {"Humano vs. Humano", "Humano vs. Máquina", "Máquina vs. Máquina"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        JCheckBox checkBox = new JCheckBox("Melhor de 3");

        Object[] message = {
            "Escolha o modo de jogo:", comboBox,
            "Jogar melhor de 3?", checkBox
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Configuração de Jogo", JOptionPane.OK_CANCEL_OPTION);

        // Selecionar modo de jogo
        if (option == JOptionPane.OK_OPTION) {

            int modo = comboBox.getSelectedIndex();

            if (modo == 0){
                nomeJogador1 = JOptionPane.showInputDialog("Digite o nome do Jogador 1:");
                nomeJogador2 = JOptionPane.showInputDialog("Digite o nome do Jogador 2:");
            } 
            else if (modo == 1){
                nomeJogador1 = JOptionPane.showInputDialog("Digite o nome do Jogador 1:");
                nomeJogador2 = "Máquina";
            } 
            else if (modo == 2){
                nomeJogador1 = "Máquina 1";
                nomeJogador2 = "Máquina 2";
            }

            // Instancia os 2 jogadores 
            Jogador jogador1 = new Jogador(nomeJogador1);
            Jogador jogador2 = new Jogador(nomeJogador2);

            // Se a checkbox de melhor de 3 for selecionada altera o numero de partidas
            int numeroPartidas = 1;

            if (checkBox.isSelected()){
                numeroPartidas = 3;
            }
            
            // Roda partida unica ou melhor de 3
            for (int partida = 1; partida <= numeroPartidas; partida++) {
                
                // Opcoes de escolha
                String[] opcoes = {"Pedra", "Papel", "Tesoura"};
                
                switch (modo) {
                    // Humano x humano
                    case 0:

                        String escolhaJogador1 = (String) JOptionPane.showInputDialog(null, jogador1.getNome() + ", escolha a sua jogada:",
                        jogador1.getNome(), JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

                        String escolhaJogador2 = (String) JOptionPane.showInputDialog(null, jogador2.getNome() + ", escolha a sua jogada:",
                        jogador2.getNome(), JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                        
                        // Converte as escolhas do jogador 1 e jogador 2 em números (0, 1 ou 2)
                        int escolhaNumericaJogador1 = Arrays.asList(opcoes).indexOf(escolhaJogador1);
                        int escolhaNumericaJogador2 = Arrays.asList(opcoes).indexOf(escolhaJogador2);

                        jogador1.fazerEscolhaExata(escolhaNumericaJogador1);
                        jogador2.fazerEscolhaExata(escolhaNumericaJogador2);
                        break;
                   // Humano x maquina
                    case 1:

                        jogador2.fazerEscolhaAleatória(); 
                        
                        String escolhaJogadorUnico = (String) JOptionPane.showInputDialog(null, jogador1.getNome() + ", escolha a sua jogada:",
                        jogador1.getNome(), JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

                        int escolhaNumericaJogadorUnico = Arrays.asList(opcoes).indexOf(escolhaJogadorUnico);
                        
                        jogador1.fazerEscolhaExata(escolhaNumericaJogadorUnico);
                    break;
                    // Maquina x maquina
                    case 2:

                        jogador1.fazerEscolhaAleatória();
                        jogador2.fazerEscolhaAleatória();
                        break;
                }

                // Gera o resultado
                int resultado = jogador1.compararResultado(jogador2);

                // Exibe o resultado
                String mensagem = "Resultado da Partida:\n";

                if (resultado == 0) {
                    mensagem += "Empate!";
                } else if (resultado == 1) {
                    mensagem += jogador2.getNome() + " ganhou!";
                } else {
                    mensagem += jogador1.getNome() + " ganhou!";
                }

                mensagem += "\n\n" + jogador1.getNome() + " escolheu " + jogador1.getEscolha().getEscolha() + "\n";
                mensagem += jogador2.getNome() + " escolheu " + jogador2.getEscolha().getEscolha();

                JOptionPane.showMessageDialog(null, mensagem);
            }
        }
    }
}
