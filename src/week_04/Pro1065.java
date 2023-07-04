package src.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro1065 {
    static int N, dx, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec_func(1);
        System.out.println(cnt);
    }

    private static void rec_func(int depth) {
        int i = 0;
        int tmp = depth;
        if (depth == N + 1) {
            return;
        } else {
            while (true) {
                tmp /= 10;
                i++;
                if (tmp == 0)
                    break;
            }
            if (i == 1 || i == 2) {
                cnt++;
            } else if (i == 3) {
                int one = depth % 10;
                int two = depth / 10 % 10;
                int three = depth / 100 % 10;
                dx = two - one;
                if (three - two == dx)
                    cnt++;
            } else if (i == 4) {
                System.out.println(144);
                System.exit(0);
            }
            rec_func(depth + 1);
        }
    }
}
