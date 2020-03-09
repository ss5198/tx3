

public class CPUPlayer
{
    public char [][] board = new char [3][3];
    public boolean [][] filled = new boolean [3][3];
    char symb;
    public CPUPlayer(char x){
        this.symb = x;
    }
    
    public void cpuTurn(char[][] brd, boolean [][] boolBrd, char playerSymb){
        int row = -1, column = -1;
        boolean done = false;
        while(!done){
            System.out.println("Select row");
            //save input -1
            row = (int) (Math.random() * (double) 3);
            System.out.println("Select column");
            //save input -1
            column = (int) (Math.random() * (double) 3);
            
            if (boolBrd[row][column]){
                done = false;
            }
            else {
                brd[row][column] = playerSymb;
                done = true;
            }
        }
              
    }
    private boolean checkBoard(){
        for (int i = 0; i < board.length; i++){
            
                for (int ii = 0; ii < board[i].length; ii++){
                    if (!filled[i][ii]){
                        return false;
                    }
                              
                }  
            }
        return true;
    }
   
}
