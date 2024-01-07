class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<code.length();i++){
            if(code.charAt(i) == '1'){
                if(mode == 0){mode = 1;}
                else {mode = 0;}
            }
            else if(mode == 0 && i%2==0){
                sb.append(code.charAt(i));
            }
            else if(mode == 1 && i%2==1){
                sb.append(code.charAt(i));
            }
        }
        if(sb.length() == 0){return "EMPTY";}
        return sb.toString();
    }
}