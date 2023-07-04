package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 19598 - 최소 회의실 개수
 */
public class Pro19598 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Meeting(start, true));
            pq.add(new Meeting(end, false));
        }

        int ans = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Meeting meet = pq.poll();
            if (meet.isStartEnd) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt--;
            }
        }
        System.out.println(ans);
    }



    private static class Meeting implements Comparable<Meeting> {

        int time;
        boolean isStartEnd;

        public Meeting(int time, boolean isStartEnd) {
            this.time = time;
            this.isStartEnd = isStartEnd;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.time - o.time;
        }
    }
}
