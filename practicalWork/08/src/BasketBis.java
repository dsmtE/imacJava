import java.util.ArrayList;

public class BasketBis {

    private final ArrayList<FruitSelection> selectionList;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("ton panier contient : (");
        str.append(selectionList.size()).append(" articles)\n");
        for (FruitSelection fs: selectionList) {
            str.append("    - ").append(fs).append("\n");
        }
        str.append("prix total: ").append(getPrice()).append(" €");
        return str.toString();
    }

    public BasketBis() {
        selectionList = new ArrayList<FruitSelection>();
    }

    public BasketBis add(final Fruit f, final int quantity) {
        // add verification for duplicate fruit in list
        for (FruitSelection fs : selectionList) {
            if(fs.fruit().equals(f)) { // si le fruit existe déjà dans la liste
                fs.setQuantity(fs.quantity() + quantity);
                return this;
            }
        }
        // dans le cas contraire ( le fruit n'est pas déjà dans la liste on l'ajoute avec l'objet FruitSelection)
        selectionList.add(new FruitSelection(f, quantity));
        return this;
    }
    public BasketBis add(final Fruit f) { return add(f, 1); }

    public float getPrice() {
        float price = 0;
        for (final FruitSelection fs : selectionList) {
            price += fs.getPrice();
        }
        return price;
    }
}