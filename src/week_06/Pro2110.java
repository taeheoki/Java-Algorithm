package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2110번 공유기 설치
 * 문제 이해: 최대한 많은 곳에 와이파이가 닿을 수 있는 곳에 공유기를 C개 적절히 설치한 뒤
 *          가장 인접한 공유기 사이의 거리를 구하라.
 * 시간 복잡도:
 */
public class Pro2110 {
    static int N, C;
    static int[] locations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 집의 개수
        C = Integer.parseInt(st.nextToken()); // 공유기의 개수
        locations = new int[N];
        for (int i = 0; i < N; i++)
            locations[i] = Integer.parseInt(br.readLine());
        // 정렬을 하여 집을 차례대로 나열한다.
        Arrays.sort(locations);
        int res = bSearch();
        System.out.println(res);
    }

    private static int bSearch() {
        int left = 0;
        int right = Arrays.stream(locations).max().getAsInt();
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(mid) >= C) {
                res = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return res;
    }

    private static int getCount(int mid) {
        int cnt = 1;
        int pre = 0;
        for (int i = 1; i < N; i++) {
            if (locations[i] - locations[pre] >= mid) {
                pre = i;
                cnt++;
            }
        }
        return cnt;
    }
}
