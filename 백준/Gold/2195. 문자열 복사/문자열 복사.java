import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String p = sc.nextLine();

        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            String subString = p.substring(idx, i+1);

            if (s.indexOf(subString) == -1) {
                cnt++;
                idx = i;
            }
        }
        System.out.println(cnt+1);
    }
}