import java.util.Objects;

public class Book {
    // ----- Exo01:01 -----
    final private String author;
    final private String title;
    // ----- Exo03:03 -----
    final static private String noAuthor = "<no author>";

    // ----- Exo01:06 -----
    // le mot clé final permet d'indiquer que la valeur ne pourra pas changer après assignation
    public static void main(final String[] args) {

        // ----- Exo01:02 -----
        final var book = new Book();
        System.out.println(book.title + ' ' + book.author);

        // ici cela affiche "null null" car ici les objets author & title non pas été 
        // initialisées ils prennent donc une valeurs par défault "null"  
    }

    public Book() {
        this(" ", noAuthor);
    }

    // ----- Exo01:07 -----
    // ----- Exo02:11 -----
    public Book(final String t, final String a) {
        Objects.requireNonNull(t, "title cannot be null");
        Objects.requireNonNull(a, "author cannot be null");
        title = t;
        author = a;
    }
    // le code du main ne marche plus car il n'existe plus de constructeur ne prenant aucun argument, 
    // j'ai ici crée une constructeur supplémentaire ne prenant pas d'argument et initialisant le titre à " " et l'auteur à " " pour corriger le problème
    // il est aussi possible d'appeler le constructeur avec deux arguments "new Book("test", "enguerrand DE SMET")" au lieu de faire "new Book()"" 

    // ----- Exo01:08 -----
    // public Book(String title, String author) {
    //     this.title = title;
    //     this.author = author;
    // }
    // si les arguments du constructeur ont les même noms que les variables de l'objet il est nécessaire de différencier
    // les variables à l'aide du mot clé this

    // ----- Exo01:09 -----
    public Book(final String t) {
        this(t, noAuthor);
    }
    // ----- Exo01:11 -----
    // à l'aide du mot clé this il est possible d'appeler un autre constructeur depuis celui ci, 
    // ici ce constructeur appel le constructeur défini à la question 7 avec comme nom d'auteur "<No Author>"

    // ----- Exo01:10 -----
    // En analysant les argument passé en paramètres, le compilateur cherche la méthode 
    // avec la même signature au sein de la classe pour l'appeler

    // ----- Exo01:05 -----

    // un accesseur (ou getters en anglais) et une méthode qui permet d'accéder aux objets de la classe 
    // ici le nom et l'auteur du livre ne  vont pas changer donc il suffit de déclarer seulement des getters
    public String title() {
        return title;
    }

    public String author() {
        return title;
    }

     // ----- Exo02:02 -----
     // ----- Exo02:06 -----
     // ----- Exo02:07 -----
     // ----- Exo02:08 -----

     // l'annotation Override permet d'indiquer au compilateur que l'on redéfini cette méthod
    @Override
    public boolean equals(final Object o) { 
  
        if (o == this) { return true; } // si c'est moi même je return true
        if (!(o instanceof Book)) { return false; } // si c'est pas aussi un Book
        final Book b = (Book) o; // cast pour pouvoir utiliser les méthodes et variables comme un Book
        
        // ----- Exo02:09 -----
        // ici verification des type null
        if(title == null && b.title != null) return false;
        if(author == null && b.author != null) return false;

        return title.equals(b.title) && author.equals(b.author);
    }

    // ----- Exo03:01 -----
    // @Override
    // public String toString() { return "Book(" + title + " , " + author + ")"; }
    // ----- Exo03:02 -----
    // on utilise ici l'annotation @Override car on redéfini la méthode héritée de la classe Object
    @Override
    public String toString() {
        if( author == noAuthor) {
            return "Book(" + title  + ")"; 
        }else {
            return "Book(" + title + " , " + author + ")";
        }

    }
}
