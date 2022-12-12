public class QuickSortOptimized implements IntSorter{
    @Override
    public void sort(int[] a) {
        int n = a.length;
        if(n < 50){
            insertionsort(a);
        } else {
            quicksort(a, 0, a.length-1);
        }
    }

    static int partition(int[] a, int start, int end){
        int pivotElement = a[end];

        int i = (start - 1);

        for(int j = start; j <= end; j++){
            if(a[j] < pivotElement){
                i++;
                swapIndex(a, i, j);
            }
        }
        swapIndex(a, i+1, end);
        return (i + 1);
    }

    //Swaps index between two elements in array
    static void swapIndex(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void quicksort(int[] a, int start, int end){
        if(start < end){
            int partitionIndex = partition(a, start, end);
            quicksort(a, start, partitionIndex - 1);
            quicksort(a, partitionIndex + 1, end);
        }
    }

    static void insertionsort(int[] a){
        System.out.println("Insertion sort: ");
        int n = a.length;
        for(int i = 0; i < n; i++){
            int j = a[i];
            int k = i -1;

            while(k >= 0 && a[k] > j){
                a[k+1] = a[k];
                k = k - 1;
            }

            a[k+1] = j;
        }
        printResults(a);
    }

    static void printResults(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,7,6,6,9,8,10};
        new QuickSortOptimized().sort(arr);
    }
}
