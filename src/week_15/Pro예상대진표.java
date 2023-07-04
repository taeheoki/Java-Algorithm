package src.week_15;

/**
 * 프로그래머스 - 예상 대진표
 * 문제 이해:
 */
public class Pro예상대진표 {

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
        System.out.println(solution(8, 4, 5));
    }

    public static int solution(int n, int a, int b)
    {
        int ans = 1;
        int big = -1;
        int small = - 1;
        if (a < b) {
            big += b;
            small += a;
        } else {
            big += a;
            small += b;
        }
        while (true) {
            int tmpBig = big / 2;
            int tmpSmall = small / 2;
            if (big == small + 1 && tmpBig == tmpSmall) {
                break;
            }
            big = tmpBig;
            small = tmpSmall;
            ans++;
        }
        return ans;
    }
}
