import java.util.HashSet;
// ----- 02.01 ----- //
public class Main {
    public static void main(String[] args) {
        var apple1 = new Apple(20, AppleKind.Golden);
        var apple2 = new Apple(40, AppleKind.PinkLady);
        var pear = new Pear(5);

        var basket = new Basket();
        basket.add(apple1, 5);
        basket.add(apple2);
        basket.add(pear, 7);
        // pour que cela fonctionne il faut forcement redefinir la methode toString
        System.out.println(basket);

        // ----- 02.02 ----- //
        var set = new HashSet<Apple>();
        set.add(new Apple(20, AppleKind.Golden));
        // pour que cela fonctionne il faut  redefinir la methode hashcode
        System.out.println(set.contains(new Apple(20, AppleKind.Golden)));
    }
}