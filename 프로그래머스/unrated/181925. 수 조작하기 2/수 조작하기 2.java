class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int log = numLog[0];
        for(int i=1;i<numLog.length;i++){
            if(log + 1 == numLog[i]){sb.append("w");}
            else if(log - 1 == numLog[i]){sb.append("s");}
            else if(log + 10 == numLog[i]){sb.append("d");}
            else {sb.append("a");}
            log = numLog[i];
        }
        
        return sb.toString();
    }
}