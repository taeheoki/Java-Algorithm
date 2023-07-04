package src.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1946번 신입 사원
 */

public class Pro1946 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int cnt = 1;
            int pivot = arr[0][1];
            for (int j = 1; j < N; j++) {
                if (pivot > arr[j][1]) {
                    pivot = arr[j][1];
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}