import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isWin(char[] board, char player) {
        // 승리 조건인 모든 라인을 검사합니다.
        int[][] lines = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // 가로
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // 세로
                {0, 4, 8}, {2, 4, 6}             // 대각선
        };
        for (int[] line : lines) {
            if (board[line[0]] == player && board[line[1]] == player && board[line[2]] == player) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(String boardStr) {
        if (boardStr.length() != 9) return false;

        char[] board = boardStr.toCharArray();
        int xCount = 0, oCount = 0;
        for (char c : board) {
            if (c == 'X') xCount++;
            else if (c == 'O') oCount++;
            else if (c != '.') return false; // 유효하지 않은 문자 검사
        }

        // 'O'의 개수가 'X'보다 많거나, 'X'가 'O'보다 두 개 이상 많으면 유효하지 않음
        if (oCount > xCount || xCount - oCount > 1) return false;

        boolean xWin = isWin(board, 'X');
        boolean oWin = isWin(board, 'O');

        // 둘 다 승리할 수는 없음
        if (xWin && oWin) return false;

        // 'X'가 승리했을 때, 'X'의 개수는 'O'보다 하나 더 많아야 함
        if (xWin && xCount != oCount + 1) return false;

        // 'O'가 승리했을 때, 'X'와 'O'의 개수가 같아야 함
        if (oWin && xCount != oCount) return false;

        // 승리자가 없을 때
        if (!xWin && !oWin) {
            // 빈 칸이 남아있다면 게임은 아직 끝나지 않은 상태이므로 유효하지 않음
            if (xCount + oCount != 9) return false;
        }

        return true; // 위의 조건에 모두 해당하지 않으면 유효한 상태
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String boardStr = br.readLine();
            if (boardStr.equals("end")) break;

            if (isValid(boardStr)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }
}
