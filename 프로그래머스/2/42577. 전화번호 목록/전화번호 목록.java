import java.util.*;
class Solution{
    public boolean solution(String[] phone_book){
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        Trie trie = new Trie();
        
        for(int i=0;i<phone_book.length;i++){
            trie.insert(phone_book[i]);
        }
        
        for(int i=0;i<phone_book.length;i++){
            if(trie.search(phone_book[i])){
                answer = false;
                break;
            }
        }
        return answer;
    }
    
    class Node{
        Map<Character, Node> child = new HashMap<>();
        String str;
        boolean end;
    }
    
    class Trie{
        Node root = new Node();
        
        void insert(String s){
            Node node = this.root;
            for(int i=0;i<s.length();i++){
                node = node.child.computeIfAbsent(s.charAt(i), key -> new Node());
                node.str = s;
            }
            node.end = true;
        }
        
        boolean search(String s){
            Node node = this.root;
            for(int i=0;i<s.length();i++){
                node = node.child.getOrDefault(s.charAt(i), null);   
                if(node.str.equals(s) || node == null){
                    return false;
                }
            }
            return node.end;
        }
    }
}


// import java.util.*;
// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
        
//         Arrays.sort(phone_book);
        
//         for(int i=1;i<phone_book.length;i++){
//             String str = phone_book[i-1];
//             if(phone_book[i].startsWith(str)){
//                 answer = false;
//                 break;
//             }
//         }
//         return answer;
//     }
// }