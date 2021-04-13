package thread;

import board.Board;
import player.Player;

import java.util.Random;

public class PlayerThread extends Thread {
    Player player;
    Board board;
    int playerNr;
    boolean AI;

    public PlayerThread(Player player, Board board,  int playerNr, boolean isAI){
        this.player = player;
        this.board = board;
        this.playerNr = playerNr;
        this.AI = isAI;
    }

    @Override
    public void run() {
        if(AI)
            AI();
        else
            Human();
    }

    public void AI() {
        while (!board.isEmpty()) {
            synchronized (board) {
                if (playerNr != board.getPlayerNr()) {
                    try {
                        board.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!board.isEmpty()) {
                int randCoordI = new Random().nextInt(board.getLength());
                int randCoordJ = new Random().nextInt(board.getHeight());

                player.getToken(board,randCoordI,randCoordJ);
                player.addData(board.getMatrixData(randCoordI, randCoordJ));
                board.removeData(randCoordI, randCoordJ);
            }
            synchronized (board) {
                board.setPlayerNr(playerNr % 2 + 1);
                board.notify();
            }
        }
    }
    public void Human(){
        //TODO
    }
}
