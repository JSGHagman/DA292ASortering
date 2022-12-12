import java.util.TreeMap;

public class SorteringStandardbiblotek implements IntSorter {
    // Obligatoriskt här är att använda en färdig ordnad symboltabell för att sätta in talen,
    // och sedan plocka ut dem i ordning. För att hantera att samma tal kan förekomma flera
    // gånger låter man nycklarna i symboltabellen vara talen som ska sorteras och värdena de
    // kopplas till vara antalet gånger varje nyckel förekommer.
    private TreeMap<Integer, Integer> map = new TreeMap<>();


    @Override
    public void sort(int[] array) {


        //Insättning av arrayens data i TreeMapen. Key är elementent från arrayen
        //medans value är hur många gånger elementet förekommer.
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])) {
                int value = map.get(array[i]);
                map.put(array[i], (value +1 ));

                //System.out.println("Inserted: key: " + array[i] + "with value: " + map.get(array[i]));
            }
            else {
                map.put(array[i], 1);
                //System.out.println("Inserted: key: " + array[i] + "with value: " + 1);
            }
        }




        // Plocka sedan ut nyckel/värde-paren igen med for / foreach
        // och lägg tillbaka rätt antal i arrayen.
        int j = 0;
        System.out.println("Arr length" + array.length);
        System.out.println("Map size: " + map.size());
        for (var p : map.entrySet()) {
             if(p.getValue() > 1){
                 for(int i = 0; i < p.getValue(); i++){
                     array[j] = p.getKey();
                     j++;
                 }
             }else{
                 array[j] = p.getKey();
                 j++;
             }


        }



    }
}
