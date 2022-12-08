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
            if(map.containsKey(array[i])){
                if(map.get(array[i]) != null) {
                    map.put(array[i], map.get(array[i]) +1);
                }else{
                    map.put(array[i], 1);
                }
            }else{
                map.put(array[i], 1);
            }
        }

        // Plocka sedan ut nyckel/värde-paren igen med for / foreach
        // och lägg tillbaka rätt antal i arrayen.
        int j = 0;
        for (var p : map.entrySet()) {
            System.out.println( "Key: " + p.getKey() + " Value: " + p.getValue());
            if(p.getValue() != null){ //Säkerställer att nyckeln faktiskt har förekommit innan den sätts in.
                if(p.getValue() > 1){  //Om samma element förekommer flera gånger. Iterera genom dem och lägg till alla.
                    for(int i = 0; i < p.getValue(); i++){
                        array[j] = p.getKey();
                        System.out.println("Inserting key: " + p.getKey() + " at pos: " + j + " " + p.getValue() + " times" );
                        j++;
                    }
                }else{ //Element förekommer bara en gång.
                    array[j] = p.getKey();
                    j++;
                }
            }
        }


    }
}
