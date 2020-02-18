import java.util.Arrays;

public class Exo04 {
    public static void main(String[] args) {
        int[] data = {10,42,32,800,5,31,512,16,90,24};

        System.out.println("Array: " + Arrays.toString(data));

        sort(data);

        System.out.println("Sorted Array: " + Arrays.toString(data));

    }

    // ----- Exo04:01 -----
    static void swap(int[] array, final int id1, final int id2) {
        if( id1 != id2) { // si ce n'est pas moi même, sinon on n'échange pas
            // swap de valeur entière utilisant des operations plutôt qu'une valeur temporaire
            array[id1] += array[id2];
            array[id2] = array[id1] - array[id2];
            array[id1] -= array[id2];
        }
    }

    // ----- Exo04:02 -----
    static int indexOfMin(int[] array) throws IllegalArgumentException {
        return indexOfMin(array, 0, array.length);
    }

    // ----- Exo04:03 -----
    static int indexOfMin(int[] array, final int from, final int to) throws IllegalArgumentException  {
        if (from < 0 || from > array.length-1) { throw new IllegalArgumentException ("Must be in range of array size(from)"); }
        if (to <= from || to > array.length) { throw new IllegalArgumentException ("Must be in range of array size(to)"); }

        int id = from;
        int min = array[from];

        for (int i = from+1 ; i < to; i++) {
            if(array[i] < min) {
                min = array[i];
                id = i;
            }
        }
        return id;
    }

    // ----- Exo04:04 -----

    static void sort(int[] array) {
        recursiveSort(array, 0, array.length); // on tri tout le tableau 
    }

    static void recursiveSort(int[] array, final int from, final int to) {
        int idMin = indexOfMin(array, from, to); // on cherche la valeur minimum
        swap(array, from, idMin); // on la place au début de notre sous tableau
        if(from +1 < to) { // tant qu'on est pas arrivé à la fin du tableau
            recursiveSort(array, from+1, to); // on tri le sous tableau qui ne l'est pas encore
        }
    }

}

