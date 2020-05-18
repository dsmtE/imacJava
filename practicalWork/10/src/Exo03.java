import java.util.List;

public class Exo03 {
    // ----- 03.01 ----- /
    /*
    On utilise plutôt la méthode mapToInt au lieu de la méthode map car celle ci retourne explicitement un IntStream au lieu d'un Stream<T> générique
    Je pense que cela est plus efficace par la suite lors de l'utilisation de notre reduce avec l'interface fonctionnelle Integer::sum pour 
    compter (évite un cast ou une interpretation inutile de l'objet contenu dans le stream comme les objets sont dans le cas de l'utilisation de mapToInt déjà des Integer)
    */
    public static <T> int count3(final List<T> list, final T elem) {
        return list.stream().filter(v -> v.equals(elem)).mapToInt(x -> 1).reduce(0, Integer::sum); 
    }


    public static void main(String[] args) {
        final List<String> list = List.of("hello", "world", "hello", "lambda");
        System.out.println(count3(list, "hello"));
    }
}