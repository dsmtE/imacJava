public class Exo01 {
    public static void main(String[] args) {
        
        // ----- 01 -----

        var s = "toto";
        System.out.println(s.length());

        // s est de type String
        // java déduit le type depuis les objets que la variable manipule ici "toto"

        // ----- 02 -----

        var s1 = "toto";
        var s2 = s1;
        var s3 = new String(s1);

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        // ici s1 vaut une chaîne de caractère , s2 de même avec la même référence que celle de s1 ce qui implique (s1 == s2) = true
        // contrairement à s1 et s2 , s3 est alloué en mémoire dans le heap et contient donc une nouvelle référence, bien que sa valeur soit égal à s1 par copie

        // ----- 03 -----

        var s4 = "toto";
        var s5 = new String(s4);

        System.out.println( s4.equals(s5));

        // ----- 04 -----

        var s6 = "toto";
        var s7 = "toto";
  
        System.out.println(s6 == s7);

        // ici les deux variables font références au même objet créé dans le stack, 
        // en effet en java un String est immutable c'est à dire non modifiable et donc java 
        // ne crée ici qu'un objet qu'il assigne aux deux variables

        // ----- 05 -----

        // la String est l'un des objet les plus souvent utilisé et c'est pour cela que les dev java on choisi de définir l'objet String comme immutable
        // cela permet d'économiser la mémoire et de partager les chaînes égale comme précédemment dans le pool String
        // Cela permet aussi de crée certaines optimisations comme avec le hachage utilisé dans les collections de type maps

        // ----- 06 -----
        var s8 = "hello";
        s8.toUpperCase();
        System.out.println(s8);

    }
}