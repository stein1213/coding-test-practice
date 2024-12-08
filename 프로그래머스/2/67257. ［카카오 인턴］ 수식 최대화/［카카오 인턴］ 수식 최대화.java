import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        LinkedList<Long> longList = new LinkedList<>();
        
        LinkedList<Character> optList = new LinkedList<>();
        
        Set<Character> signSet = new HashSet<>();
        
        int pointer = 0;
        
        for(int i = 0; i < expression.length(); i++) {
            
            char c = expression.charAt(i);
            
            if (!('0' <= c && c <= '9')) {
                
                signSet.add(c);
                
                longList.add(Long.valueOf(expression.substring(pointer, i)));
                optList.add(c);
                pointer = i + 1;
            }
        }
        
        longList.add(Long.valueOf(expression.substring(pointer)));
        
        Iterator<Character> itr = signSet.iterator();
        
        char[] sign = new char[signSet.size()];
        
        int idx = 0;
        
        while(itr.hasNext()) {
            char c = itr.next();
            sign[idx++] = c;
        }
        
        boolean[] visited = new boolean[sign.length];
        
        List<Character> current = new ArrayList<>();
        
        List<List<Character>> signList = new ArrayList<>();
        
        perm(sign, signList, visited, current);
        
        LinkedList<Long> tmpLongList;
        LinkedList<Character> tmpOptList;    
        
        for(List<Character> operators : signList) {
            
            tmpLongList = new LinkedList<>(longList);
            tmpOptList = new LinkedList<>(optList);
            
            for(char c : operators) {
                
                System.out.print(c);
                
                int index = 0;
                
                while(index < tmpOptList.size()) {
                    
                    if (tmpOptList.get(index) == c) {
                        
                        long tmp = calc(tmpLongList.get(index), tmpLongList.get(index + 1), tmpOptList.get(index));
                        
                        tmpLongList.remove(index + 1);
                        tmpLongList.set(index, tmp);
                        tmpOptList.remove(index);
                        
                    } else index++;
                }
            }
            
            System.out.println();
            answer = Math.max(Math.abs(tmpLongList.getFirst()), answer);
        }
          
        return answer;
    }
    
    void perm(char[] sign, List<List<Character>> signList, boolean[] visited, List<Character> current) {
        
        current = new ArrayList(current);
        
        if (current.size() == sign.length) {
            signList.add(current);
            return;
        }
        
        for(int i = 0; i < sign.length; i++) {
            
            if (visited[i]) continue;
            
            visited[i] = true;
            current.add(sign[i]);
            perm(sign, signList, visited, current);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
    
    long calc(long a, long b, char c) {
        
        switch(c) {
                
            case '*' : return a * b;
            case '-' : return a - b;
            case '+' : return a + b;
        }    
        return 0;
    } 
}