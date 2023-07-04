package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * BOJ 5430 - AC
 */
public class Pro5430 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static String p;
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < n; j++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }
            pro();
            deque.clear();
        }
        System.out.println(sb);
    }

    private static void pro() {
        boolean reverse = false;
        boolean error = false;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'R') {
                reverse = reverse ? false : true;
            } else {
                if (deque.isEmpty()) {
                    error = true;
                    break;
                }
                if (!reverse) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }
        printDeque(error, reverse);
    }

    private static void printDeque(boolean error, boolean reverse) {
        if (error)
            sb.append("error");
        else if (reverse) {
            sb.append("[");
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
                if (!deque.isEmpty())
                    sb.append(",");
            }
            sb.append("]");
        } else {
            sb.append("[");
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                if (!deque.isEmpty())
                    sb.append(",");
            }
            sb.append("]");
        }
        sb.append("\n");
    }
}
