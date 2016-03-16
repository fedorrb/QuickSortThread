package sort.array.thread;

import java.util.Random;

public class Test {
	private int[] array;
	private int randomRange = 10000;

	public Test(int[] array, int randomRange) {
		super();
		this.array = array;
		this.randomRange = randomRange;
	}
	
	public void fillArrayRandomNumber(){
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(randomRange);
		}		
	}
	
	public void quickSort(){
		QuickSortOperation.QuickSort(array, 0, array.length-1);
		//QuickSortOperation.QuickSortFirst(array, 0, array.length-1);
		//QuickSortOperation.QuickSortMediana(array, 0, array.length-1);
	}
	
}
