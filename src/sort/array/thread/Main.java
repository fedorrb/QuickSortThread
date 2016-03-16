package sort.array.thread;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] array1 = new int[10000000]; //very big array
		Test test = new Test(array1, 10000);
		test.fillArrayRandomNumber();
		int[] array2 = array1.clone();  
		int[] array3 = array1.clone();		
		//1 static method sort
		long tstart = System.currentTimeMillis();		
		test.quickSort();
		long tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + "  ms" + "- static method sort.");
		//2 arrays parallel sort
		tstart = System.currentTimeMillis();
		Arrays.parallelSort(array2);
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + "  ms" + "- arrays parallel sort.");		
		//3 multi thread sort
		tstart = System.currentTimeMillis();
		ThreadSort threadSort = new ThreadSort(array3, 0, array3.length-1);
		try {
			threadSort.getThr().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + "  ms" + "- multi thread sort.");
		//check that the array is sorted
		for(int i = 1; i < array1.length; i++){
			if(array3[i] != array2[i]){
				System.out.println("Sorting error. Arrays are not equal.");
				break;
			}
		}
	}

}
