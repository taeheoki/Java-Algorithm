package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 4153 - 직각삼각형
 */
public class Pro4153 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
                break;
            int max = Arrays.stream(arr).max().getAsInt();
            if (2 * max * max == arr[0] * arr[0] + arr[1] * arr[1] + arr[2] * arr[2])
                sb.append("right");
            else
                sb.append("wrong");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
