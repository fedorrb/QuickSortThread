package sort.array.thread;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;

public class ThreadSort implements Runnable {
	private int p;
	private int r;
	private int[] A;
	private Counter counter;
	private ExecutorService executorService;

	public ThreadSort(int[] A, int p, int r, Counter counter, ExecutorService executorService) {
		super();
		this.p = p;
		this.r = r;
		this.A = A;
		this.counter = counter;
		counter.increment();
		this.executorService = executorService;		
	}

	@Override
	public void run() {
		if (p < r) {
			if ((r - p) > 50000) { //arrays smaller than 50,000 sort without creating threads
				int q = QuickSortOperation.Partition(A, p, r);
				executorService.execute(new ThreadSort(A, p, q - 1, counter, executorService));
				executorService.execute(new ThreadSort(A, q + 1, r, counter, executorService));
			} else {
				QuickSortOperation.QuickSort(A, p, r);
				//Arrays.parallelSort(A,p,r+1);
			}
		}
		counter.decrement();
		System.out.println(counter.getNum()); 
	}

}
