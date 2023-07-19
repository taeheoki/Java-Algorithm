package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro22856 {
    static int N;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            nodes[cur] = new Node(left, right);
        }
        int res = inorderTraversal(1, true);
        System.out.println(res);
    }

    private static int inorderTraversal(int index, boolean flag) {
        int count = 0;

        if (nodes[index].left != -1) {
            count += 2 + inorderTraversal(nodes[index].left, true);
        }

        if (nodes[index].right != -1) {
            count += flag && index != 1 ? 2 : 1;
            count += inorderTraversal(nodes[index].right, index == 1 ? false : flag);
        }

        return count;
    }

    private static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
