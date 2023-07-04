package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 5639 - 이진 검색 트리
 * 문제 이해:
 * 시간 복잡도:
 */
public class Pro5639 {
    static StringBuilder sb = new StringBuilder();
    static int key;
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        key = Integer.parseInt(br.readLine());;
        head = new Node(key);
        String tmp;
        while ((tmp = br.readLine()) != null && !tmp.isEmpty()) {
            key = Integer.parseInt(tmp);
            Node tmpNode = head;
            while (true) {
                if (key < tmpNode.key) {
                    if (tmpNode.left == null) {
                        tmpNode.left = new Node(key);
                        break;
                    }
                    tmpNode = tmpNode.left;
                } else {
                    if (tmpNode.right == null) {
                        tmpNode.right = new Node(key);
                        break;
                    }
                    tmpNode = tmpNode.right;
                }
            }
        }
        postOrder(head);
        System.out.println(sb);
    }

    private static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            sb.append(node.key).append("\n");
        }
    }


    private static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }
}
