package src.workshop;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1966번 프린터 큐
 */
class Elem {
    int priority;
    int index;

    public Elem(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}
public class Pro1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Elem> pq = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] used = new int[9];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                used[tmp - 1]++;
                pq.offer(new Elem(tmp, j));
            }
            int cnt = 0;
            Elem tmp;
            int pivot = 0, start = 8;
            int size = pq.size();
            for (int j = 0; j < size; j++) {
                for (int k = start; k >= 0; k--) {
                    if (used[k] > 0) {
                        used[k]--;
                        pivot = k + 1;
                        start = k;
                        break;
                    }
                }
                while (true) {
                    tmp = pq.poll();
                    if (tmp.priority == pivot) {
                        cnt++;
                        break;
                    } else
                        pq.offer(tmp);
                }
                if (tmp.index == M) {
                    System.out.println(cnt);
                    break;
                }
            }
            pq.clear();
        }
    }
}
