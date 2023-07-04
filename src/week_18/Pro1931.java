package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1931 - 회의실 배정
 */
public class Pro1931 {
    static int N;
    static Meeting[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Meeting(start, end);
        }
        Arrays.sort(arr);
        pro();
    }

    private static void pro() {
        int cnt = 0;
        int prev_end = -1;
        for (int i = 0; i < N; i++) {
            if (prev_end <= arr[i].start) {
                prev_end = arr[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end)
                return this.start - o.start;
            return this.end - o.end;
        }
    }
}
