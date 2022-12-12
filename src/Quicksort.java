public class Quicksort implements IntSorter {
    @Override
    public void sort(int[] a) {
       quicksort(a,0, a.length-1);
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

    static void quicksort(int[] a, int start, int end) throws StackOverflowError{
        if(start < end){
            int partitionIndex = partition(a, start, end);
            quicksort(a, start, partitionIndex - 1);
            quicksort(a, partitionIndex + 1, end);
        } else {
            return;
        }
    }

    static void printResults(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] a = { 10, 7, 8, 9, 1, 5, 12, 5};
        System.out.println("Before quicksort: ");
        printResults(a);
        quicksort(a, 0, a.length-1);
        System.out.println("After quicksort: ");
        printResults(a);
    }
}
