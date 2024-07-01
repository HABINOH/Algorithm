import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < testCase; tc++){
            String result = "YES\n";
            int n = Integer.parseInt(br.readLine());

            String[] phoneNumbers = new String[n];
            for(int i=0;i<n;i++){
                phoneNumbers[i] = br.readLine();
            }

            Arrays.sort(phoneNumbers);
            Trie trie = new Trie();

            for (String phoneNumber : phoneNumbers) {
                trie.insert(phoneNumber);
            }
            for (String phoneNumber : phoneNumbers) {
                if (trie.search(phoneNumber)) {
                    result = "NO\n";
                    break;
                }
            }
            bw.write(result);
        }
        bw.flush();
    }
    static class Node{
        Map<Character, Node> child = new HashMap<>();
        String str;
        boolean end;
    }

    static class Trie{
        Node root = new Node();
        void insert(String str){
            Node node = this.root;
            for(int i=0; i<str.length(); i++){
                node = node.child.computeIfAbsent(str.charAt(i), key -> new Node());
                node.str = str;
            }
            node.end = true;
        }
        boolean search(String str){
            Node node = this.root;

            for(int i=0;i<str.length();i++){
                node = node.child.getOrDefault(str.charAt(i), null);
                if(node.str.equals(str)){
                    return false;
                }
            }
            return true;
        }
    }
}