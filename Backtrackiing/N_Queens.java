public class N_Queens {
    static int count = 0;
    // To place the queens in the chess board such that they do not attack each other
    public static void nQueens(char board[][],int row){
        // Base Case
        if(row==board.length){
            printBoard(board);
            count++;
            return;
        }
        // To place the queen and check for the next row
        for (int j=0;j<board.length;j++){
            // To check if it is safe to place the queen at the given position  
            if(isSafe(board,row,j)){
                board[row][j] = 'Q' ;      // place the queen
                nQueens(board, row+1);     // recursion for the next row
                board[row][j] = 'x' ;      // backtracking to remove the queen and check for the next position
            }
        }
    }
    // To check if it is safe to place the queen at the given position
    public static boolean isSafe(char board[][],int row,int col){
        // Vertically up
        for (int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // Diagonally left up
        for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        // Diagonally right up
        for (int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true ;
    }    
    // To print the board
    public static void printBoard(char board[][]){
        System.out.println("------Chess Board------");
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int n= 4 ;
        char [][] board = new char[n][n] ;
        // initialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 'x'  ;
            }
        }
        nQueens(board,0);
        System.out.println("Total ways to place the queens : "+count);
    }
}
