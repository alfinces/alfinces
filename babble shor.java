//1
import java.util.ArrayList;
import java.util.Scanner;

public class ShortinJava {
    
      private final ArrayList<Integer> arrayToSort;

    public ExampleClass1(ArrayList<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public ArrayList<Integer> getArrayAfterSorting() {
        return arrayToSort;
    }

    public void divideArrayElements(int indexStart, int indexEnd) {

        if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) {
            int middleElement = (indexEnd + indexStart) / 2;

            divideArrayElements(indexStart, middleElement);
            divideArrayElements(middleElement + 1, indexEnd);

            mergeArrayElements(indexStart, middleElement, indexEnd);
        }
    }

    public void mergeArrayElements(int indexStart, int indexMiddle, int indexEnd) {

        ArrayList<Integer> tempArray = new ArrayList<>();

        int getLeftIndex = indexStart;
        int getRightIndex = indexMiddle + 1;

        while (getLeftIndex <= indexMiddle && getRightIndex <= indexEnd) {

            if (arrayToSort.get(getLeftIndex) <= arrayToSort.get(getRightIndex)) {

                tempArray.add(arrayToSort.get(getLeftIndex));
                getLeftIndex++;

            } else {

                tempArray.add(arrayToSort.get(getRightIndex));
                getRightIndex++;

            }
        }

        while (getLeftIndex <= indexMiddle) {
            tempArray.add(arrayToSort.get(getLeftIndex));
            getLeftIndex++;
        }

        while (getRightIndex <= indexEnd) {
            tempArray.add(arrayToSort.get(getRightIndex));
            getRightIndex++;
        }


        for (int i = 0; i < tempArray.size(); indexStart++) {
            arrayToSort.set(indexStart, tempArray.get(i++));

        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Panjang Array : ");
        int panjang = scan.nextInt();
        for (int i = 0; i < panjang; i++) {
            int nilai = scan.nextInt();
            integerArrayList.add(nilai);
        }

        ExampleClass1 exampleClass1 = new ExampleClass1(integerArrayList);

        System.out.print("Array Sebelum Merge Sort : ");
        for (Integer integer : exampleClass1.getArrayAfterSorting()) {
            System.out.print(integer+" ");
        }

        System.out.println();

        exampleClass1.divideArrayElements(0, integerArrayList.size() - 1);

        System.out.print("Array Setelah Merge Sort : ");
        for (Integer integer : exampleClass1.getArrayAfterSorting()) {
            System.out.print(integer+" ");
        }
        System.out.println();

    }
}
//2
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RadixSort {
     public static final int ARRAY_LENGTH = 107;
    public static final int ARRAY_MAX_VALUE = 100;

    public static final String LOG_PREFIX = "=====================";
    public static final String LOG_SUFFIX = LOG_PREFIX;
    public static final String ARR_DELIMITER = "\t";

    public static void main(String[] args) {
        // 1. generate input array
        Random random = new Random();

        int[] intArr = new int[ARRAY_LENGTH];
        printLine(LOG_PREFIX + "The original array is:" + LOG_SUFFIX);
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = random.nextInt(ARRAY_MAX_VALUE);
            print(intArr[i]);
            if (i != intArr.length - 1) {
                print(ARR_DELIMITER);
            }
        }
        printLine("");

        // 2. radix sort
        radixSort(intArr);

        // 3. print sorted array
        printLine(LOG_PREFIX + "The sorted array is:" + LOG_SUFFIX);
        printLine(join(intArr, ARR_DELIMITER));
    }

    private static void radixSort(int[] intArr) {
        int maxDigits = String.valueOf(ARRAY_MAX_VALUE).length();
        for (int i = 1; i <= maxDigits; i++) {
            sortByDigit(intArr, i);
        }
    }

    private static void sortByDigit(int[] intArr, int i) {
        Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
        for (int item : intArr) {
            int digit = getDigit(item, i);
            List<Integer> list = map.get(digit);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(digit, (ArrayList<Integer>) list);
            }
            list.add(item);
        }
        int index = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int item : list) {
                intArr[index++] = item;
            }
        }
    }

    private static int getDigit(int item, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(item));
        String reverseStr = sb.reverse().toString();
        if (reverseStr.length() >= i) {
            return Integer.valueOf(reverseStr.charAt(i - 1));
        } else {
            return 0;
        }
    }

    public static void print(Object t) {
        System.out.print(t);
    }

    public static void printLine(Object t) {
        System.out.println(t);
    }

    public static String join(int[] arr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int element : arr) {
            sb.append(element);
            sb.append(delimiter);
        }
        return sb.substring(0, sb.length());
    

}
}
//3
import java.util.*;
public class QuickSort12 {
      public static void main(String[] args) {
        ArrayList<Integer> elements=new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Panjang Array : ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Elemen ke "+i+" : ");
            int nilai = scan.nextInt();
            elements.add(nilai);
        }
        System.out.println("Nilai Inputan : "+elements);
        randomquicksort(elements,0, elements.size()-1);
        System.out.print("Random Quick Sort : ");
        for(int i=0;i<elements.size();i++){
            System.out.print(elements.get(i)+" ");
        }
    }
    
    public static void swap(ArrayList<Integer> elements, int i, int j){
        int temp= elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
    
    public static int partition(ArrayList<Integer> elements, int beg, int end){
        
        int random=beg + ((int)Math.random()*(elements.size()))/(end-beg+1);
        int last=end;
        swap(elements, random, end);
        end--;
        
        while(beg<=end){
            if(elements.get(beg)<elements.get(last)) beg++; 
            else {
                swap(elements, beg, end);
                end--;
            }
        }
        swap(elements, beg, last);
        
        return beg;
    }
    
    public static void randomquicksort(ArrayList<Integer> elements, int beg, int end){
        if(beg>=end) return;
        if(beg<0) return;
        if(end>elements.size()-1) return;
        
        int pivot = partition(elements, beg, end);
        randomquicksort(elements, beg, pivot-1);
        randomquicksort(elements, pivot+1, end);
    }
}
//4
import java.util.*;
public class QuickSort1 {
      public static void main(String[] args) {
        ArrayList<Integer> elements=new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Panjang Array : ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Elemen ke "+i+" : ");
            int nilai = scan.nextInt();
            elements.add(nilai);
        }
        System.out.println("Nilai Inputan : "+elements);
        randomquicksort(elements,0, elements.size()-1);
        System.out.print("Random Quick Sort : ");
        for(int i=0;i<elements.size();i++){
            System.out.print(elements.get(i)+" ");
        }
    }
    
    public static void swap(ArrayList<Integer> elements, int i, int j){
        int temp= elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
    
    public static int partition(ArrayList<Integer> elements, int beg, int end){
        
        int random=beg + ((int)Math.random()*(elements.size()))/(end-beg+1);
        int last=end;
        swap(elements, random, end);
        end--;
        
        while(beg<=end){
            if(elements.get(beg)<elements.get(last)) beg++; 
            else {
                swap(elements, beg, end);
                end--;
            }
        }
        swap(elements, beg, last);
        
        return beg;
    }
    
    public static void randomquicksort(ArrayList<Integer> elements, int beg, int end){
        if(beg>=end) return;
        if(beg<0) return;
        if(end>elements.size()-1) return;
        
        int pivot = partition(elements, beg, end);
        randomquicksort(elements, beg, pivot-1);
        randomquicksort(elements, pivot+1, end);
    }
}
//5
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
    
public static void main(String[] args) {
            QuickSort app = new QuickSort();
	    List<Integer> input = app.generateRandomNumbers(6);
      
	    System.out.println("Nilai Inputan Random : "+input);
		
	    System.out.println("Setelah Di QuickSort : "+app.quicksort(input));
	    
	}
	private List<Integer> quicksort(List<Integer> input){
		
		if(input.size() <= 1){
			return input;
		}
		
		int middle = (int) Math.ceil((double)input.size() / 2);
		int pivot = input.get(middle);

		ArrayList<Integer> less = new ArrayList<Integer>();
		ArrayList<Integer> greater = new ArrayList<Integer>();
		
		for (int i = 0; i < input.size(); i++) {
			if(input.get(i) <= pivot){
				if(i == middle){
					continue;
				}
				less.add(input.get(i));
			}
			else{
				greater.add(input.get(i));
			}
		}
		
		return concatenate(quicksort(less), pivot, quicksort(greater));
	}
	private List<Integer> concatenate(List<Integer> less, int pivot, List<Integer> greater){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < less.size(); i++) {
			list.add(less.get(i));
		}
		
		list.add(pivot);
		
		for (int i = 0; i < greater.size(); i++) {
			list.add(greater.get(i));
		}
		
		return list;
	}
	
	
	private List<Integer> generateRandomNumbers(int n){
		
	    ArrayList<Integer> list = new ArrayList<Integer>(n);
	    Random random = new Random();
		
	    for (int i = 0; i < n; i++) {
		    list.add(random.nextInt(n * 10));
	    }
	
	    return list;
	}

}
//6
import java.util.*;
import java.lang.Math;

public class JavaApplication3 {
        private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i, j;
        System.out.print("Panjang Array : ");
        n = input.nextInt();
        ArrayList<Integer> data = new ArrayList();
        
        for (i = 0; i <= n - 1; i++) {
            System.out.print("elemen ke "+i+" : ");
            data.add(input.nextInt());
        }
        
        // Cetak Array Data
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print(" " + data.get(i));
        }
        System.out.println(" ]");
        
        // Memulai Insertion Sort
        i = 1;
        while (i < n) {
            int temp;
            
            temp = data.get(i);
            boolean next;
            
            next = true;
            j = i;
            while (next == true) {
                if (temp < data.get(j-1)) {
                    data.set(j, data.get(j-1));
                    j = j - 1;
                    if (j <= 0) {
                        next = false;
                    }
                } else {
                    next = false;
                }
            }
            data.set(j, temp);
            i = i + 1;
        }
        
        // Cetak Hasil Sorting
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print(" " + data.get(i));
        }
        System.out.println(" ]");
    }
}
//7
import java.util.*;
import java.lang.Math;

public class JavaApplication2 {
        private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i, j;
        System.out.print("Panjang Array : ");
        n = input.nextInt();
        ArrayList<Integer> data = new ArrayList();
        
        for (i = 0; i <= n - 1; i++) {
            System.out.println("Index ke "+i+" : ");
            data.add(input.nextInt());
        }
        
        // Cetak Array Data
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print(" " + data.get(i));
        }
        System.out.println(" ]");
        
        // Memulai Insertion Sort
        i = 1;
        while (i < n) {
            int temp;
            
            temp = data.get(i);
            boolean next;
            
            next = true;
            j = i;
            while (next == true) {
                if (temp < data.get(j-1)) {
                    data.set(j, data.get(j-1));
                    j = j - 1;
                    if (j <= 0) {
                        next = false;
                    }
                } else {
                    next = false;
                }
            }
            data.set(j, temp);
            i = i + 1;
        }
        
        // Cetak Hasil Sorting
        System.out.print("[ ");
        for (i = 0; i <= n - 1; i++) {
            System.out.print(" " + data.get(i));
        }
        System.out.println(" ]");
    }
}
//8
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
