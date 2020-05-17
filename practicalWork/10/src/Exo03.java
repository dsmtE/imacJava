import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class Exo03 {
    public static void main(String[] args) {
        final List<String> list2 =  new Random(0).ints(1_000_000, 0, 30).mapToObj(Integer::toString).collect(Collectors.toList());

        final int interNb = 1000;
        System.out.println(" elapsed time " + printAndTime(() -> Exo01.count(list2, "33"), interNb));
        System.out.println(" elapsed time " + printAndTime(() -> Exo01.count2(list2, "33"), interNb));
        System.out.println(" elapsed time " + printAndTime(() -> Exo01.count3(list2, "33"), interNb));

        // BONUS try and experiment
        VarArgsRunnable<Object, Long> countVarargs = a -> Exo01.count((List<String>) a[0], (String) a[1]);
        System.out.println(" elapsed time " + printAndTimebis(countVarargs, interNb, list2, "20"));
    }

    public static <T> Long printAndTime(final Supplier<T> funct, final int iterations) {
        Long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            funct.get();
        }
        Long end = System.nanoTime();
        
        return (end - start) / iterations;
    }

    //BONUS try and experiment
    @SafeVarargs
    public static <T, R> Long printAndTimebis(final VarArgsRunnable<T, R> funct, final int iterations, T...args) {
        Long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            funct.apply(args);
        }
        Long end = System.nanoTime();
        
        return (end - start) / iterations;
    }

}