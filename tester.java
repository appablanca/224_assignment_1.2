import java.util.*;
public class tester {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N,M;
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        graph g = new graph(N+1);

        for(int i = 0; i < M; i++){     //adding edges to the graph
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.addE(a,b);
        }
        
        int start = sc.nextInt();   //taking the start and end points
        int end = sc.nextInt();
        
            
        










        sc.close();
    }
    
}
