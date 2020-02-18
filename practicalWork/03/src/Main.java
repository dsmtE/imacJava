public class Main {
    public static void main(String[] args) {

        // ----- 03 -----
        var book = new Book();
        // System.out.println(book.title + ' ' + book.author);

        // le problème ici est que les variables title & author de la classe Book ont 
        // une visibilité private et ne sont donc pas accessible ici depuis une autre classe

        // ----- 04 -----

        // il y a quatres visibilité possibles en java :
        // - private
        // - public
        // - protected
        // - default (visibilité depuis le package)
        // on doit declarer les arguments en privé pour eviter les manipulations involontaires depuis l'exterieur de la classe
        // ce qui peut provoquer des problèmes ..
        // on doit plutôt utiliser des getters et setters pour modifier les variables internes ce qui permet de controller 
        // précisement ce que l'on peut faire

    }
}