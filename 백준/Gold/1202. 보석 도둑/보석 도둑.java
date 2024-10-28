import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 보석의 개수
        int k = sc.nextInt(); // 가방의 개수

        // 보석 정보를 저장할 리스트
        Jewel[] jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            jewels[i] = new Jewel(weight, value);
        }

        // 보석은 무게를 기준으로 오름차순 정렬
        Arrays.sort(jewels, (a, b) -> a.weight - b.weight);

        // 가방 정보 저장 (용량)
        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = sc.nextInt();
        }

        // 가방을 오름차순으로 정렬
        Arrays.sort(bags);

        // 최대 가치를 저장할 우선순위 큐 (내림차순 정렬, 가치가 큰 순으로 처리)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long result = 0;
        int jewelIndex = 0;

        // 각 가방에 대해 보석을 선택
        for (int i = 0; i < k; i++) {
            int currentBagCapacity = bags[i];

            // 현재 가방에 담을 수 있는 모든 보석을 우선순위 큐에 넣음
            while (jewelIndex < n && jewels[jewelIndex].weight <= currentBagCapacity) {
                pq.add(jewels[jewelIndex].value);
                jewelIndex++;
            }

            // 우선순위 큐에서 가장 큰 가치를 가진 보석을 꺼내어 해당 가방에 넣음
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}

// 보석 클래스를 정의하여 무게와 가치를 저장
class Jewel {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
