package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 2121 - 넷이 놀기
 */
public class Pro2121 {
    static int N, cnt;
    static int h, w;
    static Point[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[i] = new Point(y, x);
        }
        Arrays.sort(arr);
        pro();
        System.out.println(cnt);
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            int y = arr[i].y;
            int x = arr[i].x;

            Point p1 = new Point(y + h, x);
            Point p2 = new Point(y, x + w);
            Point p3 = new Point(y + h, x + w);

            if (isPresent(p1) && isPresent(p2) && isPresent(p3))
                cnt++;
        }

    }

    private static boolean isPresent(Point p) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid].y == p.y && arr[mid].x == p.x)
                return true;
            else if (arr[mid].y < p.y || (arr[mid].y == p.y && arr[mid].x < p.x)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private static class Point implements Comparable<Point> {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Point o) {
            if (this.y == o.y)
                return this.x - o.x;
            return this.y - o.y;
        }
    }
}
