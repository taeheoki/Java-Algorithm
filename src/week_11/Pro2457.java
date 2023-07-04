package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 2457 - 공주님의 정원
 * 문제 이해: 꽃의 종류와, 피는 날짜, 지는 날짜가 주어졌을 때
 *          3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어있도록 꽃을 선택할 때,
 *          선택한 꽃들의 최소 개수를 출력하라.
 */
public class Pro2457 {
    static int N;
    static Elem[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Elem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_month = Integer.parseInt(st.nextToken());
            int start_day = Integer.parseInt(st.nextToken());
            int end_month = Integer.parseInt(st.nextToken());
            int end_day = Integer.parseInt(st.nextToken());
            arr[i] = new Elem(start_month * 100 + start_day, end_month * 100 + end_day);
        }
        Arrays.sort(arr);
        pro();
    }

    private static void pro() {
        int start = 301;
        int end = 1201;
        int cnt = 0;
        int end_tmp = 0;
        int idx = 0;
        while (start < end) {
            boolean flag = false;

            for (int i = idx; i < N; i++) {
                if (arr[i].start > start)
                    break;
                if (end_tmp < arr[i].end) {
                    flag = true;
                    end_tmp = arr[i].end;
                    idx = i + 1;
                }
            }
            if (flag) {
                start = end_tmp;
                cnt++;
            } else
                break;
        }
        if(end_tmp < end) {
            System.out.println(0);
        }
        else {
            System.out.println(cnt);
        }
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
            if (this.start == o.start)
                return o.end - this.end;
            return this.start - o.start;
        }
    }
}
