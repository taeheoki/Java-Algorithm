package src.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1943 - 동전 분배
 * 문제 이해: N가지 종류의 동전을 받았을 때 이 돈을 반으로 나눌 수 있는지 없는지 판단해보자.
 */
public class Pro1943 {
    static int N, total;
    static Elem[] elem;
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 3;
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            elem = new Elem[N];
            dp = new boolean[100000 + 1];
            total = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int val = Integer.parseInt(st.nextToken());
                int qty = Integer.parseInt(st.nextToken());
                elem[i] = new Elem(val, qty);
                total += val * qty; // 받은 총 금액 구함
            }
            System.out.println(pro());
        }
    }

    private static int pro() {
        if (total % 2 == 1)
            return 0;

        // 주어진 동전으로 (total / 2)원을 만들 수 있는지 확인해보자.
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            int val = elem[i].val;
            int qty = elem[i].qty;

            for (int j = total / 2; j >= 0; j--) {
                if (dp[j]) {
                    for (int k = 1; k <= qty; k++) {
                        if (j + val * k > total / 2)
                            break;
                        dp[j + val * k] = true;
                        if (j + val * k == total / 2)
                            return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static class Elem {
        int val;
        int qty;

        public Elem(int val, int qty) {
            this.val = val;
            this.qty = qty;
        }
    }
}
