package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ 1931 - 회의실 배정
 * 문제 이해: N개의 회의를 위한 회의실 사용표를 만들려고 한다.
 *          각 회의 I에 대해 시작 시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서
 *          회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 *          한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 시간 복잡도: O(N + NlogN)
 */
public class Pro1931 {
    static int N;
    static Elem[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Elem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Elem(start, end);
        }
        Arrays.sort(arr);
        pro();
    }

    private static void pro() {
        int cnt = 0;
        int prev_end = 0;
        for (int i = 0; i < N; i++) {
            if (prev_end <= arr[i].start) {
                prev_end = arr[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static class Elem implements Comparable<Elem> {
        int start;
        int end;

        public Elem(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Elem o) {
            if (this.end == o.end)
                return this.start - o.start;
            return this.end - o.end;
        }
    }
}
