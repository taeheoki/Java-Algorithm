package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 11650 - 좌표 정렬하기
 */
public class Pro11650 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Elem[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Elem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Elem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            sb.append(arr[i].x).append(" ").append(arr[i].y).append("\n");
        }
        System.out.println(sb);
    }

    private static class Elem implements Comparable<Elem> {
        int x;
        int y;

        public Elem(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Elem o) {
            if (this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }
    }
}
