class Solution {
    public int solution(int[][] sizes) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i=0;i<sizes.length;i++){
            max = Math.max(Math.max(sizes[i][0], sizes[i][1]), max);
            
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            
            max2 = Math.max(sizes[i][1], max2);
        }
        return max * max2;
    }
}