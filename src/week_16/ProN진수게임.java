package src.week_16;

/**
 * 프로그래머스 - N진수 게임
 * 문제 예시: 0, 1, 1, 0, 1, 1, 1, 0
 *         튜브: 0, 1, 1, 1
 */
public class ProN진수게임 {

    static StringBuilder sb;
    static char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }

    public static String solution(int n, int t, int m, int p) {
        sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (sb.length() <= t * m) {
            sb.append(transformNum(i, n));
            i++;
        }
        for (int j = 0; j < m * t; j++) {
            if (j % m == p - 1) {
                ans.append(sb.charAt(j));
            }
        }
        return String.valueOf(ans);
    }

    private static String transformNum(int i, int n) {
        StringBuilder tmp = new StringBuilder();
        while (true) {
            tmp.append(base[i % n]);
            i /= n;
            if (i == 0)
                break;
        }
        return String.valueOf(tmp.reverse());
    }
}
