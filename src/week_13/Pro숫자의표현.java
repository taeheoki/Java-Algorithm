package src.week_13;

import java.io.BufferedReader;

/**
 * 프로그래머스 - 숫자의 표현
 * 문제 이해: 주어진 숫자를 연속된 자연수의 합으로 표현하는 방법의 경우의 수를 구하라
 *          투 포인터
 * 시간 복잡도: O(2n) 실제로 n^2이만큼 쓰이지는 않는다.
 */
public class Pro숫자의표현 {
    static int cnt;

    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static  int solution(int n) {
        int right = 0;
        int sum = 0;
        for (int left = 1; left <= n; left++) {
            sum -= left - 1;

            while (right + 1 <= n && sum < n) {
                right++;
                sum += right;
            }
            if (sum == n)
                cnt++;
        }
        return cnt;
    }
}
