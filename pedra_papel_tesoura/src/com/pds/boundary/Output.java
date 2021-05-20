package com.pds.boundary;

import com.pds.entity.ScoreBoard;
import com.pds.entity.ScoreBoard.GameResult;

import java.util.ArrayList;

public class Output {
    public void showOptions(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");
        System.out.println("4 - Parar o jogo");
    }

    public void showInvalidOptionMessage() {
        System.out.println("Opção inválida! Tente novamente.");
    }

    public void showScore(ArrayList<ScoreBoard> array){
        int vitorias = 0;
        int derrotas = 0;
        int empates = 0;

        for (ScoreBoard scoreboard: array) {
            GameResult result = scoreboard.getResult();

            switch (result){
                case VITORIA:
                    vitorias++;
                    break;
                case DERROTA:
                    derrotas++;
                    break;
                default:
                    empates++;
            }
        }

        System.out.println("O resultado foi de: " + vitorias + " vitórias, " + derrotas + " derrotas e " + empates + " empates");
    }
}
