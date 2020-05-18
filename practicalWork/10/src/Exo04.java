import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class Exo04 {
    public static void main(String[] args) {
        // ----- 04.01 ----- /
        // la variable list2 contient une liste de 1 000 000 nombres aléatoires compris entre 0 et 1 sous forme de chaînes de caractères 
        final List<String> list2 =  new Random(0).ints(1_000_000, 0, 100).mapToObj(Integer::toString).collect(Collectors.toList());

        final int interNb = 2000;
        System.out.println(" elapsed time " + printAndTime(() -> Exo01.count(list2, "33"), interNb));
        System.out.println(" elapsed time " + printAndTime(() -> Exo01.count2(list2, "33"), interNb));
        System.out.println(" elapsed time " + printAndTime(() -> Exo01.countbis(list2, "33"), interNb));
        System.out.println(" elapsed time " + printAndTime(() -> Exo03.count3(list2, "33"), interNb));

    }

    // ----- 04.2 ----- /
    /*
    Pour ne pas dupliquer le code on utilise l'interface fonctionnelle Supplier<T> .
    Supplier<T> représente une opération qui ne prend pas d’argument et qui retourne un résultat (de type T) avec la méthode get()
    Cette interface fonctionnelle peut être utilisée comme cible d'affectation pour une expression lambda
    source : https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html

    BONUS : le nombre d'iterations ici me permet de répéter l'appel à la fonction un certain nombre de fois et de retourner le temps moyen pour avoir une mesure plus fiable
    */
    public static <T> Long printAndTime(final Supplier<T> funct, final int iterations) {
        Long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            funct.get();
        }
        Long end = System.nanoTime();
        
        return (end - start) / iterations;
    }

    // ou sans généricité et sans iterations, plus simple à comprendre
    /*
    public static Long printAndTime(final Supplier<String> funct) {
        Long start = System.nanoTime();
        funct.get();
        Long end = System.nanoTime();
        return (end - start);
    }
    */

    // BONUS try and experiment
    /*
    VarArgsRunnable<Object, Long> countVarargs = a -> Exo01.count((List<String>) a[0], (String) a[1]);
    System.out.println(" elapsed time " + printAndTimebis(countVarargs, interNb, list2, "20"));

    @SafeVarargs
    public static <T, R> Long printAndTimebis(final VarArgsRunnable<T, R> funct, final int iterations, T...args) {
        Long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            funct.apply(args);
        }
        Long end = System.nanoTime();
        
        return (end - start) / iterations;
    }

    */

}