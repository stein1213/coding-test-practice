import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        Stack<Integer> stack = new Stack<>();
        
        List<String> operators = new ArrayList<>();
        
        int x = scanner.nextInt();
        
        int count = 0;
        
        for(int i = 1; i <= n; i++) {
            
            stack.push(i);
            operators.add("+");
            
            while(!stack.isEmpty() && stack.peek() == x) {
                
                stack.pop();
                
                count++;
                
                if (count < n) {
                    x = scanner.nextInt();
                }

                operators.add("-");
                
            }
        }
        
        if (operators.size() < n * 2) {
            System.out.println("NO");
        } else {
            for (String operator : operators) {
                System.out.println(operator);
            }
        }
    }
}