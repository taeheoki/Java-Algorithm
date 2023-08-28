package src.week_35;

/**
 * 프로그래머스 - 유사 칸토어 비트열
 * 1번째, 11011
 * 2번째, 1101111011000001101111011
 */
public class Pro148652 {
    static long[] len = new long[21];
    static long[] one = new long[21];

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 17));
        System.out.println(solution(4, 12, 29));
        System.out.println(solution(20, 12, 29));
    }

    public static int solution(int n, long l, long r) {
        return countOne(n, l, r, 1);
    }

    public static int countOne(int n, long s, long e, long idx) {
        if (n == 0)
            return 1;
        int num = 0;
        long part = (long) Math.pow(5, n - 1);
        for (int i = 0; i < 5; i++) {
            if (i == 2 || e < (idx + part * i) || (idx + part * (i + 1) - 1) < s)
                continue;
            num += countOne(n - 1, s, e, idx + part * i);
        }
        return num;
    }
}
