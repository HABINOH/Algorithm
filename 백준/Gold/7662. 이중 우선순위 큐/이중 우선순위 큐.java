import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(stk.nextToken());

        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for(int i=0;i<n;i++){
                stk = new StringTokenizer(br.readLine());
                String cmd = stk.nextToken();
                int num = Integer.parseInt(stk.nextToken());

                if("I".equals(cmd)){
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                }else{ //D
                    if(tm.isEmpty()){continue;}
                    if(num == 1){
                        int maxKey = tm.lastKey();
                        if(tm.get(maxKey) == 1){
                            tm.remove(maxKey);
                        }else{
                            tm.put(maxKey, tm.get(maxKey) -1);
                        }
                    }
                    else{
                        int minKey = tm.firstKey();
                        if(tm.get(minKey) == 1){
                            tm.remove(minKey);
                        }else{
                            tm.put(minKey, tm.get(minKey) - 1);
                        }
                    }
                }
            }
            if(tm.isEmpty()){
                bw.write("EMPTY");
            }
            else{
                bw.write(tm.lastKey() + " ");
                bw.write(String.valueOf(tm.firstKey()));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
