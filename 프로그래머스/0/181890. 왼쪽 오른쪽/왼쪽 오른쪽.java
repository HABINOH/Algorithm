import java.util.*;
class Solution {
    public ArrayList solution(String[] str_list) {
        ArrayList<String> list = new ArrayList<>();
        int end = -1;
        int start = -1;
        for(int i=0;i<str_list.length;i++){
            if(str_list[i].equals("l")){
                end = i;
                break;
            }else if(str_list[i].equals("r")){
                start = i+1;
                break;
            }
        }
        if(start == -1 && end == -1){return list;}
        if(start != -1){
            for(int i=start; i<str_list.length;i++){
                list.add(str_list[i]);
            }
        }
        else{
            for(int i=0;i<end;i++){
                list.add(str_list[i]);
            }
        }
        
        return list;
    }
}