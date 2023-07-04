package src.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 프로그래머스 - 조이스틱
 */
public class Pro조이스틱 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String name = br.readLine();
            sb.append(solution(name)).append('\n');
        }
        System.out.println(sb);
    }

    public static int solution(String name) {
        int cnt = 0;
        int length = name.length();
        int index; // 값을 확인하기 위한 용도
        int offset = name.length() - 1; // 좌우 움직임 수 체크

        for (int i = 0; i < name.length(); i++) {
            cnt += Math.min(name.charAt(i) - 'A', 26 - name.charAt(i) + 'A');

            index = i + 1;
            while (index < length && name.charAt(index) == 'A') {
                index++;
            }

            offset = Math.min(offset, i * 2 + length - index); // 정방향 이동
            offset = Math.min(offset, (length - index) * 2 + i); // 역방향 이동
        }
        return cnt + offset;
    }
}

