package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 11501 - 주식
 * 문제 이해: 매일 한가지 행동만 가능하다.
 *          1. 주식 하나를 산다.
 *          2. 원하는 만큼 가지고 있는 주식을 판다.
 *          3. 아무것도 안한다.
 *          어떻게 해야 자신이 최대 이익을 얻을 수 있는지 계산해보자.
 */
public class Pro11501 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] price = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0; // 정답
            int max = price[n - 1]; // 최대 주가
            for (int i = n - 2; i >= 0; i--) {
                if (price[i] > max) {
                    max = price[i]; // 아무것도 하지 않는다.
                } else {
                    ans += max - price[i]; // 주식을 매도한다.
                }
            }

            System.out.println(ans);
        }
    }
}
