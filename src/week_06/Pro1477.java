package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1477번 휴게소 세우기
 * 문제 이해: N개의 휴게소 & M개의 휴게소를 더 지으려한다.
 *          이미 존재하는 곳과 고속도로의 끝에는 휴게소를 세울 수 없다.
 *          M개의 휴게소를 더 지어서 휴게소가 없는 구간의 최댓값을 최소로 만든다.
 *          82 (119) 201 (210) 411 (144) 555 (67) 622 (133) 755
 *          휴게소 마다 사이의 거리를 예상 거리로 나누어 개수를 세어 계산한다.
 * 시간 복잡도:
 */
public class Pro1477 {

    static int N, M, L;
    static int[] station, distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 현재 휴게소 개수
        M = Integer.parseInt(st.nextToken()); // 추가로 지으려는 휴게소 개수
        L = Integer.parseInt(st.nextToken()); // 고속도로 길이
        st = new StringTokenizer(br.readLine());
        // 고속도로의 시작지점과 도착지점도 하나의 휴게소로 보고 계산한다.
        station = new int[N + 2];
        // 휴게소마다 거리를 측정한다.
        distances = new int[N + 1];
        station[0] = 0;
        station[N + 1] = L;
        for (int i = 1; i < N + 1; i++)
            station[i] = Integer.parseInt(st.nextToken());
        // 휴게소의 위치를 시작점별 거리로 나열한다.
        Arrays.sort(station);
        int res = bSearch();
        System.out.println(res);
    }

    private static int bSearch() {
        int left = 1;
        int right = L;
        for (int i = 1; i < N + 2; i++) {
            int tmp = station[i] - station[i - 1];
            distances[i - 1] = tmp;
        }
        int res = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(mid) <= M) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return res;
    }

    private static int getCount(int mid) {
        int cnt = 0;
        for (int i = 0; i < distances.length; i++) {
            int tmp = distances[i] / mid;
            if (tmp * mid == distances[i])
                tmp--;
            cnt += tmp;
        }
        return cnt;
    }
}
