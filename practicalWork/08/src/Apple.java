import java.util.Objects;

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
    public String toString() { 
        return name;
    }
    // ou alors avec un switch plutôt qu'une variable supplémentaire
    // @Override
    // public String toString() { 
    //     switch (this) {
    //         case Golden:
    //             return "Golden";
    //         case PinkLady:
    //             return "PinkLady";
    //         case GrannySmith:
    //             return "Granny Smith";
    //         default:
    //             throw new AssertionError();
    //     }
    // }
}

// ----- 02.01 ----- //
public class Apple implements Fruit {
    
    private final int weight;
    private final AppleKind type;

    public Apple(final int w, final AppleKind t) {
        if (w < 0) { throw new IllegalArgumentException(); }
        weight = w;
        type = Objects.requireNonNull(t);
    }

    public int price() { return weight/2; }

    @Override
    public String toString() {
        return "Apple " + type + "(" + weight + " g)";
    }
    
    // private String kindToString(final AppleKind kind) {
    //     switch (kind) {
    //         case Golden:
    //             return "Golden";
    //         case PinkLady:
    //             return "PinkLady";
    //         case GrannySmith:
    //             return "Granny Smith";
    //         default:
    //             return "type error";
    //     }
    // }

    @Override
	public boolean equals(final Object o) {

        if (o == null) { return false; } // si je suis une reférence null
        if (o == this) { return true; } // si c'est moi même je return true
        if (!(o instanceof Apple)) { return false; } // si je ne suis pas une pomme
        final Apple a = (Apple) o; // cast pour pouvoir utiliser les méthodes et variables comme une pomme

        // vérification des références nulles pour les objets ici pour le type de la pomme
        // if(type == null && a.type != null) return false;
        // plus nécessaire avec le test IllegalArgumentException dans le constructeur

        return type.equals(a.type) && weight == a.weight;
    }

    // ----- 02.02 ----- //
    // source : https://www.baeldung.com/java-hashcode
    // la méthode hashCode permet de fournir aux collections telles que hashMap une clé dite de hachage qui à pour but de donner une valeur 
    // unique aux objets pour en interne, améliorer les opérations d'accès dans la collection
    @Override
    public int hashCode() {
        int hash = 7;
        // hash = 31 * hash + (type == null ? 0 : type.hashCode());
        // plus nécessaire avec le test IllegalArgumentException dans le constructeur
        hash = 31 * hash + type.hashCode();
        hash = 31 * hash + weight;
        return hash;
    }
    
}