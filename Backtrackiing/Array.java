// Back Tracking example
public class Array {
    public static void changeArray(int arr[],int i,int val){
        // Base Case
        if(i==arr.length){
            printArray(arr);      // will return arr[]={1,2,3,4,5}
            return;
        }
        arr[i]=val;
        // Recursive call
        changeArray(arr,i+1,val+1);
        // Backtracking
        arr[i]=arr[i]-2;          // this will print arr[] = {-1 , 0 , 1 , 2 , 3}
    
    }
    //Print arrays
    public static void printArray(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(); 
    }
    public static void main(String[] args) {
        int arr[] = new int[5] ;
        changeArray(arr,0,1);
        printArray(arr);
    }
}