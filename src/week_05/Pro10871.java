package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10871번 X보다 작은 수
 */
public class Pro10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            if (X > tmp)
                sb.append(tmp + " ");
        }
        System.out.println(sb);
    }
}
