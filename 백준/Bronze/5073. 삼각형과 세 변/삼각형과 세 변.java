import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true){
            
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
    
            ArrayList<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            Collections.sort(list);

            int result = list.get(0) + list.get(1);
            if(a+b+c == 0){
                break;
            }else{
                if(list.get(2) >= result){
                    System.out.println("Invalid");
                }else{
                    if(a == b && b == c){
                        System.out.println("Equilateral");
                    }else if((a == b && b!=c) || (b==c && a!=b ) || (a == c && b!=c)){
                        System.out.println("Isosceles");
                    }else if(a!=b && b!=c && c!=a){
                        System.out.println("Scalene");
                    }
                }
            }
    
            
           
           
        }
       
    }
}