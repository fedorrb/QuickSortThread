package sort.array.thread;

public class ThreadSort implements Runnable {
	private int p;
	private int r;
	private int[] A;
	private Thread thr;

	public ThreadSort(int[] A, int p, int r) {
		super();
		this.p = p;
		this.r = r;
		this.A = A;
		thr = new Thread(this);
		thr.start();
	}

	@Override
	public void run() {
		if (p < r) {
			if ((r - p) > 50000) { //arrays smaller than 50,000 sort without creating threads
				int q = QuickSortOperation.Partition(A, p, r);
				try {
					ThreadSort ts1 = new ThreadSort(A, p, q - 1);
					ThreadSort ts2 = new ThreadSort(A, q + 1, r);
					ts1.getThr().join();
					ts2.getThr().join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				QuickSortOperation.QuickSort(A, p, r);
			}

		}
	}

	public Thread getThr() {
		return thr;
	}

}
