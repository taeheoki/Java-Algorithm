package src.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2343번 기타 레슨
 * 문제 이해: 블루레이 녹화 시 순서가 바뀌기 때문에 i와 j의 강의를 같은 블루레이에 녹화하고 싶을 경우
 *          i와 j 사이의 모든 강의도 같은 블루레이에 들어가야 한다.
 *          이럴 경우 최대한 블루레이 크기를 최소로하는 M개의 블루레이를 구할 때,
 *          가능한 블루레이 크기 중 최소는 무엇인가? (이때, 블루레이의 크기는 모두 동일하다.)
 * 시간 복잡도:
 *
 */
public class Pro2343 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long res = bSearch();
        System.out.println(res);
    }

    private static long bSearch() {
        long left = Arrays.stream(arr).max().getAsInt();
        long right = Arrays.stream(arr).sum();;
        long res = left;
        while (left <= right) {
            long mid = (left + right) / 2;
            long tmp = getCount(mid);
            if (tmp <= M) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return res;
    }

    private static long getCount(long mid) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                if (sum > mid) {
                    i = j - 1;
                    break;
                } else if (j == N - 1)
                    i = j;
            }
            cnt++;
        }
        return cnt;
    }
}
