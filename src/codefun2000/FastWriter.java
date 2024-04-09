package codefun2000;

import java.io.*;

/**
 * ClassName: FastWriter
 * Description:
 * Author Inamikanju
 * Create 2024/4/9 20:20
 * Version 1.0
 */
public class FastWriter {
    PrintWriter pw;

    public FastWriter() {
        this.pw = new PrintWriter(new OutputStreamWriter(System.out));
    }

    public void println(Object o) {
        pw.println(o);
    }

    public void flush() {
        pw.flush();
    }

}
