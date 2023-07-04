//package src.codingtest_2;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Pro4 {
//    static int[][] visit;
//
//    public static void main(String[] args) {
//        System.out.println(solution(new int[][]{{0, 0, 1, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 1, 1, 0, 0}}));
//    }
//
//    public static int solution(int[][] world) {
//        visit = new int[world.length][world[0].length];
//        for (int i = 0; i < world.length; i++)
//            Arrays.fill(visit[i], -1);
//        bfs(world.length, world[0].length, world);
//        for (int i = 0; i < world.length; i++) {
//            for (int j = 0; j < world[0].length; j++) {
//                System.out.print(visit[i][j] + " ");
//            }
//            System.out.println();
//        }
//        return visit[world.length - 1][world[0].length - 1];
//    }
//
//    private static void bfs(int N, int M, int[][] world) {
//        Queue<Cylinder> queue = new LinkedList<>();
//
//        queue.offer(new Cylinder(0, 0, 1, 0, 1)); // x2
//        visit[0][0] = 0;
//        visit[1][0] = 0;
//
//        while (!queue.isEmpty()) {
//            int y1 = queue.poll();
//            int x1 = queue.poll();
//            int y2 = queue.poll();
//            int x2 = queue.poll();
//
//            if ((y1 == N - 1 && x1 == M - 1) || (y2 == N - 1 && x2 == M - 1)) {
//                return;
//            }
//
//            // 시계 방향 회전
//            clockRotate(N, M, queue, y1, x1, y2, x2, world);
//            // 반시계 방향 회전
//            reverseClockRotate(N, M, queue, y1, x1, y2, x2, world);
//            // 대각선 이동
//            diagonalMove(N, M, queue, y1, x1, y2, x2, world);
//            // 옆으로 이동
//            rightMove(N, M, queue, y1, x1, y2, x2, world);
//            // 아래로 이동
//            downMove(N, M, queue, y1, x1, y2, x2, world);
//        }
//    }
//
//    private static void clockRotate(int N, int M, Queue<Integer> queue, int y1, int x1, int y2, int x2, int[][] world) {
//        int ny1;
//        int nx1;
//        int ny2;
//        int nx2;
//        if (x1 == x2 && y1 + 1 == y2) {
//            ny1 = y1;
//            nx1 = x1 + 1;
//            ny2 = y2;
//            nx2 = x2;
//            if (nx1 >= M)
//                return;
//            if (world[y1][x1 + 1] == 1 || world[y2][x2 + 1] == 1)
//                return;
//        } else if (x1 - 1 == x2 && y1 + 1 == y2){
//            ny1 = y1 + 1;
//            nx1 = x1;
//            ny2 = y2;
//            nx2 = x1;
//        } else
//            return;
//        if (visit[ny1][nx1] != -1 || visit[ny1][nx1] > Math.max(visit[y1][x1], visit[y2][x2]) + 1)
//            return;
//        queue.offer(ny1); // y1
//        queue.offer(nx1); // x1
//        queue.offer(ny2); // y2
//        queue.offer(nx2); // x2
//        visit[ny1][nx1] = Math.max(visit[y1][x1], visit[y2][x2]) + 1;
//    }
//
//    private static void reverseClockRotate(int N, int M, Queue<Integer> queue, int y1, int x1, int y2, int x2, int[][] world) {
//        int ny1;
//        int nx1;
//        int ny2;
//        int nx2;
//        if (x1 == x2 && y1 + 1 == y2) {
//            ny1 = y1;
//            nx1 = x1;
//            ny2 = y2;
//            nx2 = x2 + 1;
//            if (ny2 < 0 || nx2 < 0 || ny2 >= N || nx2 >= M)
//                return;
//            if (world[y1][x1 + 1] == 1 || world[y2][x2 + 1] == 1)
//                return;
//        } else if (x1 + 1 == x2 && y1 + 1 == y2){
//            ny1 = y1;
//            nx1 = x1;
//            ny2 = y2 - 1;
//            nx2 = x1;
//        } else
//            return;
//        if (visit[ny2][nx2] != -1 || visit[ny2][nx2] > Math.max(visit[y1][x1], visit[y2][x2]) + 1)
//            return;
//        queue.offer(ny1); // y1
//        queue.offer(nx1); // x1
//        queue.offer(ny2); // y2
//        queue.offer(nx2); // x2
//        visit[ny2][nx2] = Math.max(visit[y1][x1], visit[y2][x2]) + 1;
//    }
//
//    private static void diagonalMove(int N, int M, Queue<Integer> queue, int y1, int x1, int y2, int x2, int[][] world) {
//        if (x1 == x2 || y1 == y2)
//            return;
//        int pass_y1 = y1;
//        int pass_x1 = x1 + 1;
//        int pass_y2 = y2;
//        int pass_x2 = x1;
//        int pass_y3 = y2 + 1;
//        int pass_x3 = x2;
//        if (pass_y1 < 0 || pass_x1 < 0 || pass_y1 >= N || pass_x1 >= M || pass_y3 < 0 || pass_x3 < 0 || pass_y3 >= N || pass_x3 >= M)
//            return;
//        if (world[pass_y1][pass_x1] == 1 || world[pass_y2][pass_x2] == 1 || world[pass_y2][pass_x2] == 1)
//            return;
//
//        int ny1 = y1 + 1;
//        int nx1 = x1 + 1;
//        int ny2 = y2 + 1;
//        int nx2 = x2 + 1;
//        if (visit[ny1][nx1] != -1 && visit[ny2][nx2] != -1)
//            return;
//        if (world[ny1][nx1] == 1 || world[ny2][nx2] == 1 || world[y1 + 2][x1 + 1] == 1)
//            return;
//        queue.offer(ny1);
//        queue.offer(nx1);
//        queue.offer(ny2);
//        queue.offer(nx2);
//        visit[ny1][nx1] = Math.max(visit[y1][x1], visit[y2][x2]) + 1;
//        visit[ny2][nx2] = Math.max(visit[y1][x1], visit[y2][x2]) + 1;
//    }
//
//    private static void rightMove(int N, int M, Queue<Integer> queue, int y1, int x1, int y2, int x2, int[][] world) {
//        int ny1 = y1;
//        int nx1 = x1 + 1;
//        int ny2 = y2;
//        int nx2 = x2 + 1;
//        if (nx1 >= M || nx2 >= M)
//            return;
//        if (visit[ny1][nx1] != -1 && visit[ny2][nx2] != -1)
//            return;
//        if (world[ny1][nx1] == 1 || world[ny2][nx2] == 1)
//            return;
//        queue.offer(ny1);
//        queue.offer(nx1);
//        queue.offer(ny2);
//        queue.offer(nx2);
//        visit[ny1][nx1] = Math.max(visit[y1][x1], visit[y2][x2]) + 1;
//        visit[ny2][nx2] = Math.max(visit[y1][x1], visit[y2][x2]) + 1;
//    }
//
//    private static void downMove(int N, int M, Queue<Integer> queue, int y1, int x1, int y2, int x2, int[][] world) {
//        int ny1 = y1 + 1;
//        int nx1 = x1;
//        int ny2 = y2 + 1;
//        int nx2 = x2;
//        if (ny1 >= N || ny2 >= N)
//            return;
//        if (visit[ny1][nx1] != -1 && visit[ny2][nx2] != -1)
//            return;
//        if (world[ny1][nx1] == 1 || world[ny2][nx2] == 1)
//            return;
//        queue.offer(ny1);
//        queue.offer(nx1);
//        queue.offer(ny2);
//        queue.offer(nx2);
//        visit[ny1][nx1] = Math.max(visit[y1][x1], visit[y2][x2]) + 1;
//        visit[ny2][nx2] = Math.max(visit[y1][x1], visit[y2][x2]) + 1;
//    }
//
//    static class Cylinder {
//        int y1;
//        int x1;
//        int y2;
//        int x2;
//        int dir; // 1(|), 2(/), 3(-), 4(\)
//
//        public Cylinder(int y1, int x1, int y2, int x2, int dir) {
//            this.y1 = y1;
//            this.x1 = x1;
//            this.y2 = y2;
//            this.x2 = x2;
//            this.dir = dir;
//        }
//    }
//}