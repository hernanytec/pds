package com.pds.boundary;

import com.pds.entity.GameOption;

import java.util.Random;
import java.util.Scanner;

public class Input {

    public GameOption readGameOption(){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        return this.convertInput(userInput);
    }

    private GameOption convertInput(String userInput){
        switch (userInput){
            case "1":
                return GameOption.PEDRA;
            case "2":
                return GameOption.PAPEL;
            case "3":
                return GameOption.TESOURA;
            case "4":
                return GameOption.PARAR;
            default:
                return GameOption.INVALIDA;
        }
    }

    public GameOption getRandomGameOption(){
        int choice = new Random().nextInt(2) + 1;
        return this.convertInput(String.valueOf(choice));
    }
}
