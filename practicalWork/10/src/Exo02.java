import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exo02 {
    public static void main(final String[] args) {
        var list = List.of("hello", "world", "hello", "lambda");
        System.out.println(upperCase(list));  // [HELLO, WORLD, HELLO, LAMBDA]
        System.out.println(upperCase2(list));  // [HELLO, WORLD, HELLO, LAMBDA]
    }

    public static List<String> upperCase(final List<String> list) {
        List<String> uppercases = new ArrayList<String>();
        for (String str : list) {
            uppercases.add(str.toUpperCase());
        }
        return uppercases;
    }

    public static List<String> upperCase2(final List<String> list) {
        List<String> uppercases = new ArrayList<String>();
        list.stream().map(str -> str.toUpperCase()).forEach( str -> uppercases.add(str));
        return uppercases;
    }

    public static List<String> upperCase3(final List<String> list) {
        List<String> uppercases = new ArrayList<String>();
        list.stream().map(String::toUpperCase).forEach( str -> uppercases.add(str));
        return uppercases;
    }

    public static List<String> upperCase4(final List<String> list) {
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
