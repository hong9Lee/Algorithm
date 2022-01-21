import java.util.*;

class answer {
    public String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();
        for (int i = record.length-1; i >= 0; i--) {
            String flag = record[i].split(" ")[0];
            String id = record[i].split(" ")[1];

            if (map.get(id) == null && !flag.equals("Leave")) {
                map.put(id, record[i].split(" ")[2]);
            }
        }

        List<String> rList = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String key = record[i].split(" ")[0];
            String id = record[i].split(" ")[1];
            String nm = map.get(id);

            if(key.equals("Change")) continue;

            StringBuilder sb = new StringBuilder();
            if(key.equals("Enter")) sb.append(nm + "님이 들어왔습니다.");
            else {
                sb.append(nm + "님이 나갔습니다.");
            }

            rList.add(sb.toString());
        }

        String[] answer = rList.toArray(new String[rList.size()]);
        return answer;
    }

    public static void main(String[] args) {

        answer solution = new answer();
//        solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        solution.solution(new String[]{"Leave uid1234", "Leave uid4567"});

    }
}
