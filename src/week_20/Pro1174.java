package src.week_20;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * BOJ 1174 - 줄어드는 수
 */
public class Pro1174 {
    static int N;
    static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        if (N <= 11) {
            System.out.println(N - 1);
        } else if (N > 1023) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++)
                rec_func(i);
            Collections.sort(arr);
            System.out.println(arr.get(N - 1));
        }
    }

    private static void rec_func(long num) {
        arr.add(num);
        for (int i = 0; i < num % 10; i++) {
            rec_func(num * 10 + i);
        }
    }
}
