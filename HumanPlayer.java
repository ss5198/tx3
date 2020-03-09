import java.util.Scanner;
public class HumanPlayer
{
    Scanner inp2 = new Scanner(System.in);
    public char symb;
    
    public HumanPlayer(char x){
        this.symb = x;
    }
    
    public void playerTurn(char[][] brd, boolean [][] boolBrd, char playerSymb){
        int row = -1, column = -1;
        boolean done = false;
        while(!done){
            System.out.println("Select row");
            //save input -1
            row = inp2.nextInt() - 1;
            System.out.println("Select column");
            //save input -1
            column = inp2.nextInt() - 1;
            
            if (boolBrd[row][column]){
                System.out.println("This space is already filled, try again");
            }
            else {
                brd[row][column] = playerSymb;
                done = true;
            }
        }
              
    }
    
    
}
