package com.samsungitschool.tiktaktoe;

public class WinnerCheckDiagonalLeft implements WinnerCheckInterface{
    private Game game;

    public WinnerCheckDiagonalLeft(Game game){
        this.game = game;
    }

    @Override
    public Player checkWinner() {
        Square[][] field = game.getField();
        Player currPlayer;
        Player lastPlayer = null;
        int succesCounter = 1;
        for (int i = 0, len = field.length; i<len; i++){
            currPlayer = field[i][i].getPlayer();
            if (currPlayer !=null){
                if (lastPlayer != null){
                    succesCounter++;
                    if (succesCounter == len){
                        return currPlayer;
                    }
                }
            }
            lastPlayer = currPlayer;
        }
        return null;
    }
}
