import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int loop=1;loop<=number;loop++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=1;i<=Math.sqrt(loop);i++){
                if(loop % i == 0){
                    list.add(i);
                    if(i != loop/i) {list.add(loop/i);}
                }
            }
            numberList.add(list.size());
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0;i<numberList.size();i++){
            int pushNumber = numberList.get(i);
            if(numberList.get(i) > limit){pushNumber = power;}
            answerList.add(pushNumber);
        }
        
        return answerList.stream().mapToInt(Integer::intValue).sum();
    }
}
// List<Integer> answerList = numberList.stream()
// .map(num -> num > limit ? power : num)
// .collect(Collectors.toList());