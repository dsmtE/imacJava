import java.lang.Integer;
import java.util.Arrays;

public class Sum {

    // ----- 01 -----
    public static int[] convertIntFromString(String [] strings) { 
        int intergers[] = new int[strings.length];

        for (int i = 0; i < strings.length; ++i) {
            intergers[i] = Integer.parseInt(strings[i]);
        }
        return intergers;
    }

    // ----- 02 -----
    // Une méthode static peut être exécuter sans avoir à instancier la classe qui la contient. 
    // L'appel à une méthode statique se fait en utilisant le nom de la classe, plutôt que le nom de l'objet 
    // (comme la méthode parseInt de la classe Integer)



    // ----- 03 -----
    // si l'utilisateur entre des lettres une exception va être levée lors de l'utilisation de la méthode parseInt : java.lang.NumberFormatException

    // ----- 04 -----
    public static int sumFromintegerArray(int[] ints) {
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }
        return sum;
    }
    // ----- 05 -----
    public static void main(String[] args) {
        System.out.print("Integers : ");
        int[] intergers = convertIntFromString(args);
        System.out.println(Arrays.toString(intergers));
        
        // or using For-each
        // for (String s : args) {
        //     System.out.printf("%s ", s);
        // }

        int sum = sumFromintegerArray(intergers);
        System.out.println("Sum : " + sum);
    }

    
}