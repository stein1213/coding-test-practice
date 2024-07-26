import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int H = scanner.nextInt();
        int M = scanner.nextInt();
        
        if (M >= 45) {
            
            M -= 45;
            
        } else {
 
            M = 60 + M - 45;
            if (H > 0) {
                
                H -= 1;
            } else {
                
                H = 23;
            }
        }
        
        System.out.println(H + " " + M);
    }
}