package src.week_20;

import java.io.*;
import java.util.*;

/**
 * BOJ 1374 - 강의실
 */
public class Pro1374 {
    static int N;
    static PriorityQueue<Lecture> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(start, true));
            pq.add(new Lecture(end, false));
        }
        pro();
    }

    private static void pro() {
        int cnt = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();
            if (lecture.status)
                cnt++;
            else if (!lecture.status) {
                cnt--;
            }
            res = Math.max(res, cnt);
        }
        System.out.println(res);
    }

    private static class Lecture implements Comparable<Lecture>{
        int time;
        boolean status;

        public Lecture(int time, boolean status) {
            this.time = time;
            this.status = status;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.time == o.time) {
                return this.status ? 1 : -1;
            } else {
                return this.time - o.time;
            }
        }
    }
}
