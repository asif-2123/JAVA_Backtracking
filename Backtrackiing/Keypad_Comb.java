// "23" -> "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
public class Keypad_Comb {
    // Keypad
    static String[] keypad = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public static void combinations(String digits, int index, StringBuilder sb) {
        // base case
        if (index == digits.length()) {
            System.out.print(sb.toString()+" ");
            return;
        }
        // get the letters corresponding to the current digit
        String letters = keypad[digits.charAt(index) - '0'];
        // Traversing the letters and making recursive calls
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));        // choose
            combinations(digits, index + 1, sb); // go to the next digit
            sb.deleteCharAt(sb.length() - 1);    // backtrack
        }
    }
    public static void main(String[] args) {
        combinations("23", 0, new StringBuilder());
    }
}
