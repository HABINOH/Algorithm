import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String msg = br.readLine();
        String regex = "^(100+1+|01)+";

        if(msg.matches(regex)){
            bw.write("SUBMARINE");
        }else{
            bw.write("NOISE");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
