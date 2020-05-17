import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exo01 {
    public static void main(final String[] args) {
        final List<String> list = List.of("hello", "world", "hello", "lambda");
        System.out.println(count(list, "hello"));
        System.out.println(count2(list, "hello"));
        System.out.println(count3(list, "hello"));
    }

    public static <T> Long count(final List<T> list, final T elem) {
        Long count = 0L;
        for (final T value : list) {
            if(value.equals(elem)) { count++; } 
        }
        return count;
    }

    public static <T> Long count2(final List<T> list, final T elem) {
        return list.stream().filter(isValue(elem)).count(); 
    }
    // or with lambda
    public static <T> Long count3(final List<T> list, final T elem) {
        return list.stream().filter(v -> v.equals(elem)).count(); 
    }

    public static <T> Predicate<T> isValue(final T value) {
        return v -> v.equals(value);
    }
}
