package src.week_04;

import java.io.*;
import java.util.*;

/**
 * 백준 16922번 로마 숫자 만들기
 */
public class Pro16922 {
    static int N, cnt;
    static int[] test = new int[4];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec_func(0, 0);
        System.out.println(cnt);
    }

    private static void rec_func(int depth, int used) {
        if (depth == 3) {
            int tmp = test[0] * 50 + test[1] * 10 + test[2] * 5 + (N - used) * 1;
            if (!set.contains(tmp)) {
                set.add(tmp);
                cnt++;
            }
        } else {
            for (int i = N - used; i >= 0; i--) {
                test[depth] = i;
                rec_func(depth + 1, used + i);
            }
        }
    }
}
