package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2562번 최댓값
 */
public class Pro2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < 9; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (max < Math.max(max, tmp)) {
                max = Math.max(max, tmp);
                index = i + 1;
            }
        }
        System.out.println(max + "\n" + index);
    }
}
