public class Sudoku {
    // To solve the sudoku
    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        //Base case
        if(row==9){
            return true;
        }
        // Initialisation of the next row and column
        int nextRow = row , nextCol=col+1 ;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;              // Again 0 because we are moving to the next row
        }
        // To check if the current position is already filled then we will move to the next position
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow,nextCol );
        }
        // To fill the current position with the possible numbers from 1 to 9
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){   // Solution exists
                    return true;
                }
                // Backtracking to remove the digit and check for the next possible digit
                sudoku[row][col]=0;  
            }   
        }
        return false;             
    }
    // To check if it is safe to place the digit at the given position
    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        // Traverse the row and column
        // Column
        for (int i=0;i<9;i++){
            // To check if the digit is already present in the column
            if(sudoku[i][col]==digit){      
                return false;
            }
        }
        // Row
        for (int i=0;i<9;i++){
            // To check if the digit is already present in the row
            if(sudoku[row][i]==digit){
                return false;
            }
        }
        // 3*3 grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    // To print the sudoku
    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int board[][] ={ {0,0,8,0,0,0,0,0,0},
                        {4, 9, 0, 1, 5, 7, 0, 0, 2},
                        {0, 0, 3, 0, 0, 4, 1, 9, 0},
                        {1, 8, 5, 0, 6, 0, 0, 2, 0},
                        {0, 0, 0, 0, 2, 0, 0, 6, 0},
                        {9, 6, 0, 4, 0, 5, 3, 0, 0},
                        {0, 3, 0, 0, 7, 2, 0, 0, 4},
                        {0, 4, 9, 0, 3, 0, 0, 5, 7},
                        {8, 2, 7, 0, 0, 9, 0, 1, 3} };
        // To check if the solution exists or not
        if(sudokuSolver(board, 0, 0)){
            System.out.println("Solution Exists");
            printSudoku(board);
        }else{
            System.out.println("Solution does not exist");
        }

    }
}