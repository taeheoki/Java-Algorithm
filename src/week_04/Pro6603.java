package src.week_04;

import java.io.*;
import java.util.*;

/**
 * 백준 6603번 로또
 */
public class Pro6603 {
    static int[] arr, select = new int[6];
    static int k;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0)
                break;
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            rec_func(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void rec_func(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(select[i] + " ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i < start + (k - 5) && i < k; i++) {
                select[depth] = arr[i];
                rec_func(depth + 1, i + 1);
            }
        }
    }
}
