package codefun2000.p1082满二叉树计数;

/**
 * ClassName: Main
 * Description:
 * Author Inamikanju
 * Create 2024/4/9 23:42
 * Version 1.0
 */

import java.io.*;
import java.util.*;

class Main {
    static int count = 0;

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        FastReader sc = new FastReader();
        FastWriter out = new FastWriter();

        // YOUR CODE HERE!
        int n = sc.nextInt();
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode());
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            TreeNode node = new TreeNode();
            list.add(node);
            node.left = a;
            node.right = b;
        }

        isFull(list, 1);

        out.println(count);
        out.flush();
    }

    private static boolean isFull(List<TreeNode> list, int i) {
        if (i == -1 || i == 0) {
            return false;
        }
        TreeNode node = list.get(i);
        if (node.left == -1 && node.right == -1) {
            count++;
            node.val++;
            return true;
        }
        boolean left = isFull(list, node.left);
        boolean right = isFull(list, node.right);

        if (node.left != -1 && node.right != -1 && left && right && list.get(node.left).val == list.get(node.right).val) {
            count++;
            node.val = list.get(node.left).val + 1;
            return true;
        }
        return false;
    }
}

class TreeNode {
    int val;
    int left;
    int right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }
}

class FastReader {
    StringTokenizer st;
    BufferedReader br;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

class FastWriter {
    PrintWriter out;

    public FastWriter() {
        this.out = new PrintWriter(new OutputStreamWriter(System.out));
    }

    void println(Object o) {
        out.println(o);
    }

    void flush() {
        out.flush();
    }
}
