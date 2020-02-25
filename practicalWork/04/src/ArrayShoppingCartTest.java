public class ArrayShoppingCartTest {
    public static void main(String[] args) {
        ArrayShoppingCart caddie = new ArrayShoppingCart();
        caddie.add((new Book("test", "enguerrand DE SMET")));
        caddie.add((new Book("Da Java Code", "Duke Brown")));
        System.out.println(caddie);
    }
}