import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        // report 중복 제거
        String[] ReportDupRemove = Arrays.stream(report).distinct().toArray(String[]::new);


        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : ReportDupRemove) {
            map.put(str.split(" ")[1], map.getOrDefault(str.split(" ")[1], 0)+1);
        }


        Map<String, List<String>> repMap = new HashMap<String, List<String>>();
        for (String id : id_list) {
            List<String> objList = new ArrayList<String>();

            for (String reportId : ReportDupRemove) {
                String[] splitIdArr = reportId.split(" ");

                if(id.equals(splitIdArr[0])) objList.add(splitIdArr[1]);
            }

            if(objList.size() == 0) repMap.put(id, null);
            repMap.put(id, objList);
        }





        int[] answer = new int[id_list.length];

        int idx = 0;
        for (String id : id_list) {
            int reportNum = 0;

            if(repMap.get(id) == null) continue;
            for (String reped : repMap.get(id)) {
                if(map.get(reped) == null) continue;
                if(map.get(reped) >= k) reportNum++;
            }

            answer[idx] = reportNum;
            idx++;
        }



        return answer; // 각 유저가 받은 메일의 수 (정지시킨 횟수 + 정지당한 메일 횟수)
    }

    public static void main(String[] args) {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        Solution solution = new Solution();
        int[] result =  solution.solution(id_list, report, k);

    }
}
