package sort.array.thread;
/**
 * взято у Pahanium для доказательства более 2-х потоков. 
 *
 */
public class Counter {
    private int num = 0;
    
    public synchronized void increment() {
        num++;
    }
    
    public synchronized void decrement() {
        num--;
        if (num == 0) {
            notify();
        }
    }
    
    public synchronized void waitAll() {
        while (num > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

	public synchronized int getNum() {
		return num;
	}

}
