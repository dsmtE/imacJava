public class ArrayShoppingCart {

    final static private int maxBook = 10;
    // ----- 01 -----
	// Il peut être intéressant de stocker le nombre maximum de livre dans une variable statique si ce nombre est commun à toute nos instances
    private Book[] books;
    private int booksNumber;

    ArrayShoppingCart() {
        books = new Book[maxBook];
        booksNumber = 0;
    }

    // ----- 02 -----
    Book[] add(Book book) {
        if( booksNumber < maxBook) {
            books[booksNumber++] = book;
        }
        return books;
    }

    // ----- 03 -----
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("ton caddie contient (");
        builder.append(booksNumber).append(" articles) : \n");
        for (Book b : books) {
            builder.append("- ").append(b).append("\n");
        }
        return builder.toString();
    }

    // ----- 04 -----
    Book longestTitle() {

        Book b = books[0];
        boolean sameSize = false;
        for (int i = 1; i < books.length; i++) {
            if ( b.title().length() <= books[i].title().length()) {
                if ( b.title().length() == books[i].title().length()) {
                    sameSize = true;
                }else {
                    sameSize = false;
                    b = books[i];
                }
            }
        }
        if(!sameSize) {
            return b;
        }
        return null;
    }
}