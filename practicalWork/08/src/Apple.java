// ----- 02.05 ----- //
enum AppleKind {
    Golden("Golden"), 
    PinkLady("Pink Lady"), 
    GrannySmith("Granny Smith");
     
    private final String name;
    
    AppleKind(final String n) { name = n; } // Constructeur de l'enum

    // redefinition de la méthode toString pour avoir
    // une representation sous forme de chaine de notre type de pomme via une variable name
    @Override
    public String toString() { return name; } 
}

// ----- 02.01 ----- //
public class Apple implements Fruit {
    
    private final int weight;
    private final AppleKind type;

    public Apple(final int w, final AppleKind t) {
        weight = w;
        type = t;
    }

    public float price() { return weight/2; }

    @Override
    public String toString() {
        return "Apple " + type + "(" + Integer.toString(weight) + " g)";
    }
    
    @Override
	public boolean equals(final Object o) {

        if (o == null) { return false; } // si je suis une reférence null
        if (o == this) { return true; } // si c'est moi même je return true
        if (!(o instanceof Apple)) { return false; } // si je ne suis pas une pomme
        final Apple a = (Apple) o; // cast pour pouvoir utiliser les méthodes et variables comme une pomme

        // vérification des références nulles pour les objets ici pour le type de la pomme
        if(type == null && a.type != null) return false;

        return type.equals(a.type) && weight == a.weight;
    }

    // ----- 02.02 ----- //
    // source : https://www.baeldung.com/java-hashcode
    // la méthode hashCode permet de fournir aux collections telles que hashMap une clé dite de hachage qui à pour but de donner une valeur 
    // unique aux objets pour en interne, améliorer les opérations d'accès dans la collection
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (type == null ? 0 : type.hashCode());
        hash = 31 * hash + weight;
        return hash;
    }
    
}