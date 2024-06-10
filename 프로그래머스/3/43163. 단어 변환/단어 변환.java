class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        dfs(begin, 0, words, target, visited);

        if(answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }
    // 현재 단어에서 1개만 다른 단어가 있는지?
    public void dfs(String compareWord, int cnt, String[] words, String target, boolean[] visited){
        if(target.equals(compareWord)){
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i=0;i<words.length;i++){
            if(!visited[i] && checkWord(compareWord, words[i])){
                visited[i] = true;
                dfs(words[i], cnt+1, words, target, visited);
                visited[i] = false;
            }
        }
    }
    public boolean checkWord(String wordOne, String wordTwo){
        int wordCount = 0;
        if(wordOne.length() != wordTwo.length()){
            return false;
        }
        for(int i=0;i<wordOne.length();i++){
            if(wordOne.charAt(i) != wordTwo.charAt(i)){wordCount++;}
        }
        return wordCount == 1 ? true : false;
    }
}