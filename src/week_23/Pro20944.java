package src.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * # BOJ 20944 - 팰린드롬 척화비
 */
public class Pro20944 {
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }
    // 10 -> 5
    private static void pro() {
//        for (int i = 0; i < N / 2; i++) {
//            sb.append(i % 2 == 0 ? 'a' : 'b');
//        }
//        if (N % 2 == 1)
//            sb.append("c");
//        for (int i = 0; i < N / 2; i++) {
//            if ((N / 2) % 2 == 0)
//                sb.append(i % 2 == 0 ? 'b' : 'a');
//            else
//                sb.append(i % 2 == 0 ? 'a' : 'b');
//        }
        for (int i = 0; i < N; i++) {
            sb.append('a');
        }
        System.out.println(sb);
    }
}
