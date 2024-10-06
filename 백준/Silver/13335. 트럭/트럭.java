import java.io.*;
import java.util.*;

public class Main {
    static class Truck {
        int weight;
        int leaveTime;

        public Truck(int weight, int leaveTime) {
            this.weight = weight;
            this.leaveTime = leaveTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());
        int[] trucks = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(stk.nextToken());
        }

        Queue<Truck> bridge = new LinkedList<>();
        int time = 0;
        int idx = 0;
        int bridgeWeight = 0;

        while (idx < n || !bridge.isEmpty()) {
            // 다리에서 트럭 제거
            if (!bridge.isEmpty() && bridge.peek().leaveTime == time) {
                bridgeWeight -= bridge.poll().weight;
            }

            // 다음 트럭이 다리에 올라갈 수 있는지 확인
            if (idx < n && bridgeWeight + trucks[idx] <= l && bridge.size() < w) {
                bridge.add(new Truck(trucks[idx], time + w));
                bridgeWeight += trucks[idx];
                idx++;
            }

            // 시간이 다음 이벤트 시점으로 이동
            if (bridge.isEmpty()) {
                // 다리가 비어 있으면 다음 트럭이 진입하는 시간으로 이동
                time++;
            } else {
                // 다음 이벤트 시간 계산
                int nextTime = bridge.peek().leaveTime;
                if (idx < n && bridgeWeight + trucks[idx] <= l && bridge.size() < w) {
                    nextTime = time + 1;
                }
                time = Math.max(time + 1, nextTime);
            }
        }

        System.out.println(time);
    }
}
