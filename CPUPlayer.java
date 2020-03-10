

public class CPUPlayer
{
    String symb;
    public CPUPlayer(String x){
        this.symb = x;
    }
    
    public void cpuTurn(String[][] brd, boolean [][] boolBrd, String playerSymb){
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
    /*private boolean checkBoard(){
        for (int i = 0; i < board.length; i++){
            
                for (int ii = 0; ii < board[i].length; ii++){
                    if (!filled[i][ii]){
                        return false;
                    }
                              
                }  
            }
        return true;
    }*/
   
}
