import java.util.Random;
import java.util.stream.IntStream;

public class Tester {
    public static void main(String[] args) {
        //Egen testare



        SorteringStandardbiblotek sorter = new SorteringStandardbiblotek();
        //Mergesort sorter = new Mergesort();
        int firstN = 20;
        test(sorter, firstN);

    }

    public static void test(IntSorter sorter, int firstN){
        System.out.println("Unordered: ");
        int multiplier = 1;
        int n = firstN;

        while(n < (firstN*4)){
            n = firstN * multiplier;
            int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100)).limit(n).toArray();
            multiplier = multiplier * 2;

            long before = System.currentTimeMillis() / 1000;
            System.out.println("\nBEFORE SORT:");
            for(int i = 0; i<randomIntsArray.length; i++){
                System.out.print(randomIntsArray[i] + " ");
            }
            System.out.println("\nAFTER SORT:");
            sorter.sort(randomIntsArray);
            long after = System.currentTimeMillis() / 1000;
            long time = after - before;
            //System.out.format("%s%s%4d", "T(", n, time);
        }





    }
}
