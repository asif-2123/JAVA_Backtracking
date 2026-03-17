public class Rat {
    static int ways = 0 ;
    public static void ratInMaize(int maize[][],int i,int j,int sol[][]){
        //Base Case
        if(i==maize.length-1 && j==maize[0].length-1){
            sol[i][j]=1;                                // Marking the destination point in the sol matrix
            // Traversing the sol matrix 
            for(int k=0;k<sol.length;k++){
                for(int l=0;l<sol[0].length;l++){
                    System.out.print(sol[k][l]+" ");
                }
                System.out.println();
            }
            System.out.println();
            ways++;             
            return;
        }
        sol[i][j]=1;                // Marking 1 in the sol matrix to indicate that the rat is on that cell
        if(isSafe(maize,i+1,j)){
            // To move down in the maze
            ratInMaize(maize,i+1,j,sol);
        }
        if(isSafe(maize,i,j+1)){
            // To move right in the maze
            ratInMaize(maize,i,j+1,sol);
        }
        sol[i][j]=0;                // Unmarking the cell to indicate absence of the rat in cell

    }
    // To check if the current position is safe to move or not
    public static boolean isSafe(int maize[][],int i, int j) {
        if(i>=0 && j>=0 && i<maize.length && j<maize[0].length && maize[i][j]==1){
            return true ;
        }
        return false ;

    }
    public static void main(String args[]){
        int maize[][]={
            {1,0,0,0},
            {1,1,0,1},
            {1,1,0,0},
            {1,1,1,1}
        } ;
        int sol[][]=new int[maize.length][maize[0].length];   // To store the path of the rat in the maze
        ratInMaize(maize,0,0,sol);         // To find the path of the rat in the maze
        System.out.println(ways);
    }
}
