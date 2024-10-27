import java.util.*;

public class Main {
    
    static long answer = 0;
    static int zero = 0;
    
    public static void main(String[] args) {
        int n;
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        ArrayList<Long> negatives = new ArrayList<Long>(); // 음수 저장 리스트
        ArrayList<Long> positives = new ArrayList<Long>(); // 양수 저장 리스트
        zero = 0;
        
        // 입력 받기
        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            if (num < 0) negatives.add(num);
            else if (num > 0) positives.add(num);
            else zero++; // 0의 개수 카운트
        }
        
        // 음수는 오름차순 정렬 (작은 값부터 두 개씩 곱해야 최대화)
        Collections.sort(negatives);
        // 양수는 내림차순 정렬 (큰 값부터 두 개씩 곱해야 최대화)
        Collections.sort(positives, Collections.reverseOrder());
        
        // 음수 처리
        if (!negatives.isEmpty()) processNegatives(negatives);
        // 양수 처리
        if (!positives.isEmpty()) processPositives(positives);
        
        // 결과 출력
        System.out.println(answer);
    }
    
    // 음수 처리
    static void processNegatives(ArrayList<Long> negatives) {
        for (int i = 0; i < negatives.size(); i += 2) {
            // 홀수 개 남으면 0이 있는 경우 그 음수를 없애고, 없으면 더함
            if ((negatives.size() - i) == 1) {
                if (zero > 0) zero--; // 0이 있으면 음수와 곱해서 제거
                else answer += negatives.get(i); // 0이 없으면 음수 더함
            } else {
                // 두 개씩 짝지어 곱한 후 더함
                answer += negatives.get(i) * negatives.get(i + 1);
            }
        }
    }
    
    // 양수 처리
    static void processPositives(ArrayList<Long> positives) {
        for (int i = 0; i < positives.size(); i += 2) {
            // 홀수 개 남으면 그냥 더함
            if ((positives.size() - i) == 1) {
                answer += positives.get(i);
            } else {
                // 두 개씩 짝지어 곱하되, 1이 포함되면 곱하지 않고 더함
                if (positives.get(i) == 1 || positives.get(i + 1) == 1) {
                    answer += positives.get(i) + positives.get(i + 1);
                } else {
                    answer += positives.get(i) * positives.get(i + 1);
                }
            }
        }
    }
}
