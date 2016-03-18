package sort.array.thread;
/**
 * @author Fedorchuk Ruslan
 * http://courses.prometheus.org.ua/courses/KPI/Algorithms101/2015_Spring/about
 * 
 */
public class QuickSortOperation {

	/**
	 * Quick sort
	 * @param A input array
	 * @param p initial index
	 * @param r final index
	 * @return index pivot element
	 */
    public static int Partition(int[] A, int p, int r)
    {
        int x = A[r];
        int i = p - 1;
        int t = 0;
        for (int j = p; j <= r - 1; j++)
        {
            if (A[j] <= x)
            {
                i++;
                t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        t = A[r];
        A[r] = A[i+1];
        A[i+1] = t;

        i++;
        return i;
    }
    
    /**
     * Quick sorting by last element
     * @param A input array
     * @param p initial index
     * @param r final index
     */
    public static void QuickSort(int[] A, int p, int r)
    {
        int q = 0;
        if (p < r)
        {
            q = Partition(A, p, r);
            QuickSort(A, p, q-1);
            QuickSort(A, q+1, r);
        }
    }

    /**
     * Quick sorting by first element
     * @param A input array
     * @param p initial index
     * @param r final index
     */
    public static void QuickSortFirst(int[] A, int p, int r)
    {
        int q = 0;
        int t = A[r];
        if (p < r)
        {
            A[r] = A[p];
            A[p] = t;
            q = Partition(A, p, r);
            QuickSortFirst(A, p, q - 1);
            QuickSortFirst(A, q + 1, r);
        }
    }

    /**
     * Quick sorting by an average of three numbers
     * @param A input array
     * @param p initial index
     * @param r final index
     */
    public static void QuickSortMediana(int[] A, int p, int r)
    {
        int q = 0;
        int m = (p + r) / 2;
        int t = 0;
        int left = 0;
        if (p < r)
        {
            if ((r - p) == 1)
            {
                t = A[r];
                A[r] = A[p];
                A[p] = t;
            }
            else
            {
                if((A[p] >= Math.min(A[m],A[r])) && (A[p] <= Math.max(A[m],A[r])))
                    left = p;
                if (left == 0 && ((A[m] >= Math.min(A[p], A[r])) && (A[m] <= Math.max(A[p], A[r]))))
                    left = m;
                if (left == 0)
                    left = r;
                if (left != r)
                {
                    t = A[r];
                    A[r] = A[left];
                    A[left] = t;
                }
            }

            q = Partition(A, p, r);
            QuickSortMediana(A, p, q - 1);
            QuickSortMediana(A, q + 1, r);
        }
    }    
}
