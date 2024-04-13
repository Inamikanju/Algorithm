package Test.testScanner;

import java.io.*;
import java.util.StringTokenizer;

/**
 * ClassName: TestScanner
 * Description:
 * Author Inamikanju
 * Create 2024/4/13 14:56
 * Version 1.0
 */
public class TestScanner {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(sc.next());
        int m = sc.nextInt();
        String s = sc.nextLine();
        out.println(n);
        out.println(m);
        out.println(s);
        out.flush();
    }
}

class FastReader {
    StringTokenizer st;
    BufferedReader br;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }
}
