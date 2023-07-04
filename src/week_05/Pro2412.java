package src.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2412번 암벽 등반
 * 시간 복잡도: n * T의 경우의 수를 계산하면 10,000,000,000 으로 시간 초과가 뜰 것이다.
 *           따라서 모든 경우를 따지기 보다 정상의 경우를 도달할 수 있는 경우를 적절하게 비교하며
 *           bfs를 활용하는 것이 관건이다.
 */
class Hole implements Comparable<Hole> {
    int x;
    int y;

    public Hole(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Hole o) {
        int tmp = this.x - o.x;
        if (tmp == 0)
            return this.y - o.y;
        return tmp;
    }
}
public class Pro2412 {
    static int n, T;
    static ArrayList<Hole> holes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        ArrayList<Hole> holes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            holes.add(new Hole(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(holes);
        visited = new boolean[n];
        int res = find_K(holes);
        System.out.println(res);
    }

    private static int find_K(ArrayList<Hole> holes) {
        Queue<Hole> queue = new LinkedList<>();
        Queue<Integer> order = new LinkedList<>();
        queue.add(new Hole(0, 0));
        order.add(-1);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int j = 0; j < qSize; j++) {
                Hole hole = queue.poll();
                if (hole.y == T) {
                    return cnt;
                }
                int index = order.poll();
                for (int i = index + 1; i < n; i++) {
                    if (Math.abs(holes.get(i).x - hole.x) > 2)
                        break;
                    boolean p = Math.abs(holes.get(i).y - hole.y) <= 2;
                    if (p && !visited[i]) {
                        queue.add(new Hole(holes.get(i).x, holes.get(i).y));
                        order.add(i);
                        visited[i] = true;
                    }
                }
                for (int i = index - 1; i >= 0; i--) {
                    if (Math.abs(holes.get(i).x - hole.x) > 2)
                        break;
                    boolean p = Math.abs(holes.get(i).y - hole.y) <= 2;
                    if (p && !visited[i]) {
                        queue.add(new Hole(holes.get(i).x, holes.get(i).y));
                        order.add(i);
                        visited[i] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
