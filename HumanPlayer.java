import java.util.Scanner;
public class HumanPlayer
{
    Scanner inp2 = new Scanner(System.in);
    public String symb;
    
    public HumanPlayer(String x){
        this.symb = x;
    }
    
    public int [] playerTurn(String[][] brd, boolean [][] boolBrd, String playerSymb){
        int row = -1, column = -1;
        boolean done = false;
        int [] place = new int [2];
        while(!done){
            System.out.println("Select row");
            //save input -1
            row = inp2.nextInt() - 1;
            
            System.out.println("Select column");
            //save input -1
            column = inp2.nextInt() - 1;
            
            System.out.println("row = " + row + " and col = " + column + " player " + playerSymb);
            
            if (boolBrd[row][column]){
                System.out.println("This space is already filled, try again");
            }   
            else {
                place [0] = row; place [1] = column; //problem line
                done = true;
                boolBrd [row][column] = true;
                System.out.println("valid turn");
            }
        }
           
        return place;
    }
    
    
}
