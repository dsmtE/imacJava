import java.util.Objects;


// ----------
//  !!!! Classe pas demandée, c'est une autre facon de faire à la place de l'utilisation d'un hashMap

public class FruitSelection {
    private final Fruit fruit;
    private int quantity;
 
    FruitSelection(final Fruit f, final int q) throws IllegalArgumentException {
        if( q <= 0 ) { throw new IllegalArgumentException("la quantité voulue est invalide (<= 0)"); }
        fruit = Objects.requireNonNull(f);
        quantity = q;
    }

    // constructeur chainé pour avoir une quntité de 1 par defaut
    FruitSelection(final Fruit f) throws IllegalArgumentException {
        this(f, 1);
    }

    // getters & setters
    public Fruit fruit() { return fruit; }
    public int quantity() { return quantity; }
    public void setQuantity(final int q) { quantity = q; }
    public float getPrice() { return  fruit.price() * quantity; }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (!(o instanceof FruitSelection)) { return false; }
        final FruitSelection fs = (FruitSelection) o;
        // pas besoin de cette vérification car on le vérifi déjà dans le Constructeur avec bjects.requireNonNull(...)
        // if(fruit == null && fs.fruit != null) return false;
        return fruit.equals(fs.fruit) && quantity == fs.quantity;
    }

    @Override
    public int hashCode() { return (fruit.hashCode() + quantity) * quantity + fruit.hashCode();}

    @Override
    public String toString() { return fruit + ", quantity: " + quantity; }

}