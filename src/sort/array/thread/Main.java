package sort.array.thread;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		int[] array1 = new int[10000000]; //very big array
		Test test = new Test(array1, 10000);
		test.fillArrayRandomNumber();
		int[] array2 = array1.clone();  
		int[] array3 = array1.clone();		
		//1 static method sort
		long tstart = System.currentTimeMillis();		
		//test.quickSort();
		CountingSort.sort(array1, 9999);
		long tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + "  ms" + "- static counting sort.");
		//System.out.println(Arrays.toString(array1));
		//2 arrays parallel sort
		tstart = System.currentTimeMillis();
		Arrays.parallelSort(array2);
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + "  ms" + "- arrays parallel sort.");		
		//3 multi thread sort
		ExecutorService executorService = Executors.newFixedThreadPool(50);
		Counter counter = new Counter();
		tstart = System.currentTimeMillis();
        executorService.execute(new ThreadSort(array3, 0, array3.length-1, counter, executorService));
        counter.waitAll();		
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + "  ms" + "- multi thread quick sort.");
		//check that the array is sorted
		String endStr = "OK"; 
		for(int i = 1; i < array1.length; i++){
			if(array1[i] != array2[i] || array3[i] != array2[i]){
				endStr = "Sorting error. Arrays are not equal.";
				break;
			}
		}
		System.out.println(endStr);
	}

}
