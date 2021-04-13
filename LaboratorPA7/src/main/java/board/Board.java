package board;

import java.util.Random;

public class Board {
    private int[][] matrix;
    private int playerNr = 0;

    public Board(int length, int height){
        matrix = new int[length][height];
        populateBoard();
    }

    public void removeData(int coordI, int coordJ){
        matrix[coordI][coordJ] = -1;
    }

    public void setPlayerNr(int nr){
        playerNr = nr;
    }
    public int getPlayerNr(){
        return playerNr;
    }

    public int getLength(){
        return this.matrix.length;
    }
    public int getHeight(){
        return this.matrix[0].length;
    }

    public int[][] getMatrix(){
        return this.matrix;
    }
    public int getMatrixData(int coordI, int coordJ){
        return matrix[coordI][coordJ];
    }

    public void printMatrix(){
        for(int length=0; length < matrix.length; length++) {
            for (int heigth = 0; heigth < matrix[length].length; heigth++)
                System.out.print(matrix[length][heigth] + " ");
            System.out.print("\n");
        }
    }

    public boolean isEmpty(){
        for(int length=0; length < matrix.length; length++)
            for(int heigth=0; heigth < matrix[length].length; heigth++)
                if(matrix[length][heigth] != -1)
                    return false;
        return true;
    }

    public void resetData(){
        populateBoard();
    }

    private void populateBoard(){
        for(int length=0; length < matrix.length; length++)
            for(int heigth=0; heigth < matrix[length].length; heigth++)
                matrix[length][heigth] = new Random().nextInt(100);
    }
}
