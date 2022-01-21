import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] solution(String[] record) {


        List<String> idList = new ArrayList();
        for (String s : record) {
            if(!idList.contains(s.split(" ")[1])) idList.add(s.split(" ")[1]);
        }

//      "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan";

        ArrayList<String> rList = new ArrayList<String>(Arrays.asList(record));
        for (String chId : idList) {
            String strNm = "";

            for (int i = rList.size()-1; i >= 0; i--) {
                if(rList.get(i).length() > 0 && rList.get(i).split(" ")[1].equals(chId)){
                    String key = rList.get(i).split(" ")[0];

                    if(strNm.length() == 0) strNm = rList.get(i).split(" ")[2];
                    String result = strNm + "님이 ";

                    if(key.equals("Change")) {
                        rList.set(i, "");
                        continue;
                    }else if(key.equals("Enter")){
                        result += "들어왔습니다.";
                    }else {
                        result += "나갔습니다.";
                    }

                    rList.set(i, result);
                }
            }
        }

        rList.removeAll(Arrays.asList(""));
        String[] answer = rList.toArray(new String[rList.size()]);

        return answer;
    }

    public static void main(String[] args) {

//        Solution solution = new Solution();
//        solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }
}
