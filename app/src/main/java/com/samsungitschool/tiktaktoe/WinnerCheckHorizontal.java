package com.samsungitschool.tiktaktoe;

public class WinnerCheckHorizontal implements WinnerCheckInterface{
    private Game game;

    public WinnerCheckHorizontal(Game game){
        this.game = game;
    }

    @Override
    public Player checkWinner() {
        Square[][] field = game.getField();
        Player currPlayer;
        Player lastPlayer = null;
        int succesCounter = 1;
        for (int i = 0, len = field.length; i<len; i++){
            lastPlayer = null;
            succesCounter = 1;
            for (int j = 0, len2 = field[i].length; j < len2; j++){
                currPlayer = field[j][i].getPlayer();
                if (currPlayer == lastPlayer && (currPlayer != null && lastPlayer != null)){
                    succesCounter++;
                if (succesCounter == len2){ return currPlayer; }
                }
                lastPlayer = currPlayer;
                    }
                }
        return null;
    }}
