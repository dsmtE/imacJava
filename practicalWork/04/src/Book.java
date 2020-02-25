import java.util.Objects;

public class Book {

    final private String author;
    final private String title;
    final static private String noAuthor = "<no author>";

    public Book() {
        this(" ", noAuthor);
    }

    public Book(final String t, final String a) {
        Objects.requireNonNull(t, "title cannot be null");
        Objects.requireNonNull(a, "author cannot be null");
        title = t;
        author = a;
    }
    public Book(final String t) {
        this(t, noAuthor);
    }
    
    public String title() { return title;}
    public String author() { return title;}

    @Override
    public boolean equals(final Object o) { 
  
        if (o == this) { return true; } // si c'est moi même je return true
        if (!(o instanceof Book)) { return false; } // si c'est pas aussi un Book
        final Book b = (Book) o; // cast pour pouvoir utiliser les méthodes et variables comme un Book
        
        if(title == null && b.title != null) return false;
        if(author == null && b.author != null) return false;

        return title.equals(b.title) && author.equals(b.author);
    }

    @Override
    public String toString() {
        if( author == noAuthor) {
            return title; 
        }else {
            return title + " by " + author ;
        }
    }
}
