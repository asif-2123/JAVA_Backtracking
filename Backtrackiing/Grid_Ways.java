public class Grid_Ways {
    public static int gridWays(int i,int j,int n,int m){
        // Base Case
        if(i==n-1 && j==m-1){
            return 1 ;                // to reach the destination there is only 1 way
        }else if(i==n || j==m){
            return 0 ;                // to go out of the grid there is no way
        }
        // Recursive Call
        int w1 = gridWays(i, j+1, n, m) ;         // right
        int w2 = gridWays(i+1, j, n, m) ;         // down
        return w1+w2 ;
    }
    public static void main(String[] args) {
        int n=3 , m=3 ;
        System.out.println(gridWays(0,0,n,m));

    }
}
