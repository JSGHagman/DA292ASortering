public class QuickSortOptimized implements IntSorter {
    @Override
    public void sort(int[] a) {
        quicksort(a, 0, a.length - 1);
        System.out.println("Quicksort:");
    }

    static int partition(int[] a, int start, int end) {
        int pivotElement = a[end];

        int i = (start - 1);

        for (int j = start; j <= end; j++) {
            if (a[j] < pivotElement) {
                i++;
                swapIndex(a, i, j);
            }
        }
        swapIndex(a, i + 1, end);
        return (i + 1);
    }

    //Swaps index between two elements in array
    static void swapIndex(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void quicksort(int[] a, int start, int end) {
        if (start < end) {
            if (end - start < 48) {
                insertionsort(a, start, end);
            } else {
                int partitionIndex = partition(a, start, end);
                quicksort(a, start, partitionIndex - 1);
                quicksort(a, partitionIndex + 1, end);
            }
        }
    }

    static void insertionsort(int[] a, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            for (int j = i - 1; j >= start; j--) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    static void printResults(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 6, 6, 9, 8, 10};
        new QuickSortOptimized().sort(arr);
    }
}
