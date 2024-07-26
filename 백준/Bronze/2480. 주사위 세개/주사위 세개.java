import java.util.Scanner;

class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        
        int award = 0;
        
        if (a == b) {
            
            if (b == c) {
                award = 10000 + a * 1000;
            } else {
                
                award = 1000 + a * 100;
            }
        } else if (b == c) {
            
            award = 1000 + b * 100;
            
        } else if(a == c){
            
            award = 1000 + c * 100;
            
        } else {
            
            int max = Math.max(Math.max(a, b), c);
            
            award = max * 100;
        }
        
        System.out.println(award);
    }
}