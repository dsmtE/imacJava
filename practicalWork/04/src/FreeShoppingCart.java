import java.util.ArrayList;
import java.util.Iterator;

public class FreeShoppingCart {
    
    private ArrayList<Book> books;

    // ----- 01 -----
    // Il faut spécifier à l'ArrayList qu'il contient des book avec : <Book>
    FreeShoppingCart() {
        books = new ArrayList<Book>();
    }

    ArrayList<Book> add(Book book) {
        books.add(book);
        return books;
    }

    // ----- 02 -----
    // Book longestTitle() {
    //     Book b = books.get(0);
    //     boolean sameSize = false;
    //     for (int i = 1; i < books.size(); i++) {
    //         if ( b.title().length() <= books.get(i).title().length()) {
    //             if ( b.title().length() == books.get(i).title().length()) {
    //                 sameSize = true;
    //             }else {
    //                 sameSize = false;
    //                 b = books.get(i);
    //             }
    //         }
    //     }
    //     if(!sameSize) {
    //         return b;
    //     }
    //     return null;
    // }

    // ----- 03 -----
    // Book longestTitle() {
    //     Book b = books.get(0);
    //     boolean sameSize = false;

    //     Iterator<Book> i = books.iterator();
    //     while (i.hasNext()) {
    //         if ( b.title().length() <= i.next().title().length()) {
    //             if ( b.title().length() == i.next().title().length()) {
    //                 sameSize = true;
    //             }else {
    //                 sameSize = false;
    //                 b = i.next();
    //             }
    //             
    //         }
    //     }

    //     if(!sameSize) {
    //         return b;
    //     }
    //     return null;
    // }

    // ----- 04 -----
    Book longestTitle() {
        Book b = books.get(0);
        boolean sameSize = false;

        for (Book book : books) {
            if ( b.title().length() <= book.title().length()) {
                if ( b.title().length() == book.title().length()) {
                    sameSize = true;
                }else {
                    sameSize = false;
                    b = book;
                }  
            }
        }
        
        if(!sameSize) {
            return b;
        }
        return null;
    }

    // ----- 05 -----
    // ----- 06 -----
    // Complexité en O(n) dans le pire des cas
    public void removeFirstOccurence(Book b) {
		this.books.remove(b);
    }
    // ----- 07 -----
    // Quand notre collection est plus complexe qu'une simple liste il est intéressants 
    // d'utiliser un itérateur quand on ne sais pas ou se trouvé l'objet en question, 
    // la boucle foreach est intéressante dans le cas ou l'on veux parcourir tout les élements de la collection  
    
    
}