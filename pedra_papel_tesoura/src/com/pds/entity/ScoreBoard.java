package com.pds.entity;

public class ScoreBoard {
    private final GameOption userOption;
    private final GameOption machineOption;
    private final GameResult result;

    public  ScoreBoard(GameOption userOption, GameOption machineOption, GameResult gameResult){
        this.userOption = userOption;
        this.machineOption = machineOption;
        this.result = gameResult;
    }

    public GameResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "userOption=" + userOption +
                ", machineOption=" + machineOption +
                ", result=" + result +
                '}';
    }
}
