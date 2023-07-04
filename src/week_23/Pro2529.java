package src.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2529 - 부등호
 */
public class Pro2529 {
    static int k;
    static long min = 9876543210L, max = 0L;
    static String[] arr;
    static boolean[] used = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }
        for (int i = 0; i < 10; i++) {
            used[i] = true;
            rec_func(0, i);
            used[i] = false;
        }
        System.out.println(max);
        System.out.println(getLength(min) == k ? "0" + min : min);
    }

    private static int getLength(long num) {
        int cnt = 0;
        while (num != 0) {
            num /= 10;
            cnt++;
        }
        return cnt;
    }

    private static void rec_func(int index, long x) {
        if (index == k) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (used[i])
                continue;
            if (arr[index].equals("<") && x % 10 >= i)
                continue;
            if (arr[index].equals(">") && x % 10 <= i)
                continue;
            used[i] = true;
            rec_func(index + 1, x * 10 + i);
            used[i] = false;
        }
    }
}
