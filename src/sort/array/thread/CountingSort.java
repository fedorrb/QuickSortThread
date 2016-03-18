package sort.array.thread;

public class CountingSort {

	private CountingSort() {
	}

	public static int[] sort(int[] array1) {
		int maxValue = findMax(array1);
		int[] counts = new int[maxValue + 1];
		updateCounts(array1, counts);
		populateCounts(array1, counts);
		return array1;
	}
	
	public static int[] sort(int[] array1, int maxValue){
		int[] counts = new int[maxValue + 1];
		updateCounts(array1, counts);
		populateCounts(array1, counts);
		return array1;		
	}

	private static int findMax(int[] unsorted) {
		int max = Integer.MIN_VALUE;
		for (int i : unsorted) {
			if (i > max)
				max = i;
		}
		return max;
	}

	private static void updateCounts(int[] unsorted, int[] counts) {
		for (int e : unsorted)
			counts[e]++;
	}

	private static void populateCounts(int[] unsorted, int[] counts) {
		int index = 0;
		for (int i = 0; i < counts.length; i++) {
			int e = counts[i];
			while (e > 0) {
				unsorted[index++] = i;
				e--;
			}
		}
	}
}
