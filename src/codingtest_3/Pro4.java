package src.codingtest_3;

import com.sun.source.tree.Tree;

import java.util.*;

public class Pro4 {
    static ArrayList<Integer>[] trees;
    static PriorityQueue<Elem> pq;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4, new int[]{0, 0, 2, 1})));
        System.out.println(Arrays.toString(solution(2, new int[]{1, 0})));
        System.out.println(Arrays.toString(solution(8, new int[]{3, 0, 2, 1, 1, 0, 0, 0})));
    }

    public static int[] solution(int n, int[] win_cnt) {

        pq = new PriorityQueue<>();
        for (int i = 0; i < win_cnt.length; i++) {
            pq.add(new Elem(i + 1, win_cnt[i]));
        }
        int depth = getDepth(n);
        trees = new ArrayList[depth];
        for (int i = 0; i < depth; i++) {
            trees[i] = new ArrayList<>();
        }
        pro(depth);


        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = trees[depth - 1].get(i);
        }
        return result;
    }

    private static void pro(int depth) {
        int i = 1;
        Elem first = pq.poll();
        trees[0].add(first.idx);
        while (i < depth && i <= trees.length) {
            while (!trees[i - 1].isEmpty()) {
                int node1 = trees[i - 1].remove(0);
                int node2 = pq.poll().idx;
                if (node1 < node2) {
                    trees[i].add(node1);
                    trees[i].add(node2);
                } else {
                    trees[i].add(node2);
                    trees[i].add(node1);
                }
            }
            i++;
        }
    }

    private static int getDepth(int n) {
        int depth = 0;
        while (n != 0) {
            n /= 2;
            depth++;
        }
        return depth;
    }

    private static class Elem implements Comparable<Elem> {
        int idx;
        int win_cnt;

        public Elem(int idx, int win_cnt) {
            this.idx = idx;
            this.win_cnt = win_cnt;
        }

        @Override
        public int compareTo(Elem o) {
            if (this.win_cnt == o.win_cnt)
                return this.idx - o.idx;
            return o.win_cnt - this.win_cnt;
        }
    }
}
