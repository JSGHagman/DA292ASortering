public class Mergesort implements IntSorter{


    @Override
    public void sort(int[] a) {
        // Delar upp hela arrayen i par till dess att den inte går att dela upp mer.
        // Sorterar paren. När paren är sorterade slår man ihop paren.
        // Sedan sorterar man dem och slår ihop med nästa hög.
        // Till dess att hela högen är sorterad.

       sortering(a);

    }

    private void merge(int[] left, int[] right, int[] array){
        int i = 0; // <-- index för left array
        int j = 0; // <-- index för right array
        int k = 0; // <-- index för bas array
        int nl = left.length; // <-- längd för vänstra arrayen
        int nr = right.length; // <-- längd för högra arryen

        //Jämför vilket element som har lägst element och sätter in det först.
        while(i < nl && j < nr){
            if(left[i] <= right[j]){
                array[k] = left[i];
                k++;
                i++;
            }else{
                array[k] = right[j];
                k++;
                j++;
            }
        }

        //Om det finns element kvar i den vänstra arrayen så kopiera över dem.
        while(i < nl){
            array[k] = left[i];
            i++;
            k++;
        }

        //Om det finns element kvar i den högra arrayen kopiera över dem.
        while(j < nr){
            array[k] = right[j];
            j++;
            k++;
        }

    }

    //Rekursiv algoritm som delar upp arrayen i två delar, höger och vänster.
    //Anropar sedan sig själv tills dess att arrayerna endast är 1 element.
    private void sortering(int[] array) {

        int n = array.length;

        if (n < 2) {
            return;

        } else {
            int mid = n / 2;  // 8 / 2 = 4.
            int[] right = new int[n - mid]; //Högra delen 8 -4 = 4
            int[] left = new int[mid]; //Vänstra delen 3. 4.

            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }
            for (int i = 0; i < right.length; i++) {
                right[i] = array[i + mid];
            }

            sortering(left); //lägre halva
            sortering(right); //högre halva
            merge(left, right, array);

        }
    }
}
