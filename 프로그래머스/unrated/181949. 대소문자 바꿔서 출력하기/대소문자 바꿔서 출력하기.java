import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] charArray = a.toCharArray();
        
        for(int i=0;i<a.length();i++){
            if(Character.isUpperCase(charArray[i])){ //소문자로
                charArray[i] = Character.toLowerCase(charArray[i]);
            } 
            else if(Character.isLowerCase(charArray[i])){ //대문자로
                charArray[i] = Character.toUpperCase(charArray[i]);
            } 
        }
        System.out.println(charArray);
    }
}