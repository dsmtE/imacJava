import java.util.HashMap;
import java.util.Map;

// ----- 02.01 ----- //
public class Basket {

    // ----- 02.04 ----- //
    private final Map<Fruit, Integer> selectionList;
    // le final ici signifie que l'on ne pourra pas lier à nouveau la variable pour qu'elle pointe vers une autre instance( en faisant : new ...)
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
        if (currentQuantity == null) { // si le fuit n'existe pas déjà dans la liste
            currentQuantity = 0; // on défini la quantité actuelle à 0
        }
        // ou plus simplement 
        // Integer currentQuantity = selectionList.getOrDefault(f, 0);
        
        selectionList.put(f, currentQuantity + quantity); // on ajoute le fuit à la liste avec la bone quantité
        return this; // pas obligatoire de retourner l'élément this (la méthode peut être void et ne rien retourner)
        // Retourner l'instance de l'objet permet de faire des appels plus concis & lisible los de l'ajout de multiple elements 
        // exemple : 
        //      basket.add(Apple, 3).add(Banana, 2).add(pineapple, 1);
        // au lien de :
        //      basket.add(Apple, 3);
        //      basket.add(Banana, 3);
        //      basket.add(pineapple, 3);
    }
    // ----- 02.04 ----- //
    public Basket add(final Fruit f) { return add(f, 1); } // écriture plus concise avec quantité par défaut à 1 si on ne précise pas

    private int getPrice() {
        int price = 0;

        for (final Map.Entry<Fruit, Integer> entry : selectionList.entrySet()) { // on itère suur tout les éléments de la liste (couple Fruit/ quantité)
            price += entry.getKey().price() * entry.getValue(); // on ajoute le prix du fruit fois sa quantité
        }
        return price;
    }
}