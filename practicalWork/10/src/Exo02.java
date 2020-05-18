import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exo02 {
    public static void main(final String[] args) {
        var list = List.of("hello", "world", "hello", "lambda");
        System.out.println(upperCase(list));  // [HELLO, WORLD, HELLO, LAMBDA]
        System.out.println(upperCase2(list));  // [HELLO, WORLD, HELLO, LAMBDA]
    }

    // ----- 02.01 ----- //
    public static List<String> upperCase(final List<String> list) {
        List<String> uppercases = new ArrayList<String>();
        for (String str : list) {
            uppercases.add(str.toUpperCase());
        }
        return uppercases;
    }

    // ----- 02.02 ----- //
    // La méthode Stream.map permet d'appliquer une fonction sur chaque elements du stream pour les transformer en d'autres elements et retourner le nouveau stream
    // on utilise ensuite la méthode forEach de l'objet Stream pour effectuer une operation pour chaque elements, ici, l'ajouter à notre liste uppercases destinée à être retournée
    public static List<String> upperCase2(final List<String> list) {
        List<String> uppercases = new ArrayList<String>();
        list.stream().map(str -> str.toUpperCase()).forEach( str -> uppercases.add(str));
        return uppercases;
    }

    // ----- 02.03 ----- //
    public static List<String> upperCase3(final List<String> list) {
        List<String> uppercases = new ArrayList<String>();
        list.stream().map(String::toUpperCase).forEach( str -> uppercases.add(str));
        return uppercases;
    }

    // ----- 02.04 ----- //
    // on utilise de preference ici .collect(Collectors.toList()) qui permet de convertir notre Stream en List sans passer 
    // par l'ajout de chaque elements dans une liste temporaire supplémentaire
    public static List<String> upperCase4(final List<String> list) {
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
