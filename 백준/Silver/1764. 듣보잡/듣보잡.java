import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        HashSet<String> name = new HashSet<>();
        for(int i=0;i<n;i++){
            name.add(br.readLine());
        }
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            String compareName = br.readLine();
            if(name.contains(compareName)){
                result.add(compareName);
            }
        }
        Collections.sort(result);
        
        System.out.println(result.size());
        result.forEach(System.out::println);
//        bw.flush();
//        bw.close();
        br.close();
    }
}
