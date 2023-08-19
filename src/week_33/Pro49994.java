package src.week_33;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 방문 길이
 */
public class Pro49994 {

    static int res;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][][] visit;
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        res = 0;
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {
        visit = new boolean[11][11][4];

        map.put('U', 0);
        map.put('R', 1);
        map.put('D', 2);
        map.put('L', 3);

        Queue<Integer> que = new LinkedList<>();
        que.add(5);
        que.add(5);
        for (int i = 0; i < dirs.length(); i++) {
            int y = que.poll();
            int x = que.poll();
            int ny = y + dir[map.get(dirs.charAt(i))][0];
            int nx = x + dir[map.get(dirs.charAt(i))][1];
            if (ny < 0 || nx < 0 || ny >= 11 || nx >= 11) {
                que.add(y);
                que.add(x);
                continue;
            }
            if (!visit[ny][nx][map.get(dirs.charAt(i))])
                res++;
            visit[ny][nx][map.get(dirs.charAt(i))] = true;
            if (map.get(dirs.charAt(i)) == 0)
                visit[y][x][2] = true;
            else if (map.get(dirs.charAt(i)) == 1)
                visit[y][x][3] = true;
            else if (map.get(dirs.charAt(i)) == 2)
                visit[y][x][0] = true;
            else if (map.get(dirs.charAt(i)) == 3)
                visit[y][x][1] = true;
            que.add(ny);
            que.add(nx);
        }
        return res;
    }
}
