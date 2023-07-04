package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 1991 - 트리 순회
 * 문제 이해: 주어진 트리에서 전위 순회, 중위 순회, 후위 순회한 결과를 출력하라.
 * 시간 복잡도: O(N)
 */
public class Pro1991 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Node[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        node = new Node[N];
        for (int i = 0; i < N; i++) {
            node[i] = new Node();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char data = st.nextToken().toCharArray()[0];
            char left_node = st.nextToken().toCharArray()[0];
            char right_node = st.nextToken().toCharArray()[0];
            node[data - 'A'].data = data;
            if (left_node != '.')
                node[data - 'A'].left = node[left_node - 'A'];
            if (right_node != '.')
                node[data - 'A'].right = node[right_node - 'A'];
        }
        pro();
    }

    private static void pro() {
        // 전위 순회
        preorder_traverse(node[0]);
        sb.append("\n");
        // 중위 순회
        inorder_traverse(node[0]);
        sb.append("\n");
        // 후위 순회
        postorder_traverse(node[0]);
        sb.append("\n");
        System.out.println(sb);
    }

    private static void postorder_traverse(Node node) {
        if (node != null) {
            postorder_traverse(node.left);
            postorder_traverse(node.right);
            sb.append(node.data);
        }
    }

    private static void inorder_traverse(Node node) {
        if (node != null) {
            inorder_traverse(node.left);
            sb.append(node.data);
            inorder_traverse(node.right);
        }
    }

    private static void preorder_traverse(Node node) {
        if (node != null) {
            sb.append(node.data);
            preorder_traverse(node.left);
            preorder_traverse(node.right);
        }
    }

    private static class Node {
        char data;
        Node left;
        Node right;
    }
}
