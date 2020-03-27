import java.util.HashMap;
import java.util.Map;

// ----- 02.01 ----- //
public class Basket {

    // ----- 02.04 ----- //
    private final Map<Fruit, Integer> selectionList;
    // le final ici signifie que l'on ne pouvrra pas lier à nouveau la variable pour qu'elle pointe vers une autre instance( en faisant : new ...)
    // La collection reste modifiable néanmoins
    // j'ai fait le choix d'utiliser l'interface Map qui est compatible avec hashMap pour plus de généralité

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("ton panier contient : (");
        str.append(selectionList.size()).append(" articles)\n");
        for (final Map.Entry<Fruit, Integer> entry : selectionList.entrySet()) {
            str.append("    - ").append(entry.getKey()).append(", quantity: ").append(entry.getValue()).append("\n");
        }
        str.append("prix total: ").append(getPrice()).append(" €");
        return str.toString();
    }

    public Basket() {
        selectionList = new HashMap<Fruit, Integer>();
    }

    // ----- 02.04 ----- //
    public Basket add(final Fruit f, final int quantity) {
        // j'utilise ici Integer plutot que int car le méthode get de notre Map selectionList retourne une reference null si l'objet n'est pas trouvé
        Integer currentQuantity = selectionList.get(f);
        if( currentQuantity != null) {// si le fruit existe déjà dans la liste
            selectionList.put(f, currentQuantity + quantity); // on modifie la quantité de fruits en ajoutant la  qunatité voulue
            return this;
        }
        
        // dans le cas contraire ( le fruit n'est pas déjà dans la liste on l'ajoute avec l'objet FruitSelection)
        selectionList.put(f, quantity);
        return this; // pas obligatoire de retourner l'élément this (la méthode peut etre void et ne rien retourner)
        // Retourner l'instance de l'objet permet de faire des appels plus concis & lisible los de l'ajout de multiple elements 
        // exemple : 
        //      basket.add(Apple, 3).add(Banana, 2).add(pineapple, 1);
        // au lien de :
        //      basket.add(Apple, 3);
        //      basket.add(Banana, 3);
        //      basket.add(pineapple, 3);
    }
    // ----- 02.04 ----- //
    public Basket add(final Fruit f) { return add(f, 1); } // ecriture plus consice avec quantité par defaut à 1 si on ne précise pas

    public float getPrice() {
        float price = 0;

        for (final Map.Entry<Fruit, Integer> entry : selectionList.entrySet()) { // on itère suur tout les éléments de la liste (couple Fruit/ quantitée)
            price += entry.getKey().price() * entry.getValue(); // on ajoute le prix du fruit fois sa quantité
        }
        return price;
    }
}