import java.util.Scanner;

//fix board[i].length -1s
public class TicTacToe
{
    public char [][] board = new char [3][3];
    public boolean [][] filled = new boolean [3][3];
    Scanner inp = new Scanner(System.in);
    
    public void printBoard(){
        int runs = 0;
        for (int i = 0; i < board.length; i++){
            
            for (int ii = 0; ii < board[i].length; ii++){
                
                if (filled[i][ii]){
                    System.out.print(board[i][ii]);
                }
                else{
                    System.out.print(" ");
                }
                
                if(ii != board[i].length - 1){
                    System.out.print("|");
                }
                else {
                    System.out.println();
                }
                
                
            }
            if(runs != board[i].length - 1){
                    System.out.println();
                    System.out.println("------");
                }
            runs++;
        }
    }
    
    public void playerTurn(char[][] brd, boolean [][] boolBrd, char playerSymb){
        int row = -1, column = -1;
        boolean done = false;
        while(!done){
            System.out.println("Select row");
            //save input -1
            row = inp.nextInt() - 1;
            System.out.println("Select column");
            //save input -1
            column = inp.nextInt() - 1;
            
            if (boolBrd[row][column]){
                System.out.println("This space is already filled, try again");
            }
            else {
                brd[row][column] = playerSymb;
                done = true;
            }
        }
              
    }
    
    public void pvpGame(){
        boolean gameComplete = false;
        HumanPlayer p1 = new HumanPlayer('x');
        HumanPlayer p2 = new HumanPlayer('o');
        resetBoard();
        while(!gameComplete){
            printBoard();
            
            if (!checkBoardFill()){
                p1.playerTurn(board, filled, p1.symb);
            }
            printBoard();
            if (!checkBoardFill() && !checkBoardWin(p1.symb)){
                p2.playerTurn(board, filled, p2.symb);
                printBoard();
            }
            else if (!checkBoardWin(p1.symb)){
                System.out.println("Player 1 \""+p1.symb+"\" has won, play again? (y/n)");
                if (inp.next() == "y"){
                    System.out.println("New Game");
                }
                else if (inp.next() == "n"){
                    gameComplete = true;
                }
            }
            
            if (checkBoardWin(p2.symb)) {
                System.out.println("Player 2 \""+p2.symb+"\" has won, play again? (y/n)");
                if (inp.next() == "y"){
                    System.out.println("New Game");
                }
                else if (inp.next() == "n"){
                    gameComplete = true;
                }
            }
            
            if (gameComplete){
                resetBoard();
            }
       }
    }
    
    public void cpuGame(){
        boolean gameComplete = false;
        HumanPlayer p1 = new HumanPlayer('x');
        CPUPlayer p2 = new CPUPlayer('o');
        while(!gameComplete){
            printBoard();
            if (checkBoardFill()){
                p1.playerTurn(board, filled, p1.symb);
            }
            printBoard();
            if (checkBoardFill() && !checkBoardWin(p1.symb)){
                p2.cpuTurn(board, filled, p2.symb);
                printBoard();
            }
            else if (checkBoardWin(p1.symb)){
                System.out.println("Player 1 \""+p1.symb+"\" has won, play again? (y/n)");
                if (inp.next() == "y"){
                    System.out.println("New Game");
                }
                else if (inp.next() == "n"){
                    gameComplete = true;
                }
            }
            
            if (checkBoardWin(p2.symb)) {
                System.out.println("Player 2 \""+p2.symb+"\" has won, play again? (y/n)");
                if (inp.next() == "y"){
                    System.out.println("New Game");
                }
                else if (inp.next() == "n"){
                    gameComplete = true;
                }
            }
            
            if (gameComplete){
                resetBoard();
            }
       }
    }
    
    private boolean checkBoardFill(){
        for (int i = 0; i < board.length -1; i++){           
            for (int ii = 0; ii < board[i].length -1; ii++){
                if (!filled[i][ii]){
                    return false;
                }
                System.out.println("test");
            }
        }
        
        return true;
    }
    
    private boolean checkBoardWin(char symb){
        for (int i = 0; i < board.length -1; i++){
            if (board[i][0] == symb && board[i][1] == symb && board[i][2] == symb){
                return true;
            }
        }
        for (int i = 0; i < board[i].length -1; i++){
            if (board[0][i] == symb && board[1][i] == symb && board[2][i] == symb){
                return true;
            }
        }
        if(board[0][0] == symb && board[1][1] == symb && board[2][2] == symb){
            return true;
        }
        else if (board[0][2] == symb && board[1][1] == symb && board[0][2] == symb){
            return true;
        }
        
        return false;
    }
    
    private void resetBoard(){
        for (int i = 0; i < board.length -1 -1; i++){           
            for (int ii = 0; ii < board[i].length -1; ii++){
                filled[i][ii] = false;                         
            }
        }
    }
}