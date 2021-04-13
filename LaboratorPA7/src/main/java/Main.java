import board.Board;
import player.Player;
import thread.PlayerThread;
import timekeeper.TimeKeeper;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Board length: ");
        int length = Integer.parseInt(scanner.nextLine());
        System.out.println("Board height: ");
        int height = Integer.parseInt(scanner.nextLine());
        Board board = new Board(length,height);
        board.printMatrix();

        System.out.println("Player1 name:");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1);
        Thread thread1 = new PlayerThread(player1, board, 0, true);

        System.out.println("Player2 name:");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2);
        Thread thread2 = new PlayerThread(player2, board, 1, true);

        Thread timeKeeper = new TimeKeeper(5,board);

        thread1.start();
        thread2.start();
        timeKeeper.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(player1.getScore() > player2.getScore())
            System.out.println("Player1 (" + player1.getName() + ") WINS!");
        else if(player1.getScore() < player2.getScore())
            System.out.println("Player2 (" + player2.getName() + ") WINS!");
        else
            System.out.println("TIE GAME");
        scanner.close();
    }
}
