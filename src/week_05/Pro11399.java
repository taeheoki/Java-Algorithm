package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11399번 ATM
 */
public class Pro11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int res = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            res += arr[i];
            total += res;
        }
        System.out.println(total);
    }
}

/*
1                   => 1
1 + 2               => 3
1 + 2 + 3           => 6
1 + 2 + 3 + 3       => 9
1 + 2 + 3 + 3 + 4   => 13
 */