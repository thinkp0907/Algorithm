import java.util.*;

public class Solution_모의고사 {

	public static void main(String[] args) {
		

	}
	public int[] solution(int[] answers) {
        int[] answer = {};
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] result = new int[3];
        ArrayList<Integer> list = new ArrayList<>();
        
        int num = 0;
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == (person1[i%person1.length])) result[0]++;
            if(answers[i] == (person2[i%person2.length])) result[1]++;
            if(answers[i] == (person3[i%person3.length])) result[2]++;
           
        }
        num = Math.max(Math.max(result[0], result[1]), result[2]);
        for(int i=0; i<3; i++) {
            if(result[i] == num) list.add(i+1);
        }
        answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
	

}
