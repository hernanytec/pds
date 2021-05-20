package com.pds.controller;

import com.pds.boundary.Input;
import com.pds.boundary.Input.GameOption;
import com.pds.boundary.Output;
import com.pds.entity.Match;
import com.pds.entity.ScoreBoard;

import java.util.ArrayList;

public class GameController {

    private Input input;
    private Output output;
    private final ArrayList<ScoreBoard> scoreBoardArray = new ArrayList<>();

    public GameController(){
        output = new Output();
        input = new Input();
    }

    public void start(){
        initGameLoop();

        output.showScore(scoreBoardArray);
    }

    private void initGameLoop(){
        while (true){
            output.showOptions();

            GameOption userOption = input.readGameOption();

            if(userOption == GameOption.PARAR) break;

            if(userOption == GameOption.INVALIDA) {
                output.showInvalidOptionMessage();
                continue;
            }

            this.playMatch(userOption);
        }
    }

    private void playMatch(GameOption userOption){
        Match match = new Match();
        ScoreBoard scoreBoard = match.play(userOption);

        scoreBoardArray.add(scoreBoard);
    }
}