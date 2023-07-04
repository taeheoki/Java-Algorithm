package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2869 - 달팽이는 올라가고 싶다
 * 문제 이해: 높이 V 나무, 달팽이는 A만큼 올라가고 B만큼 내려간다.
 *          나무를 모두 올라가기까지 몇일 걸리는가, 정상에 오르면 더 이상 떨어지지 않는다.
 */
public class Pro2869 {
    static int A, B, V, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        if (V == A)
            res = 1;
        else
            res = (int) Math.ceil(((double) V - A) / (A - B)) + 1;
        System.out.println(res);
    }
}