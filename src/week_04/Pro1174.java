package src.week_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 백준 1174번 줄어드는 수
 */
public class Pro1174 {
    static int N, length;
    static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N > 1023) {
            System.out.println(-1);
            System.exit(0);
        } else {
            rec_func(0, 0);
            Collections.sort(arr);
            System.out.println(arr.get(N - 1));
        }
    }

    private static void rec_func(long sum, int depth) {
        if(!arr.contains(sum))
            arr.add(sum);
        if(depth >= 10)
            return;
        rec_func(sum,depth + 1);
        rec_func(sum * 10 + num[depth],depth + 1);
    }
}
