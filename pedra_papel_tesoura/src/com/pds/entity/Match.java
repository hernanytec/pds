package com.pds.entity;

import com.pds.boundary.Input;
import com.pds.boundary.Input.GameOption;
import com.pds.entity.ScoreBoard.GameResult;

import static com.pds.boundary.Input.GameOption.PEDRA;
import static com.pds.boundary.Input.GameOption.PAPEL;
import static com.pds.boundary.Input.GameOption.TESOURA;

public class Match {

    public ScoreBoard play(GameOption userOption){
        GameOption machineOption = new Input().getRandomGameOption();

        GameResult gameResult = this.getGameResult(userOption, machineOption);

        ScoreBoard scoreBoard = new ScoreBoard(userOption, machineOption, gameResult);
        return scoreBoard;
    }

    private GameResult getGameResult(GameOption userOption, GameOption machineOption){
        if(userOption == machineOption) return GameResult.EMPATE;

        switch (userOption){
            case PAPEL:
                if((machineOption == PEDRA)) return GameResult.VITORIA;
            case PEDRA:
                if((machineOption == TESOURA)) return GameResult.VITORIA;
            case TESOURA:
                if((machineOption == PAPEL)) return GameResult.VITORIA;
            default:
                return GameResult.DERROTA;
        }
    }
}
