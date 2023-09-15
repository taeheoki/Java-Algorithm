package src.week_37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 13335 - 트럭
 */
public class BOJ13335 {
    static int n, w, L;
    static int[] arr;
    static Queue<Elem> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        int time = 0;
        int i = 0;
        int sum = 0;
        while (true) {
            time++;
            if (!que.isEmpty() && que.peek().time == time - w) {
                Elem e = que.poll();
                sum -= arr[e.index];
            }
            if (i < arr.length && sum + arr[i] <= L) {
                sum += arr[i];
                que.add(new Elem(time, i));
                i++;
            }
            if (i == arr.length && que.isEmpty())
                break;
        }
        System.out.println(time);
    }

    private static class Elem {
        int time;
        int index;

        public Elem(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
}
