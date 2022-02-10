package com.samsungitschool.tiktaktoe;

public class Game {

    private Square[][] field;

    private Player[] players;

    private int squareCount;

    private boolean isStarted;

    private Player activePlayer;

    private int filled;

    private  WinnerCheckInterface[] winnerChecker;

    public Game(){
        field = new Square[3][3];

        for (int i = 0, l = field.length; i < l; i++){
            for (int j = 0, l2 = field[i].length; j < l2; j++){
                field[i][j] = new Square();
                squareCount++;
            }
        }

        players = new Player[2];
        isStarted = false;
        activePlayer = null;
        filled = 0;

        winnerChecker = new WinnerCheckInterface[4];
        winnerChecker[0] = new WinnerCheckHorizontal(this);
        winnerChecker[1] = new WinnerCheckVertical(this);
        winnerChecker[2] = new WinnerCheckDiagonalLeft(this);
        winnerChecker[3] = new WinnerCheckDiagonalRight(this);
    }

    private void resetPlayers(){
        players[0] = new Player("X");
        players[1] = new Player("O");
        setCurrentActivePlayer(players[0]);
    }

    private void setCurrentActivePlayer(Player player){
        activePlayer = player;
    }
    public Player getCurrentActivePlayer(){
        return activePlayer;
    }
    public void start(){
        isStarted = true;
        resetPlayers();
    }
    private void switchPlayer(){
        activePlayer = (activePlayer == players[0]) ? players[1] : players[0];
    }

    public boolean makeTurn(int x, int y){
        if (field[x][y].isFilled()) return false;

        field[x][y].fill(getCurrentActivePlayer());
        filled++;
        switchPlayer();
        return true;
    }

    public Square[][] getField () {
        return field;
    }

    public boolean isFieldFilled() {
        return squareCount == filled;
    }

    public void reset(){
        resetField();
        resetPlayers();
    }

    private void resetField(){
        for (int i = 0, l = field[i].length; i<l; i++) {
            for (int j = 0, l2 = field[i].length; j<l2; i++) {
                field[i][j].fill(null);
        }
    }
        filled = 0;
    }

    public Player checkWinner(){
        for (WinnerCheckInterface winchecker : winnerChecker){
            Player winner = winchecker.checkWinner();
            if (winner != null){
                return winner;
            }
        }
        return null;
    }
}
