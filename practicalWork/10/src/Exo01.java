import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exo01 {
    public static void main(final String[] args) {
        final List<String> list = List.of("hello", "world", "hello", "lambda");
        System.out.println(count(list, "hello"));
        System.out.println(count2(list, "hello"));
        System.out.println(countbis(list, "hello"));
    }

    // ----- 01.01 ----- //
    public static <T> Long count(final List<T> list, final T elem) {
        Long count = 0L;
        for (final T value : list) {
            if(value.equals(elem)) { count++; } 
        }
        return count;
    }

    // ou sans généricité, plus simple à comprendre
    // public static  Long count(final List<String> list, final String elem) {
    //     Long count = 0L;
    //     for (final String value : list) {
    //         if(value.equals(elem)) { count++; } 
    //     }
    //     return count;
    // }
    
    // ----- 01.02 ----- //
    // Pour obtenir un objet Stream à partir d'un List il suffit d'appeler la méthode .stream()
    // Pour filter un stream il faut utiliser la méthode .filter() avec un prédicat (Predicate<T>) ou une fonction lambda
    // Pour compter le nombre d'elements d'un stream on dois utiliser la méthode .count()

    public static <T> Long count2(final List<T> list, final T elem) {
        return list.stream().filter(isValue(elem)).count(); 
    }

    // or with lambda directly
    public static <T> Long countbis(final List<T> list, final T elem) {
        return list.stream().filter(v -> v.equals(elem)).count(); 
    }
    
    // le prédicat en question
    public static <T> Predicate<T> isValue(final T value) {
        return v -> v.equals(value);
    }

    /*
    si on ne veux pas utiliser de généricité on peut aussi écrire
    public static Long count2(final List<String> list, final String elem) {
        return list.stream().filter(isValue(elem)).count(); 
    }

    public static Predicate<String> isValue(final String str) {
        return v -> v.equals(str);
    }

    */
}
