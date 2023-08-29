package src.week_35;

/**
 * 프로그래머스 - 점 찍기
 */
public class Pro140107 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }

    public static long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i += k) {
            answer += binarySearch(i, d) / k + 1;
        }
        return answer;
    }

    private static long binarySearch(int y, int d) {
        int left = 0;
        int right = d;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isInside(y, d, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private static boolean isInside(int y, int d, int mid) {
        return (long) y * y + (long) mid * mid <= (long) d * d;
    }
}
