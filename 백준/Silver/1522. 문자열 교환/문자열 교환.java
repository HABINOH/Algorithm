import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int aCnt = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a') aCnt++;
        }
        for (int i = 0; i < str.length(); i++) {
            int bCnt = 0;
            for (int j = i; j < i + aCnt; j++) {
                if (str.charAt((j + str.length()) % str.length()) == 'b')
                    bCnt++;
            }
            answer = Math.min(answer, bCnt);
        }
        System.out.println(answer);
    }
}