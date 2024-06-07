class Solution {
    int targetNumber = 0;
    public int solution(int[] numbers, int target) {
        targetNumber = target;
        return dfs(numbers, 0, 0);
    }
    
    public int dfs(int[] numbers, int depth, int numberSum){
        int answer = 0;
        if(depth == numbers.length){
            if(numberSum == targetNumber){return 1;}
            return 0;
        }
        answer += dfs(numbers, depth+1, numberSum + numbers[depth]);
        answer += dfs(numbers, depth+1, numberSum - numbers[depth]);
        return answer;
    }
}