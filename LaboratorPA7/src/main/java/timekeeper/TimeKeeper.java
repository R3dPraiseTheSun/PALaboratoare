package timekeeper;

import board.Board;

import java.util.concurrent.TimeUnit;

public class TimeKeeper extends Thread{
        private int time;
        private Board board;

    public TimeKeeper(int time, Board board) {
        this.time = time;
        this.board = board;
    }

    @Override
    public void run() {
        while (time != 0 && !board.isEmpty()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time--;
        }
        board.resetData();
        System.out.println("Finish!");
    }
}
