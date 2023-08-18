package src.week_33;

/**
 * 프로그래머스 - 혼자서 하는 틱택토
 */
public class Pro160585 {
    static int res = 1;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"O.X", ".O.", "..X"}));
        res = 0;
        System.out.println();
        System.out.println(solution(new String[]{"OOO", "...", "XXX"}));
        res = 0;
        System.out.println();
        System.out.println(solution(new String[]{"...", ".X.", "..."}));
        res = 0;
        System.out.println();
        System.out.println(solution(new String[]{"...", "...", "..."}));
    }

    public static int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O')
                    oCnt++;
                else if (board[i].charAt(j) == 'X')
                    xCnt++;
            }
        }
        if (xCnt > oCnt)
            res = 0;
        else if (oCnt >= xCnt + 2)
            res = 0;
        else if (oCnt <= 2)
            res = 1;
        else {
            res = 0;
            boolean oFlag = isBingo(board, 'O');
            boolean xFlag = isBingo(board, 'X');
            if (oFlag && xFlag) {
                res = 0;
            } else if (xFlag && oCnt == xCnt) {
                res = 1;
            } else if (oFlag && oCnt == xCnt + 1) {
                res = 1;
            } else if (!oFlag && !xFlag)
                res = 1;
        }
        return res;
    }

    private static boolean isBingo(String[] board, char pivot) {
        // 가로
        for (int i = 0; i < 3; i++) {
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) != pivot)
                    flag = true;
            }
            if (!flag)
                return true;
        }
        // 세로
        for (int i = 0; i < 3; i++) {
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                if (board[j].charAt(i) != pivot)
                    flag = true;
            }
            if (!flag)
                return true;
        }
        // 대각선
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(i) != pivot)
                flag = true;
        }
        if (!flag)
            return true;
        flag = false;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(2 - i) != pivot)
                flag = true;
        }
        if (!flag)
            return true;
        return false;
    }
}
