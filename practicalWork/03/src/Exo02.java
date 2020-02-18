import java.util.ArrayList;

public class Exo02 {
    public static void main(String[] args) {
        var b1 = new Book("Da Java Code", "Duke Brown");
        var b2 = b1;
        var b3 = new Book("Da Java Code", "Duke Brown");

        System.out.println(b1 == b2);
        System.out.println(b1 == b3);
        // ----- Exo02:01 -----
        // ici cela affiche true et false, en effet ici il y a une égalité par adresse via l'expression b1 = b2
        // mais b3 crée ici un nouvelle objet avec une nouvelle référence, l'opérateur == compare l'égalité des adresse
        // il est possible de définir une méthod pour les comparer de manière plus intuitive
    
        // ----- Exo02:03 -----
        // la méthode indexOf de ArrayList permet de retourner l'index de l'objet passer en paramètre
        // dans la liste dynamique en utilisant l'opérateur équals de cet objets, elle retourne -1 dans le 
        // cas ou l'objet n'est pas trouvé
        var list = new ArrayList<>();
        list.add(b1);
        System.out.println(list.indexOf(b2));
        System.out.println(list.indexOf(b3));

        // ----- Exo02:04 -----
        // ----- Exo02:05 -----
        // le problème ici est que la méthode indexOf utilise la méthode equals, 
        // si elle n'est pas redéfini il ne va alors pas trouvé l'index de l'objet et va seulement comparer 
        // leurs références par défault au lieu du comportement instinctive que l'on voudrais 
        
        // ----- Exo02:09 -----
        var aBook = new Book(null, null);
        var anoherBook = new Book(null, null);
        var list2 = new ArrayList<>();
        list2.add(aBook);
        System.out.println(list2.indexOf(anoherBook));
        // ici cela fonctionne pas : Exception in thread "main" java.lang.NullPointerException
        // on pointe vers une valeur null via l'objet Book
        // l'utilisation de equals() avec nos String ici sur une valeur null retourne l'erreur NullPointerException
        // il faut donc mettre en place une vérification pour éviter que cela soit null
        // on peut corriger le problème en utilisant des verification dans notre méthode equals

        // ----- Exo02:10 -----
        // il ne faut pas utiliser le null, jamais !

        // ----- Exo02:11 -----
        // Objects.requireNonNull cela permet de verifier que les paramètres passées ne sont pas null

    }
}