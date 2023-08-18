package src.week_33;

/**
 * 프로그래머스 - 멀쩡한 사각형
 */
public class Pro62048 {

    static long res;

    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    public static long solution(int w, int h) {
        long res = (long) w * h;
        long min = Math.min(w, h);
        long max = Math.max(w, h);
        long gcd = getGCD(min, max);

        long sum = (res / gcd / gcd) - (min / gcd - 1) * (max / gcd - 1);
        sum *= gcd;
        return res - sum;
    }

    private static long getGCD(long min, long max) {
        if (max % min == 0)
            return min;
        return getGCD(max % min, min);
    }
}
