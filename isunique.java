// Q. isUnique : implement an algorithm to determine if a string has all the unique
// character , what if we are not allowded to use an extra data structure ? 
import java.util.*;


public class Main {
// NAIVE APPROACH
// if we are not allowed to use an extra data structure then this approach
// if we use the merge sort to sort the char array it takes o(nlogn) * merge sort
// and to iterate over all the sorted char arrays it takes 0(n) * linear time 
// overall time complexity is 0(nlogn) + 0(n) = 0(nlogn)
// space complexity is 0(n) becauese some sorting algorithm like merge sort use an exxtra space

    static boolean isUnique1(String s){
        char [] a = s.toCharArray();
        Arrays.sort(a);
        for(int i = 0 ; i < a.length - 1 ; i++){
            if(a[i] == a[i + 1]){
                return false;
            }
        }
        return true;
    }

// OPTIMAL APPROACH
// if we use the extra data structure or boolean array
// if the string has length over the 128 character then it return false
// then we change the status of respectibe index of the string in coolean array
// if the string at particular index is true in the boolean array and encounter again then it will be false
// if we successfully traverse all the arrays then it will return true.
// THE TIME COMPLEXITY IS 0(N) ANS SPACE COMPLEXITY IS 0(C) WHERE C = NUMBER OF LETTER IN THE STRING
// WE ALSO CAN ARGUE THAT THE COMPLEXITY IS 0(1) BECAUSE THE LOOP ONLY ITERATE 128 TIMES WHICH IS CONSTANT TIME.
    static boolean isUnique(String s){
        if(s.length() > 128){
            return false;
        }

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < s.length(); i++){
            if(char_set[s.charAt(i)]){
                return false;
            }
            char_set[s.charAt(i)] = true;
        }
        return true;

    }

    public static void main(String args[]) {
        System.out.println("Hello World!");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isUnique(s));
        System.out.println(isUnique1(s));
    }
}