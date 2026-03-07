public class Find_Subsets {
    public static void findSubsets(String str,String ans,int i){
        // Base Case
        if(i==str.length()){
            if (ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        // To add the char
        findSubsets(str, ans+str.charAt(i), i+1);   // using i+1 to move to the next char
        // To not add the char
        findSubsets(str, ans, i+1);                 // i++ would let the recusion to start from the next char but we want to start from the current char so we use i+1
    }
    public static void main(String args[]){
        String str = "abc";
        findSubsets(str, "", 0);
    }
}
