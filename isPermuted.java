// Q. check permutation  : given two strings , write a method to decode
// if one is the permutation of another string?
// ask the interviewer that if the permutation is case sensitive or not ,or what about the white spaces.

// * considering that the comparision is case sensitive and white space are significant";

import java.util.*;


public class Main {

// this function is called inside the isPermutedNaive() function , which return the
// new sorted string.
// takes 0(nlogn) for sorting. and also some sorting algo's takes extra space too.
    static String sort(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);


    }

    // if two string are permutations then we know they have same character , but
    // in different order.therefore sorting the string will put the character from
    // two permutations in the same order , we just need to compare the sorted version
    // of the string
    static boolean isPermutedNaive(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        // checks if the s1 and s2 are equals or not and return the boolean vallue
        // takes 0(N) TIME for comparison 
        return sort(s1).equals(sort(s2));
        
    }
// the optimal approach to solve this problem is to use the character count approach:
/*
if the string have diff length then it will be false:

we can also ude the defination of the permutation - two words with the same character
 counts - to implement this algorithm.We simply iterate through this code , counting
 how many times that each character appears, Then , Afterwards we compare the two arrays.


*/
   static boolean isPermutedOptimal(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        // space of 0(c) c = number of character in the string //0(128) is constant space 
        int [] letters = new int[128];

        char[] s_array = s1.toCharArray();
        // 0(n)
        for(char c : s_array){
            letters[c]++;
        }
        
         // 0(n)
        for(int i = 0; i < s2.length(); i++){
            int c = (int) s2.charAt(i);
            letters[c]--;
            if(letters[c] < 0){
                return false;
            }
        }
        // total complexity is 0(n) + 0(n) = 0(2n) => 0(n)
        return true;
        

    }

    public static void main(String args[]) {
        System.out.println("Dream it ! do it ! Acheive it");
        Scanner sc = new Scanner(System.in);
        String s1  = sc.nextLine();
        String s2  = sc.nextLine();
        System.out.println(isPermutedNaive(s1, s2));
        System.out.println(isPermutedOptimal(s1, s2));
    }
}