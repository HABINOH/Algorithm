import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        
        // 1. 숫자 배열을 문자열 배열로 변환
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // 2. 문자열 배열을 정렬하는데, 두 문자열을 합친 값이 큰 순서대로 정렬 (내림차순)
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 3. 첫 번째 문자가 "0"이면, 모든 문자가 "0"인 경우이므로 "0"을 반환
        if (str[0].equals("0")) {
            return "0";
        }

        // 4. 문자열 배열을 하나의 문자열로 합쳐서 반환
        return String.join("", str);
    }
}
