import java.util.*;
import java.lang.Math;
public class JavaApplication {
    public static void main(String[] args) {
         ArrayList<Integer> arr = new ArrayList();
         Scanner scan = new Scanner(System.in);
        System.out.print(" inputkan Panjang Array : ");
              int panjang = scan.nextInt();
              for (int i = 0; i <= panjang- 1; i++) {
                  
            System.out.print("Nilai index ke "+i+" : ");
            int nilai = scan.nextInt();
            arr.add(nilai);
        }
        for ( int i = 0; i <= panjang - 2; i++) {
            int jMin = i;
            for (int j = 1 + i; j <= panjang - 1; j++) {
             if (arr.get(j) < arr.get(jMin)) {
                    jMin = j;
                }
            }
            if (jMin != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(jMin));
                arr.set(jMin, temp);
            }
        }
        System.out.println(arr);
    }
}
