import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int result = 0;

        for(int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            int cnt = 0;    // 같은 단어 개수
            int[] word = new int[26];
            for(int j = 0; j < first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }

            for(int j = 0; j < str.length(); j++) {
                if(word[str.charAt(j) - 'A'] > 0) {
                    cnt++;
                    word[str.charAt(j) - 'A']--;
                }
            }

            // 기준 문자열 길이와 비교 문자열 길이 차이
            // 같은 경우 or 한 글자만 바뀜
            if(first.length() == str.length() && (first.length() == cnt || first.length() - 1 == cnt)) {   
                result++;
            } 
            // 비교 문자열이 짧음 (remove)
            else if (first.length() == str.length() - 1 && str.length() - 1 == cnt) {   
                result++;
            } 
            // 비교 문자열이 김 (plus)
            else if (first.length() == str.length() + 1 && str.length() == cnt) {   
                result++;
            }

        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}