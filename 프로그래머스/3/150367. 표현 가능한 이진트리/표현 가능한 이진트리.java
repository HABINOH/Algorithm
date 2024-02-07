import java.util.*;
class Solution {
    public ArrayList solution(long[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(long number : numbers){
            if(isPullTree(number)){
                answer.add(1);
            }else{
                answer.add(0);
            }
        }
        return answer;
    }
    public boolean isPullTree(long number){
        //2진수 변환
        String binary = changeBinary(number);

        //앞에 0빠진거 더해주기
        String pullBinary = changeFullBinary(binary);
        
        //포화 이진트리인지 확인하기
        return isBinaryTree(pullBinary);
    }
    public String changeBinary(long number){
        StringBuilder sb = new StringBuilder();
        while(number>=1){
            sb.append(number%2);
            number = number/2;
        }
        return sb.reverse().toString();
    }
    public String changeFullBinary(String binary){ //노드 깊이만큼 들어감
        int len = binary.length();
        int nodeCnt = 1;
        int depth = 1;
        while (len > nodeCnt) {
            depth *= 2; // 1 깊이마다 노드 개수는 2배로 증가
            nodeCnt += depth;
        }
        int offset = nodeCnt - len; //노드 총 개수 - 현재 만들어진 노드 개수
        String plusZero = "";
        for(int i=0;i<offset;i++){
            plusZero = "0" + plusZero;
        }
        return plusZero + binary;
    }
    public boolean isBinaryTree(String pullBinary){
        if(pullBinary.length() == 1 || allZero(pullBinary)){
            return true;
        }
        int mid = pullBinary.length() / 2;
        
        String leftString = pullBinary.substring(0, mid);
        String rightString = pullBinary.substring(mid+1);
        
        if(pullBinary.charAt(mid) == '0'){
            return false;
        }
        if(isBinaryTree(leftString) && isBinaryTree(rightString) && pullBinary.charAt(mid) == '1') return true;
        else return false;
    }
    public boolean allZero(String subBinary){
        for(int i=0;i<subBinary.length();i++){
            if(subBinary.charAt(i) != '0'){return false;}
        }
        return true;
    }
}

/*
1. 2진수 변환
2. 앞에 0빠진거 더해주기
3. 포화 이진트리인지 확인하기 (mid 기준으로 오른쪽, 왼쪽 트리 확인 DFS)
*/