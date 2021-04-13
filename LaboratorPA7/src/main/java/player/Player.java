package player;

import board.Board;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Integer> integerList;
    private int score;

    public Player(String name){
        integerList = new ArrayList<Integer>();
        this.name = name;
        this.score = 0;
    }

    public void addData(int data){
        integerList.add(data);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int getScore(){
        return this.score;
    }

    public void getToken(Board board, int coordI,int coordJ){
        int[][] boardData = board.getMatrix();
        score += boardData[coordI][coordJ];
    }
}
