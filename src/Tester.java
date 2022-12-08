import java.util.Random;
import java.util.stream.IntStream;

public class Tester {
    public static void main(String[] args) {
        //Egen testare



        OptimizedMergesort sorter = new OptimizedMergesort();
        //Mergesort sorter = new Mergesort();
        int firstN = 100;
        test(sorter, firstN);

    }

    public static void test(IntSorter sorter, int firstN){
        System.out.println("Unordered: ");
        int multiplier = 1;
        int n = firstN;

        while(firstN < (firstN*15 +1)){
            n = firstN * multiplier;
            int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100000)).limit(n).toArray();
            multiplier = multiplier *2;

            long before = System.currentTimeMillis() / 1000;
            sorter.sort(randomIntsArray);
            long after = System.currentTimeMillis() / 1000;
            long time = after - before;
            System.out.format("%s%s%4d", "T(", n, time);
        }





    }
}
