package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2436 - 공약수
 */
public class Pro2436 {
    static int gcd, lcm;
    static int ans[] = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        gcd = Integer.parseInt(st.nextToken());
        lcm = Integer.parseInt(st.nextToken());
        ans[0] = gcd;
        ans[1] = lcm;
        pro();
        System.out.println(ans[0] + " " + ans[1]);
    }

    private static void pro() {
        int target = lcm / gcd;
        for (int i = 1; i <= Math.sqrt(lcm / gcd); i++) {
            if (target % i != 0)
                continue;
            int a = i * gcd;
            int b = target / i * gcd;
            if (gcd == getGcd(a, b)) {
                if (b - a < ans[1] - ans[0]) {
                    ans[0] = a;
                    ans[1] = b;
                }
            }
        }
    }

    private static int getGcd(int a, int b) {
        if (b % a == 0)
            return a;
        return getGcd(b % a, a);
    }

}
