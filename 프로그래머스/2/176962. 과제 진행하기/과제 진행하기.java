import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        Stack<String[]> stack = new Stack<>();
        
        List<String> list = new ArrayList<>();
        
        Arrays.sort(plans, (a, b) -> {
            
            return toMinute(a[1]) - toMinute(b[1]);
        });
        
        int current = 0;
        
        int term = 0;
        
        for (String[] plan : plans) {
            
            if (stack.isEmpty()) {
               
                stack.push(new String[]{plan[0], plan[2]});
                
                current = toMinute(plan[1]);
                
                continue;
            } 
            
            term = toMinute(plan[1]) - current;
            
            while (term != 0 && !stack.isEmpty()) {
                
                String[] oldPlan = stack.pop();
                
                int remainTime = Integer.parseInt(oldPlan[1]);
                
                if (term >= remainTime) {
                    
                    term -= remainTime;
                    
                    list.add(oldPlan[0]);
                    
                    System.out.println(oldPlan[0]);
                    
                } else {
                    
                    oldPlan[1] = remainTime - term + "";
                    
                    stack.push(oldPlan);
                    
                    term = 0;
                }
            }
            
            stack.push(new String[]{plan[0], plan[2]});
            
            current = toMinute(plan[1]);
        }
        
        while (!stack.isEmpty()) {
            
            String[] oldPlan = stack.pop();
            
            list.add(oldPlan[0]);
            

        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    int toMinute(String start) {
        
        int hour = Integer.parseInt(start.substring(0, 2));
        
        int minute = Integer.parseInt(start.substring(3));
        
        return hour * 60 + minute;
    }
}