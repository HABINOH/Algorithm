import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 진지 앞쪽 길의 거리
        int L = Integer.parseInt(br.readLine());

        // 기관총 유효 사거리, 각 미터당 데미지
        String[] tokens = br.readLine().split(" ");
        int ML = Integer.parseInt(tokens[0]);
        int MK = Integer.parseInt(tokens[1]);

        // 사용할 수 있는 지뢰의 개수
        int Cammo = Integer.parseInt(br.readLine());

        // 각 거리 좀비 체력 저장
        int[] Zi = new int[L];
        for (int i = 0; i < L; i++) {
            Zi[i] = Integer.parseInt(br.readLine());
        }

        // 지뢰 사용 후 지속 시간 관리 리스트
        ArrayList<Integer> mineUsageInfo = new ArrayList<>();

        boolean possible = true;

        // 각 거리마다 좀비를 처리
        for (int i = 0; i < L; i++) {
            // 현재 거리에서 기관총으로 줄 수 있는 최대 데미지 계산
            int maxGunDamage = Math.min(i + 1, ML) * MK;

            // 지뢰 사용으로 인해 기관총 데미지가 줄어드는 부분 반영
            if (!mineUsageInfo.isEmpty()) { // 지뢰로 인해 줄어든 데미지 계산
                maxGunDamage -= mineUsageInfo.size() * MK;

                // 지뢰 사용 지속 시간 감소
                int duration = mineUsageInfo.get(0) - 1;
                if (duration == 0) { // 지속 시간이 끝나면 리스트에서 제거
                    mineUsageInfo.remove(0);
                } else { // 지속 시간이 남아 있으면 업데이트
                    mineUsageInfo.set(0, duration);
                }
            }

            // 기관총으로 좀비를 처리할 수 있는 경우
            if (Zi[i] <= maxGunDamage) { // 좀비를 처리하고 다음 거리로 진행
                continue;
            } else { // 기관총으로 처리할 수 없고, 지뢰가 남아 있는 경우
                if (Cammo > 0) { // 지뢰 사용
                    Cammo--;

                    // 지뢰 사용 후 지속 시간 추가
                    if (!mineUsageInfo.isEmpty()) { // 기존 지속 시간과 비교하여 새 지속 시간 추가
                        int newDuration = ML - mineUsageInfo.get(mineUsageInfo.size() - 1);
                        mineUsageInfo.add(newDuration);
                    } else { // 새로운 지속 시간 추가
                        mineUsageInfo.add(ML - 1);
                    }
                } else { // 지뢰도 없어서 더 이상 좀비를 처리할 수 없는 경우
                    possible = false;
                    break;
                }
            }
        }
        if (possible) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
