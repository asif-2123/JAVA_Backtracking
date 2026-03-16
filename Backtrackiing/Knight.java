public class Knight {

    public static boolean knightTour(int board[][], int row, int col, int move) {
        int n = board.length;
        // Base case
        if (move == n * n) {
            board[row][col] = move;    // Marking the last move of the knight in the board
            printBoard(board);
            return true;
        }

        board[row][col] = move;        // Marking the current move of the knight in the board
        // Corresponding row changes for the knight's moves
        int[] dr = {2, 1, -1, -2, -2, -1, 1, 2};
        // Corresponding column changes for the knight's moves
        int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
        // Traversing the possible moves of the knight and making recursive calls
        for (int i = 0; i < 8; i++) {
            int nr = row + dr[i];       // new row after the knight's move
            int nc = col + dc[i];       // new column after the knight's move
            // To check if the new position is safe to move
            if (isSafe(board, nr, nc, n)) {
                // Move the knight to the new position and check for the next move
                if (knightTour(board, nr, nc, move + 1))
                    return true;
            }
        }
        // Move to previous position 
        board[row][col] = 0;             // Backtracking
        return false;
    }
    // To check if the knight can move to the given position or not
    public static boolean isSafe(int board[][], int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n && board[row][col] == 0;
    }
    // To print the board
    public static void printBoard(int board[][]) {
        System.out.println("---- Chess Board ----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print( board[i][j] + " ");  
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 8;  
        int board[][] = new int[n][n];
        knightTour(board, 0, 0, 1);
    }
}